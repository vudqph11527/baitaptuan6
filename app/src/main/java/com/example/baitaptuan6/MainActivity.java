package com.example.baitaptuan6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitaptuan6.MVP.ImageAdapter;
import com.example.baitaptuan6.MVP.Model.ImageModal;
import com.example.baitaptuan6.MVP.Presenter.IImagePresenter;
import com.example.baitaptuan6.MVP.Presenter.ImagePresenter;
import com.example.baitaptuan6.MVP.View.IView;
import com.example.baitaptuan6.Utils.Permission;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {
    private static final int READ_EXTERNAL_STORAGE_CODE = 1;
    private static final int WRITE_EXTERNAL_STORAGE_CODE = 2;

    Button bGetNameApplication;
    TextView tvShowNameApplcation;
    ImagePresenter imagePresenter;
    ImageAdapter imageAdapter;
    RecyclerView recyclerView;
    Permission chPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagePresenter = new ImagePresenter(this, this);
        recyclerView = findViewById(R.id.lv_show_data);
        // Instantiating the Presenter
        bGetNameApplication = findViewById(R.id.bt_get_name_applicaton);
        chPermission = new Permission(this);
        chPermission.checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE_CODE);
        bGetNameApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chPermission.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE_CODE);
                imagePresenter.getDataFromModal();
            }
        });
    }


    @Override
    public void displayMail(List<ImageModal> imageModalList) {
        imageAdapter = new ImageAdapter(this, imageModalList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(imageAdapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == READ_EXTERNAL_STORAGE_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }

        } else if (requestCode == WRITE_EXTERNAL_STORAGE_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }

        }
    }
}