package com.example.baitaptuan6.MVP.Presenter;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.example.baitaptuan6.MVP.Model.IImageModel;
import com.example.baitaptuan6.MVP.Model.ImageModal;
import com.example.baitaptuan6.MVP.View.IView;

import java.util.ArrayList;
import java.util.List;

public class ImagePresenter {
    IView iView;
    Context context;
    public ImagePresenter(IView iView, Context context) {
        this.context = context;
        this.iView = iView;
    }
    public List<ImageModal> createListData() {
        List<ImageModal> list = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        int columnData = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String pathOfImages = cursor.getString(columnData);
                Log.i("Path: ", pathOfImages);
                list.add(new ImageModal(pathOfImages));
            }
            cursor.close();
        }
        return list;
    }

    public void getDataFromModal() {
        iView.displayMail(createListData());
    }
}
