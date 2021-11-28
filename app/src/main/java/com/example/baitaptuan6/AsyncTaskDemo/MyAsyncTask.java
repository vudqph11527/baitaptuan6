package com.example.baitaptuan6.AsyncTaskDemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaptuan6.Model.Sms;
import com.example.baitaptuan6.Sqlite.SQLiteDB;
import com.example.baitaptuan6.Sqlite.SmsDAO;

import java.util.ArrayList;
import java.util.List;

public class MyAsyncTask extends AsyncTask<Void, Void, List<Sms>> {
    Activity contextParent;
    List<Sms> smsList = new ArrayList<>();
    List<Sms> smsList2 = new ArrayList<>();
    SQLiteDB sqLiteDB;
    SmsDAO smsDAO;
    RecyclerView recyclerView;
    SmsAdapter smsAdapter;
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    LinearLayoutManager mLayoutManager;

    public MyAsyncTask(Activity contextParent, RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.contextParent = contextParent;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mLayoutManager = new LinearLayoutManager(contextParent);
        smsAdapter = new SmsAdapter(smsList, contextParent);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(smsAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected List<Sms> doInBackground(Void... voids) {
        sqLiteDB = new SQLiteDB(contextParent);
        smsDAO = new SmsDAO(sqLiteDB);
        smsList = smsDAO.getAllSms();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = mLayoutManager.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();
                Log.i("pastVisiblesItems", String.valueOf(dy));
                if (dy > 0) {
                    Log.i("dy", String.valueOf(dy));
                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            loading = false;
                            smsList = smsDAO.getAllSms();
                            loading = true;
                            Log.i("smsList", String.valueOf(smsList));
                        }
                    }
                }
            }
        });
        return smsList;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(List<Sms> unused) {
        super.onPostExecute(unused);
//        mLayoutManager = new LinearLayoutManager(contextParent);
//        for (int i = 0; i < 10; i++) {
//
//        }
//
//        smsAdapter = new SmsAdapter(unused, contextParent);
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setAdapter(smsAdapter);
//        smsAdapter.notifyDataSetChanged();

//        Log.i("DYdasd", String.valueOf(dy));


    }
}
