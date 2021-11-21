package com.example.baitaptuan6.AsyncTaskDemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaptuan6.Model.Sms;
import com.example.baitaptuan6.Sqlite.SQLiteDB;
import com.example.baitaptuan6.Sqlite.SmsDAO;

import java.util.ArrayList;
import java.util.List;

public class MyAsyncTask extends AsyncTask<Void, List<Sms>, Void> {
    Activity contextParent;
    List<Sms> smsList = new ArrayList<>();
    SQLiteDB sqLiteDB;
    SmsDAO smsDAO;
    RecyclerView recyclerView;
    SmsAdapter smsAdapter;

    public MyAsyncTask(Activity contextParent, RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.contextParent = contextParent;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

//        smsAdapter = new SmsAdapter(smsList, contextParent);
//        recyclerView.setLayoutManager(new LinearLayoutManager(contextParent));
//        recyclerView.setAdapter(smsAdapter);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        sqLiteDB = new SQLiteDB(contextParent);
        smsDAO = new SmsDAO(sqLiteDB);
        smsList = smsDAO.getAllSms();
        publishProgress(smsList);
        return null;
    }

    @Override
    protected void onProgressUpdate(List<Sms>... values) {
        super.onProgressUpdate(values);
        smsAdapter = new SmsAdapter(values[0], contextParent);
        Log.i("Value: ", String.valueOf(values[0]));
        recyclerView.setLayoutManager(new LinearLayoutManager(contextParent));
        recyclerView.setAdapter(smsAdapter);
        smsAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
    }
}
