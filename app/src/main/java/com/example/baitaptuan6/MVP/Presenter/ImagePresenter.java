package com.example.baitaptuan6.MVP.Presenter;

import android.content.Context;

import com.example.baitaptuan6.MVP.Model.IImageModel;
import com.example.baitaptuan6.MVP.Model.ImageModal;
import com.example.baitaptuan6.MVP.View.IView;

import java.util.ArrayList;
import java.util.List;

public class ImagePresenter {
    IView iView;

    public ImagePresenter(IView iView) {
        this.iView = iView;
    }

    public List<ImageModal> createListData() {
        List<ImageModal> list = new ArrayList<>();
        list.add(new ImageModal("Gà", "Vịt"));
        list.add(new ImageModal("Gà", "Vịt"));
        return list;
    }

    public void getDataFromModal() {
        iView.displayMail(createListData());
    }
}
