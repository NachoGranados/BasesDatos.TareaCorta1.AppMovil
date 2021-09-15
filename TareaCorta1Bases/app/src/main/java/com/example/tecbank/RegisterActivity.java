package com.example.tecbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.tecbank.interfaces.UserRestAPI;
import com.example.tecbank.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private EditText idText;
    private EditText ssnText;
    private EditText usernameText;
    private EditText passwordText;
    private EditText firstNameText;
    private EditText lastNameText;
    private EditText addressText;
    private EditText phoneNumberText;
    private EditText incomeText;
    private EditText clientTypeText;
    private EditText tokenText;

    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idText = findViewById(R.id.editTextRegisterID);
        ssnText = findViewById(R.id.editTextRegisterSsn);
        usernameText = findViewById(R.id.editTextRegisterUsername);
        passwordText = findViewById(R.id.editTextRegisterPassword);
        firstNameText = findViewById(R.id.editTextRegisterFirstName);
        lastNameText = findViewById(R.id.editTextRegisterLastName);
        addressText = findViewById(R.id.editTextRegisterAddress);
        phoneNumberText = findViewById(R.id.editTextRegisterPhoneNumber);
        incomeText = findViewById(R.id.editTextRegisterIncome);
        clientTypeText = findViewById(R.id.editTextRegisterClientType);
        tokenText = findViewById(R.id.editTextRegisterToken);

        registerButton = (Button) findViewById(R.id.buttonRegisterRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = idText.getText().toString();
                String ssn = ssnText.getText().toString();
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                String firstName = firstNameText.getText().toString();
                String lastName = lastNameText.getText().toString();
                String address = addressText.getText().toString();
                String phoneNumber = phoneNumberText.getText().toString();
                String income = incomeText.getText().toString();
                String clientType = clientTypeText.getText().toString();
                String token = tokenText.getText().toString();

                User user = new User();

                user.setId(id);
                user.setSsn(ssn);
                user.setUsername(username);
                user.setPassword(password);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setAddress(address);
                user.setPhoneNumber(phoneNumber);
                user.setIncome(income);
                user.setClientType(clientType);
                user.setToken(token);

                postUser(user);

            }
        });

    }

    public void openLoginActivity() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    private void postUser(User user) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000/")
                 .addConverterFactory(GsonConverterFactory.create()).build();

        UserRestAPI userRestAPI = retrofit.create(UserRestAPI.class);

        Call<User> postCall = userRestAPI.postUser(user);
        postCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, retrofit2.Response<User> response) {

                try {

                    if (response.isSuccessful()) {

                        Toast.makeText(RegisterActivity.this, "Successful Register", Toast.LENGTH_SHORT).show();

                        openLoginActivity();

                    } else {

                        Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(RegisterActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(RegisterActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

}




















