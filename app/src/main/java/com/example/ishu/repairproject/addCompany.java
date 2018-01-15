package com.example.ishu.repairproject;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class addCompany extends AppCompatActivity {


    DataBaseHelper db;
    EditText txtname,txtservice,txtfrom,txtto,txtloc,txtnum;
    public static ArrayList<Company> al=new ArrayList<Company>();
    int doesexits=0;
    String query1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);

        db = new DataBaseHelper(this);

        txtname=(EditText)findViewById(R.id.txtname);
        txtservice=(EditText)findViewById(R.id.txtservice);
        txtfrom=(EditText)findViewById(R.id.txtfrom);
        txtto=(EditText)findViewById(R.id.txtto);
        txtloc=(EditText)findViewById(R.id.txtloc);
        txtnum=(EditText)findViewById(R.id.txtnum);

    }

    public void submit(View view) {

        String str1=txtname.getText().toString().toUpperCase();
        String str2=txtservice.getText().toString().toUpperCase();
        String str3=txtfrom.getText().toString().toUpperCase();
        String str4=txtto.getText().toString().toUpperCase();
        String str5=txtloc.getText().toString().toUpperCase();
        String str6=txtnum.getText().toString().toUpperCase();

        query1 = "";
        query1 = "SELECT trim(companyname) from CompanyDetails where trim(companyname)='" + str1+ "'";
        Cursor c = db.getdata(query1);
        if (c.getCount() == 0) {

//            String partFilename =rnum;
//            storeCameraPhotoInSDCard(bitmap,partFilename);
//            Toast.makeText(getActivity(), "Image Saved to!!",
//                    Toast.LENGTH_SHORT).show();
            query1="INSERT INTO CompanyDetails VALUES('"+str1+"','-','"+str2+"','"+str6+"','"+str5+"','"+str3+"-"+str4+"','-','"+db.getDateTime()+"','-','"+db.getDateTime()+"');";
            Toast.makeText(addCompany.this, query1, Toast.LENGTH_SHORT).show();
        }
        else
            doesexits=1;

        db.settdata(query1);
        db.closeDB();

        if (DataBaseHelper.returnval.equalsIgnoreCase("success")) {
            Toast.makeText(addCompany.this, "data saved", Toast.LENGTH_SHORT).show();
        }
        else {
            if (doesexits == 1) {
                Toast.makeText(addCompany.this, "Record already exists!!", Toast.LENGTH_SHORT).show();
                return;
            }
        }

//        Intent in = new Intent(addCompany.this,Main2Activity.class);
//        in.putExtra("name",str1);
//        in.putExtra("service",str2);
//        in.putExtra("from",str3);
//        in.putExtra("to",str4);
//        in.putExtra("loc",str5);
//        in.putExtra("num",str6);
//        startActivity(in);

    }
}
