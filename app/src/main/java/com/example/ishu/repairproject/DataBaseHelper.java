package com.example.ishu.repairproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataBaseHelper extends SQLiteOpenHelper {

	// Database Version
	private static final int DATABASE_VERSION = 1;

	public static String returnval = "";

	// Database Name
	private static final String DATABASE_NAME = "StudentDB";
	
	// Detail table create statement
	public final String CREATE_company_DETAIL = "CREATE TABLE IF NOT EXISTS "
			+ "CompanyDetails(companyname text,ownername text,services text,Phone_no text,address text,timings text,ent_by text,ent_dt DATETIME,edt_by text,edt_dt DATETIME)";

	public final String CREATE_customer_DETAIL = "CREATE TABLE IF NOT EXISTS "
			+ "CustomerDetails(companyname text,ownername,services text,Phone_no text,address text,timings text,ent_by text,ent_dt DATETIME,edt_by text,edt_dt DATETIME)";

	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// creating required tables
		db.execSQL(CREATE_company_DETAIL);
		db.execSQL(CREATE_customer_DETAIL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		db.execSQL("DROP TABLE IF EXISTS CompanyDetails");
		db.execSQL("DROP TABLE IF EXISTS CustomerDetails");

		// create new tables
		onCreate(db);
	}

	// ------------------------ "todos" table methods ----------------//

	// closing database
	public String settdata(String squery) {
		try {
			SQLiteDatabase db = this.getWritableDatabase();
			db.execSQL(squery);
			returnval="Success";
		}
		catch (Exception e)
		{
			returnval=e.getMessage();
		}
		return returnval;
	}

	public Cursor getdata(String squery) {
		SQLiteDatabase db = this.getReadableDatabase();
		String getstring="";

		Cursor c = db.rawQuery(squery, null);
		if (c.getCount() == 0) {
			returnval="Error";
		}
		return c;
	}

	// closing database
	public void closeDB() {
		SQLiteDatabase db = this.getReadableDatabase();
		if (db != null && db.isOpen())
			db.close();
	}
	/**
	 * get datetime
	 * */
	public String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm:ss", Locale.getDefault());
		Date date = new Date();
		return dateFormat.format(date);
	}
}
