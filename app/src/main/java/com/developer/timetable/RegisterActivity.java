package com.developer.timetable;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView tvHeader;
    EditText etName, etSap, etPassword;
    Button loginbtn, registerbtn, viewbutton;
    Spinner spinnerdept, spinneryear;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDb = new DatabaseHelper(this);
        initialize();
        setupSpinners();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerStudent();
            }
        });

        viewStudentData();
    }

    public void setupSpinners(){
        //Year spinner
        spinneryear = findViewById(R.id.yearSpinner);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(RegisterActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.years));
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneryear.setAdapter(yearAdapter);
        spinneryear.setPrompt("Select your year");

        //Department spinner
        spinnerdept = findViewById(R.id.departmentSpinner);
        ArrayAdapter<String> deptAdapter = new ArrayAdapter<>(RegisterActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.departments));
        deptAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerdept.setAdapter(deptAdapter);
        spinnerdept.setPrompt("Select your department");
    }

    private void initialize(){
        Typeface productsans = Typeface.createFromAsset(getAssets(), "fonts/product_sans.ttf");
        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/roboto.ttf");

        tvHeader = findViewById(R.id.tvRegisterHeader);
        etName = findViewById(R.id.etRegisterName);
        etSap = findViewById(R.id.etRegisterSAP);
        etPassword = findViewById(R.id.etRegisterPassword);
        registerbtn = findViewById(R.id.btnRegister);
        viewbutton = findViewById(R.id.btnView);
        loginbtn = findViewById(R.id.btnRegisterLogin);

        tvHeader.setTypeface(productsans);
        etName.setTypeface(productsans);
        etSap.setTypeface(productsans);
        etPassword.setTypeface(productsans);
        registerbtn.setTypeface(productsans);
        viewbutton.setTypeface(productsans);
        loginbtn.setTypeface(productsans);
    }

    private void registerStudent(){
        String Sap = etSap.getText().toString().trim();
        String Name = etName.getText().toString().trim();
        String Password = etPassword.getText().toString().trim();
        String Year = null, Dept = null;
        int yearitem = spinneryear.getSelectedItemPosition();
        switch (yearitem){
            case 0: Year = "FE"; break;
            case 1: Year = "SE"; break;
            case 2: Year = "TE"; break;
            case 3: Year = "BE"; break;
        }
        int deptitem = spinnerdept.getSelectedItemPosition();
        switch (deptitem){
            case 0: Dept = "Biomedical"; break;
            case 1: Dept = "Chemical"; break;
            case 2: Dept = "Computer"; break;
            case 3: Dept = "Electrical"; break;
            case 4: Dept = "EXTC"; break;
            case 5: Dept = "IT"; break;
            case 6: Dept = "Mechanical"; break;
            case 7: Dept = "Production"; break;
        }

        boolean isInserted = false;
        isInserted = myDb.insertStudentData(Sap, Name, Password, Dept, Year);

        if(isInserted == true)
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();
    }

    public void viewStudentData(){
        viewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = myDb.getAllData();
                if(result.getCount() == 0){
                    Toast.makeText(RegisterActivity.this, "No data", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(result.moveToNext()){
                    buffer.append("Sap: " + result.getString(0) + "\n" ); //starts with 0
                    buffer.append("Name: " + result.getString(1) + "\n" );
                    buffer.append("Year: " + result.getString(4) + "\n" );
                    buffer.append("Department: " + result.getString(3) + "\n" );
                }

                showData("Data", buffer.toString());
            }
        });
    }

    public void showData(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

