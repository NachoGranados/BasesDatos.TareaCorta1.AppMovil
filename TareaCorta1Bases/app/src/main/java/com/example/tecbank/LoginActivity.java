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

public class LoginActivity extends AppCompatActivity {

    private EditText usernameText;
    private EditText passwordText;

    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameText = findViewById(R.id.editTextLoginUsername);
        passwordText = findViewById(R.id.editTextLoginPassword);

        loginButton = (Button) findViewById(R.id.buttonLoginLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getUser(usernameText.getText().toString());

            }
        });

        registerButton = (Button) findViewById(R.id.buttonLoginRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openRegisterActivity();

            }
        });

    }

    private void getUser(String username) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        UserRestAPI userRestAPI = retrofit.create(UserRestAPI.class);

        Call<User> getCall = userRestAPI.getUser(username);
        getCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, retrofit2.Response<User> response) {

                try {

                    if (response.isSuccessful()) {

                        User user = response.body();

                        if (passwordText.getText().toString().equals(user.getPassword())) {

                            Toast.makeText(LoginActivity.this, "Successful Login", Toast.LENGTH_SHORT).show();

                            openMainActivity(user);

                        } else {

                            Toast.makeText(LoginActivity.this, "Wrong Username or Password. Try Again", Toast.LENGTH_SHORT).show();

                        }

                    } else {

                        Toast.makeText(LoginActivity.this, "Wrong Username or Password. Try Again", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(LoginActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(LoginActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void openMainActivity(User user) {

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("id", user.getId());
        intent.putExtra("ssn", user.getSsn());
        intent.putExtra("username", user.getUsername());
        intent.putExtra("password", user.getPassword());
        intent.putExtra("firstName", user.getFirstName());
        intent.putExtra("lastName", user.getLastName());
        intent.putExtra("address", user.getAddress());
        intent.putExtra("phoneNumber", user.getPhoneNumber());
        intent.putExtra("income", user.getIncome());
        intent.putExtra("clientType", user.getClientType());
        intent.putExtra("token", user.getToken());

        startActivity(intent);

    }

    private void openRegisterActivity() {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }

}
