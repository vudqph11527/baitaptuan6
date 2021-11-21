package com.example.baitaptuan6.AsyncTaskDemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaptuan6.Model.Sms;
import com.example.baitaptuan6.R;

import java.util.List;

public class SmsAdapter extends RecyclerView.Adapter<SmsAdapter.ViewHolder> {
    private Context context;
    private List<Sms> lSms;

    public SmsAdapter(List<Sms> lSms, Context context) {
        this.context = context;
        this.lSms = lSms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_data_from_database, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sms sms = lSms.get(position);
        if (sms == null) {
            Toast.makeText(context, "Nothing", Toast.LENGTH_SHORT).show();
            return;
        } else {
            holder.tvShowContentSms.setText(sms.getContentSms());
        }
    }

    @Override
    public int getItemCount() {
        return lSms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvShowContentSms;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvShowContentSms = itemView.findViewById(R.id.tv_show_data_from_database);
        }
    }
}
