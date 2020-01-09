package com.developer.timetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TheStudentAssistant.db";
    public static final String STUDENT_TABLE = "Student";
    public static final String SUBJECT_SE_IT = "SEIT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + STUDENT_TABLE + " (SAP TEXT PRIMARY KEY, NAME TEXT, PASSWORD TEXT, DEPARTMENT TEXT, YEAR TEXT)");
        db.execSQL("CREATE TABLE " + SUBJECT_SE_IT + " (SUBJECT TEXT, TEACHER TEXT, FROMTIME TEXT, TOTIME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
    }

    public boolean insertStudentData(String Sap, String Name, String Password, String Department, String Year){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SAP", Sap);
        contentValues.put("NAME", Name);
        contentValues.put("PASSWORD", Password);
        contentValues.put("DEPARTMENT", Department);
        contentValues.put("YEAR", Year);
        long result = db.insert("Student", null, contentValues);
        return result != -1;
    }

    public void subjectFiller(){
        SQLiteDatabase db = this.getWritableDatabase();

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM STUDENT", null);
        return result;
    }
}
