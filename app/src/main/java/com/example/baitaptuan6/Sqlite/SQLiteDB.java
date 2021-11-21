package com.example.baitaptuan6.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sqlite_data";
    private static final int DATABASE_VERSION = 1;

    public SQLiteDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Bảng SMS
    public static final String NAME_SECOND_TABLE = "sms";
    public static final String COLUMN_SMS_ID = "smsID";
    public static final String COLUMN_SMS_CONTENT = "smsContent";


    private static final String DATABASE_CREATE_SMS = "create table " + NAME_SECOND_TABLE + "(" +
            COLUMN_SMS_ID + " integer primary key AUTOINCREMENT not null," +
            COLUMN_SMS_CONTENT + " varchar(500) not null)";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE_SMS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NAME_SECOND_TABLE);
        onCreate(sqLiteDatabase);
    }
}
