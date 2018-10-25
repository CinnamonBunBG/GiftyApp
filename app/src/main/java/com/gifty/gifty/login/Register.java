package com.gifty.gifty.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ScrollView;

import com.gifty.gifty.MainActivity;
import com.gifty.gifty.R;
import com.gifty.gifty.database.DatabaseLoginRegister;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = Register.this;
    private ScrollView scrollView;
    private TextInputLayout inputName,inputEmail, inputPassword,inputConfirm;
    private TextInputEditText editName,editEmail,editPassword,editConfirm;
    private AppCompatButton registerButton;
    private AppCompatTextView login;
    private CheckInput checkInput;
    private DatabaseLoginRegister dbHelp;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        assignView();
        attachListeners();
        getObjects();
    }


    //The attachment of elements from the view to variables
    private void assignView() {
        scrollView =  findViewById(R.id.register_view);
        inputName = findViewById(R.id.textInputLayoutName);
        inputEmail =  findViewById(R.id.textInputLayoutEmail);
        inputPassword = findViewById(R.id.textInputLayoutPassword);
        inputConfirm =  findViewById(R.id.textInputLayoutConfirmPassword);
        editName =  findViewById(R.id.textInputEditTextName);
        editEmail = findViewById(R.id.textInputEditTextEmail);
        editPassword =  findViewById(R.id.textInputEditTextPassword);
        editConfirm =  findViewById(R.id.textInputEditTextConfirmPassword);
        registerButton = findViewById(R.id.appCompatButtonRegister);
        login =  findViewById(R.id.appCompatTextViewLoginLink);

    }

   // Attach listeners to buttons
    private void attachListeners() {
        registerButton.setOnClickListener(this);
        login.setOnClickListener(this);

    }

 // Get external objects
    private void getObjects() {
        checkInput = new CheckInput(activity);
        dbHelp = new DatabaseLoginRegister(activity);
        user = new User();

    }

  //Handles the clicks
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.appCompatButtonRegister:
                send_to_SQL();
                break;

            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
        }
    }

    //Check the input and send off to SQL
    private void send_to_SQL() {
        if (!checkInput.inputChecker(editName, inputName, getString(R.string.error_message_1))) {
            return;
        }
        if (!checkInput.inputChecker(editEmail, inputEmail, getString(R.string.error_message_2))) {
            return;
        }
        if (!checkInput.checkEmail(editEmail, inputEmail, getString(R.string.error_message_2))) {
            return;
        }
        if (!checkInput.inputChecker(editPassword, inputPassword, getString(R.string.error_message_3))) {
            return;
        }
        if (!checkInput.doesInputMatch(editPassword, editConfirm,
                inputConfirm, getString(R.string.error_password_match))) {
            return;
        }

        if (!dbHelp.checkUser(editEmail.getText().toString().trim())) {

            user.setName(editName.getText().toString().trim());
            user.setEmail(editEmail.getText().toString().trim());
            user.setPassword(editPassword.getText().toString().trim());

            dbHelp.addUser(user);

            // Inform the user of successful registration
            Snackbar.make(scrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            clearInput();
            Intent newIntent = new Intent(activity, MainActivity.class);
            startActivity(newIntent);

        } else {
            // Inform the user the email is in the database
            Snackbar.make(scrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }


    }

 //set the fields to null (clear them)
    private void clearInput() {
        editName.setText(null);
        editEmail.setText(null);
        editPassword.setText(null);
        editConfirm.setText(null);
    }
}