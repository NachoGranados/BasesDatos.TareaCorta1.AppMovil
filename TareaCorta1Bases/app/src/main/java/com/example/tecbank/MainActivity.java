package com.example.tecbank;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tecbank.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private TextView idTableText;
    private TextView ssnTableText;
    private TextView usernameTableText;
    private TextView passwordTableText;
    private TextView firstNameTableText;
    private TextView lastNameTableText;
    private TextView addressTableText;
    private TextView phoneNumberTableText;
    private TextView incomeTableText;
    private TextView clientTypeTableText;
    private TextView tokenTableText;

    private TextView usernameNavegator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.accountsFragment, R.id.cardsFragment, R.id.loansFragment)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        idTableText = findViewById(R.id.tableId);
        ssnTableText = findViewById(R.id.tableSsn);
        usernameTableText = findViewById(R.id.tableUsername);
        passwordTableText = findViewById(R.id.tablePassword);
        firstNameTableText = findViewById(R.id.tableFirstName);
        lastNameTableText = findViewById(R.id.tableLastName);
        addressTableText = findViewById(R.id.tableAddress);
        phoneNumberTableText = findViewById(R.id.tablePhoneNumber);
        incomeTableText = findViewById(R.id.tableIncome);
        clientTypeTableText = findViewById(R.id.tableClientType);
        tokenTableText = findViewById(R.id.tableToken);

        usernameNavegator = findViewById(R.id.navegatorUsername);

        Bundle bundle = getIntent().getExtras();

        String idText = bundle.getString("id");
        String ssnText = bundle.getString("ssn");
        String usernameText = bundle.getString("username");
        String passwordText = bundle.getString("password");
        String firstNameText = bundle.getString("firstName");
        String lastNameText = bundle.getString("lastName");
        String addressText = bundle.getString("address");
        String phoneNumberText = bundle.getString("phoneNumber");
        String incomeText = bundle.getString("income");
        String clientTypeText = bundle.getString("clientType");
        String tokenText = bundle.getString("token");

        idTableText.setText(idText);
        ssnTableText.setText(ssnText);
        usernameTableText.setText(usernameText);
        passwordTableText.setText(passwordText);
        firstNameTableText.setText(firstNameText);
        lastNameTableText.setText(lastNameText);
        addressTableText.setText(addressText);
        phoneNumberTableText.setText(phoneNumberText);
        incomeTableText.setText(incomeText);
        clientTypeTableText.setText(clientTypeText);
        tokenTableText.setText(tokenText);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}