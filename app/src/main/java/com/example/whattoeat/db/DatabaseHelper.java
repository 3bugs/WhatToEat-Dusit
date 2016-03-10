package com.example.whattoeat.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Promlert on 3/10/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "what_to_eat.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "food";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_FILENAME = "file_name";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT, "
            + COL_FILENAME + " TEXT"
            + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "ข้าวผัด");
        cv.put(COL_FILENAME, "kao_pad.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ข้าวไข่เจียว");
        cv.put(COL_FILENAME, "kao_kai_jeaw.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ข้าวหน้าเป็ด");
        cv.put(COL_FILENAME, "kao_na_ped.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ข้าวมันไก่");
        cv.put(COL_FILENAME, "kao_mun_kai.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ข้าวหมูแดง");
        cv.put(COL_FILENAME, "kao_moo_dang.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราดหน้า");
        cv.put(COL_FILENAME, "rad_na.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ผัดซีอิ๊ว");
        cv.put(COL_FILENAME, "pad_sie_eew.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ผัดไทย");
        cv.put(COL_FILENAME, "pad_thai.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ส้มตำไก่ย่าง");
        cv.put(COL_FILENAME, "som_tum_kai_yang.jpg");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
