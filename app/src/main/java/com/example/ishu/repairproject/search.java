package com.example.ishu.repairproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class search extends AppCompatActivity {

    DataBaseHelper db;
    String query1="";
    EditText etxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        db = new DataBaseHelper(this);
        etxt=(EditText)findViewById(R.id.etxt);


    }

    public void search(View view) {

        query1 = "";
        query1 = "SELECT * from CompanyDetails where trim(service)='" + etxt.getText().toString().toUpperCase()+ "'";
        Cursor c = db.getdata(query1);
        if (c.getCount() == 0) {
            Toast.makeText(search.this, "no data", Toast.LENGTH_SHORT).show();
        }
        else
        {

        }
    }

    public void addcust(View view) {
        Intent in =new Intent(search.this,addCustomer.class);
        startActivity(in);
    }

    public void addcomp(View view) {
        Intent in =new Intent(search.this,addCompany.class);
        startActivity(in);
    }
}
