package com.example.diu.loginapppractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static Button buttonForLogin,buttonForSignUp;
    private static User user;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new Database(this);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        buttonForLogin=(Button)findViewById(R.id.login);
        buttonForSignUp=(Button)findViewById(R.id.signUp);
        loginOnClickListner();
        signUpClickListner();

    }

    //login onClickListnerMethod
    public void loginOnClickListner(){

        buttonForLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String username1=username.getText().toString();
                        String password1=password.getText().toString();
                        if(db.verifyLogin(username1,password1)){
                            Toast.makeText(MainActivity.this, "Login Succesfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(".ProfileActivity");
                            startActivity(intent);


                        }
                        else {
                            Toast.makeText(MainActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    //SignUp clickListner
    public void signUpClickListner(){
        buttonForSignUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(".SignUpActivity");
                        startActivity(intent);
                    }
                }
        );
    }
}
