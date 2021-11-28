package com.example.baitaptuan6.Sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.baitaptuan6.Model.Sms;
import java.util.ArrayList;
import java.util.List;

public class SmsDAO {
    private SQLiteDB sqLiteDB;

    public SmsDAO(SQLiteDB sqLiteDB) {
        this.sqLiteDB = sqLiteDB;
    }


    public void addSms(Sms sms) {
        SQLiteDatabase sqLiteDatabase = sqLiteDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("smsContent", sms.getContentSms());
        sqLiteDatabase.insert("sms", null, contentValues);
    }

    public List<Sms> getAllSms() {
        List<Sms> smsList = new ArrayList<>();
        String query = "SELECT * FROM sms limit 11";
        Cursor cursor = sqLiteDB.getWritableDatabase().rawQuery(query, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String smsContent = cursor.getString(1);
                Sms sms = new Sms();
                sms.setContentSms(smsContent);
                smsList.add(sms);
                cursor.moveToNext();
            }
        }
        return smsList;
    }
}
