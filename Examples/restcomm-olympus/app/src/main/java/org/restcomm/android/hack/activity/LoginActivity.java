package org.restcomm.android.hack.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.restcomm.android.hack.api.AuthInterface;
import org.restcomm.android.hack.api.CallbackInterface;
import org.restcomm.android.hack.db.Auths;
import org.restcomm.android.hack.model.Auth;
import org.restcomm.android.hack.model.RestError;
import org.restcomm.android.hack.model.body.BAuth;
import org.restcomm.android.hack.utils.Static;
import org.restcomm.android.olympus.R;

import retrofit.RestAdapter;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText mUserNameView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    private RestAdapter adapter = new RestAdapter.Builder().setEndpoint(Static.URL).build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Auths auth = Auths.getAuth();
        if (auth != null) {
            auth.deleteAuth();
        }

        mUserNameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);

        Button mSignInButton = (Button) findViewById(R.id.sign_in_button);
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void attemptLogin() {
        mUserNameView.setError(null);
        mPasswordView.setError(null);

        String username = mUserNameView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        if (TextUtils.isEmpty(username) && !isUserNameValid(username)) {
            mUserNameView.setError(getString(R.string.error_field_required));
            focusView = mUserNameView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            signInOrSignUp(username, password);
        }
    }

    private void signInOrSignUp(final String user, String pass) {
        final AuthInterface authInterface = adapter.create(AuthInterface.class);

        BAuth bAuth = new BAuth(user, pass);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();

        authInterface.signUpOrSignin(bAuth, new CallbackInterface<Auth>(LoginActivity.this) {
            @Override
            public void failure(RestError restError) {
                progressDialog.dismiss();
                Log.e("error", restError.getCode() + "");
                Toast.makeText(LoginActivity.this, restError.getErrorDetails(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void success(Auth auth, Response response) {
                Auths authdb = new Auths();
                authdb.username = user;
                authdb.accessToken = auth.getResponse().getMessage().getToken();
                authdb.save();
                progressDialog.dismiss();

                if (!auth.getResponse().getMessage().getUser().getPackageId().isEmpty()) {
                    Intent intent = new Intent(LoginActivity.this, RegisterDeviceActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(LoginActivity.this, PackagesActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }

    private boolean isUserNameValid(String username) {
        return username.length() > 2;
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 2;
    }

}

