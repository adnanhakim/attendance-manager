package com.developer.timetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelperSubjects extends SQLiteOpenHelper {

    private static String DB_NAME = "SE_IT";
    private static String DB_PATH = "";
    private SQLiteDatabase db;
    private Context context;

    public DatabaseHelperSubjects(Context context) {
        super(context, DB_NAME, null, 1);
        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void checkAndCopyDatabase() {
        boolean dbExist = checkDatabase();
        if (dbExist) {
            Log.d("TAG", "Database already exists");
        } else {
            this.getReadableDatabase();
        }
    }

    public boolean checkDatabase() {
        SQLiteDatabase checkDB = null;
        String path = DB_PATH + DB_NAME;
        checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }

    public void copyDatabase() {
        try {
            InputStream inputStream = context.getAssets().open(DB_NAME);
            String outFileName = DB_PATH + DB_NAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public synchronized void close() {
        if (db != null) {
            db.close();
        }
        super.close();
    }
}
