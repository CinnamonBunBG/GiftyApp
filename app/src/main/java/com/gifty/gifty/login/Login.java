package com.gifty.gifty.login;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.gifty.gifty.MainActivity;
import com.gifty.gifty.R;
import com.gifty.gifty.database.DatabaseLoginRegister;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = Login.this;

    private android.widget.ScrollView ScrollView;

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;

    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;

    private AppCompatButton appCompatButtonLogin;

    private AppCompatTextView textViewLinkRegister;

    private CheckInput checkTheInput;
    private DatabaseLoginRegister databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        assignViews();
        attachListeners();
        getObjects();
    }


    //The attachment of elements from the view to variables
    private void assignViews() {

        ScrollView =  findViewById(R.id.scroll_view);

        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword =  findViewById(R.id.textInputLayoutPassword);

        textInputEditTextEmail =  findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword =  findViewById(R.id.textInputEditTextPassword);

        appCompatButtonLogin =  findViewById(R.id.appCompatButtonLogin);

        textViewLinkRegister =  findViewById(R.id.textViewLinkRegister);

    }

    // Attach listeners to buttons

    private void attachListeners() {
        appCompatButtonLogin.setOnClickListener(this);
        textViewLinkRegister.setOnClickListener(this);
    }


    // Get external objects
    private void getObjects() {
        databaseHelper = new DatabaseLoginRegister (activity);
        checkTheInput = new CheckInput(activity);

    }


    //Handles the clicks
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonLogin:
                verifyFromSQLite();
                break;
            case R.id.textViewLinkRegister:

                Intent intentRegister = new Intent(getApplicationContext(), Register.class);
                startActivity(intentRegister);
                break;
        }
    }

    // Check the input for login

    private void verifyFromSQLite() {
        if (!checkTheInput.inputChecker(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_2))) {
            return;
        }
        if (!checkTheInput.checkEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_2))) {
            return;
        }
        if (!checkTheInput.inputChecker(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_2))) {
            return;
        }

        if (databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim()
                , textInputEditTextPassword.getText().toString().trim())) {


            Intent accountsIntent = new Intent(activity, MainActivity.class);
            accountsIntent.putExtra("EMAIL", textInputEditTextEmail.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);


        } else {
            // inform the user of a mistake
            Snackbar.make(ScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }

   //clear the fields
    private void emptyInputEditText() {
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
    }
}