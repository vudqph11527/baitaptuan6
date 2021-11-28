package com.example.baitaptuan6.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Permission {
    Context context;

    public Permission(Context context) {
        this.context = context;
    }

    public void checkPermission(String permission, int requestCode){
        if (ContextCompat.checkSelfPermission(context,permission) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, requestCode);
        }else{
            Toast.makeText(context, "Permisson Already Granted", Toast.LENGTH_SHORT).show();
        }
    }
}
