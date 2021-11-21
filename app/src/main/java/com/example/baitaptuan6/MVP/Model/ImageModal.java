package com.example.baitaptuan6.MVP.Model;

public class ImageModal {
    private String imageResource;
    private String imageTitle;

    public ImageModal(String imageResource, String imageTitle) {
        this.imageResource = imageResource;
        this.imageTitle = imageTitle;
    }

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }


}
