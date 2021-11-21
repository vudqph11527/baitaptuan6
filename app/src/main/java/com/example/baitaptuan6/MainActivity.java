package com.example.baitaptuan6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.baitaptuan6.MVP.ImageAdapter;
import com.example.baitaptuan6.MVP.Model.ImageModal;
import com.example.baitaptuan6.MVP.Presenter.IImagePresenter;
import com.example.baitaptuan6.MVP.Presenter.ImagePresenter;
import com.example.baitaptuan6.MVP.View.IView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {
    Button bGetNameApplication;
    TextView tvShowNameApplcation;
    ImagePresenter imagePresenter;
    ImageAdapter imageAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagePresenter = new ImagePresenter(this);
        recyclerView = findViewById(R.id.lv_show_data);
        // Instantiating the Presenter
        bGetNameApplication = findViewById(R.id.bt_get_name_applicaton);
        tvShowNameApplcation = findViewById(R.id.tv_show_name_application);
        bGetNameApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePresenter.getDataFromModal();
            }
        });
    }


    @Override
    public void displayMail(List<ImageModal> imageModalList) {
        imageAdapter = new ImageAdapter(this, imageModalList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(imageAdapter);
    }
}