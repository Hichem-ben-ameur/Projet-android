package com.example.rdef.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.rdef.Entity.Visiteur;
import com.example.rdef.Entity.developpeur;
import com.example.rdef.Inscrit_dev;
import com.example.rdef.Inscrit_visiteur;
import com.example.rdef.R;
import com.example.rdef.Session_dev;
import com.example.rdef.Session_visiteur;
import com.example.rdef.controleur.DeveloppeurBDD;

public class LoginActivity2 extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    DeveloppeurBDD db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);
final TextView nonInscrit =findViewById(R.id.not_registred);
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
         db=new DeveloppeurBDD(this);
        final Intent intent = new Intent(this, Session_visiteur.class);
        final Intent intent2 = new Intent(this, Inscrit_visiteur.class);

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });
nonInscrit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        startActivity(intent2);
    }
});
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //loginViewModel.login(usernameEditText.getText().toString(),passwordEditText.getText().toString());
               // DeveloppeurBDD developpeurBDD=new DeveloppeurBDD(this);
                db.open();
              Visiteur visiteur=db.getVisiteur(usernameEditText.getText().toString(),passwordEditText.getText().toString());
               if(visiteur!=null)
               {
                   loadingProgressBar.setVisibility(View.VISIBLE);
                   if(visiteur.getType()=="Entreprise")
                   {loginViewModel.login(visiteur.getNom_entreprise(),"");}
                   else
                   {loginViewModel.login(visiteur.getNom(),visiteur.getPrenom());}
                   intent.putExtra("nom",visiteur.getNom());
                   intent.putExtra("prenom",visiteur.getPrenom());
                   intent.putExtra("nom_entreprise",visiteur.getNom_entreprise());
                   intent.putExtra("responsable_rh",visiteur.getResponsable_rh());
                   intent.putExtra("telephone",visiteur.getTelephone());
                   intent.putExtra("type",visiteur.getType());
                   intent.putExtra("mail",visiteur.getMail());
                   startActivity(intent);
               }
               else{
                   //loginViewModel.setMessage();
                   usernameEditText.setError("connexion echoué");
                   passwordEditText.setError("connexion echoué");

               }
                // Toast.makeText(this, "Ce livre existe dans la BDD"+developpeur.getId_developpeur(), Toast.LENGTH_LONG).show();

                db.close();
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}
