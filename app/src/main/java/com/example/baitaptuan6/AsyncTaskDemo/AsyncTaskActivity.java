package com.example.baitaptuan6.AsyncTaskDemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.baitaptuan6.Model.Sms;
import com.example.baitaptuan6.R;
import com.example.baitaptuan6.Sqlite.SQLiteDB;
import com.example.baitaptuan6.Sqlite.SmsDAO;

import java.util.ArrayList;
import java.util.List;

public class AsyncTaskActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAsyncTask myAsyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        recyclerView = findViewById(R.id.rc_list_show_data_asyncTask);
        myAsyncTask = new MyAsyncTask(this, recyclerView);
        myAsyncTask.execute();

    }
}