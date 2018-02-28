package com.example.diu.loginapppractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private Spinner genderSpinner, userTypeSpinner;
    private Button signUp;
    private EditText userName,email,phone,password;
    private String gender,userType;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        database = new Database(this);
        findView();
        signUp();

    }

    private void findView() {
        genderSpinner = (Spinner) findViewById(R.id.gender_spinner);
        userTypeSpinner = (Spinner) findViewById(R.id.userType_spinner);
        userName=(EditText)findViewById(R.id.username);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.phone);
        password=(EditText)findViewById(R.id.password);
        signUp=(Button)findViewById(R.id.signUp);
        setGenderSpinnerValue();
        setUserTypeSpinnerValue();

    }

    private void setUserTypeSpinnerValue() {

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.userType_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        userTypeSpinner.setAdapter(adapter1);

        userTypeSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        userType=userTypeSpinner.getItemAtPosition(position).toString();
                        userType=(String)parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );
    }

    private void setGenderSpinnerValue() {
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        genderSpinner.setAdapter(adapter);

        genderSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        gender=genderSpinner.getItemAtPosition(position).toString();
                        gender=(String)parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );
    }

    public void insertUserInfromation(){
        User user=new User();
        user.setUsername(userName.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPhone(phone.getText().toString());
        user.setPassword(password.getText().toString());
        user.setGender(gender);
        user.setUserType(userType);
        if(database.insertUserInfo(user)>0){
            Toast.makeText(this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Sign Up Failled", Toast.LENGTH_SHORT).show();
        }

    }

    public void signUpOnClick(){
        if(!userName.equals("")&&!email.equals("")&&!phone.equals("")&&!password.equals("")&&!gender.equals("")&&!userType.equals("")){
            insertUserInfromation();
        }
        else{
            Toast.makeText(this, "Please provide information", Toast.LENGTH_SHORT).show();
        }
    }

    public void signUp(){
        signUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        signUpOnClick();
                    }
                }
        );
    }
}
