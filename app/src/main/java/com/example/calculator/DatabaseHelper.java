package com.example.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {


    // Declaring Database Variables
    public static final String DATABASE_NAME = "history.db";
    public static final String TABLE_NAME = "calculations_history";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "calculations";
    public static final String COL_3 = "result";
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static final String COL_4 = sdf.format(new Date().getTime());

    // -----------------------

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,1);
//        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, calculations TEXT, result TEXT, date DATETIME DEFAULT CURRENT_TIMESTAMP)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // TO INSERT THE DATA
    public boolean insertData(String calculations, String result) {
        // Create SQLite Db instance
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, calculations);
        contentValues.put(COL_3, result);

        // insert the data
        long res = db.insert(TABLE_NAME, null, contentValues);

        // above method returns -1 incase of any error
        if (res == -1) {
            return false;
        }
        return true;

    }


    // To view all the data in db
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE date <= date('now','-1 day')", null);
        Cursor res = db.rawQuery("select * from (select * from calculations_history order by date DESC limit 5) order by date ASC;\n", null);
        return res;
    }


    // UPDATE DATA
    public boolean updateData(String id, String fname, String lname, int marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, fname);
        contentValues.put(COL_3, lname);
        contentValues.put(COL_4, marks);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});
        return true;
    }

    // Delete Data
    public boolean deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int isDeleted = db.delete(TABLE_NAME, "ID = ?", new String[] {id});

        if (isDeleted == 0) {
            return false;
        }
        return true;
    }

}
