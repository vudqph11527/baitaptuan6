package com.example.baitaptuan6.MVP;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.baitaptuan6.MVP.Model.ImageModal;
import com.example.baitaptuan6.R;

import java.io.File;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private Context context;
    private List<ImageModal> listImages;

    public ImageAdapter(Context context, List<ImageModal> listImages) {
        this.context = context;
        this.listImages = listImages;
    }

    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String image = listImages.get(position).getImageResource();
        File imgFile = new File(image);
        if (image == null) {
            Toast.makeText(context, "Nothing", Toast.LENGTH_SHORT).show();
            return;
        } else {
//            Glide.with(context).load(Uri.fromFile(imgFile)).into(holder.ivImage);
            holder.ivImage.setText(image);
        }
    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.im_Media);
        }
    }
}
