package com.app.dpboss.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dpboss.Model.info_model;
import com.app.dpboss.R;

import java.util.ArrayList;


public class InfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final Activity activity;
    final ArrayList<info_model> info_models;

    public InfoAdapter(Activity activity, ArrayList<info_model> info_models) {
        this.activity = activity;
        this.info_models = info_models;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.info, parent, false);
        return new ItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ItemHolder holder = (ItemHolder) holderParent;
        final info_model info_model = info_models.get(position);

        holder.tvDescription.setText(info_model.getDescription());
        holder.tvTitle.setText(info_model.getTitle());


    }


    @Override
    public int getItemCount() {
        return info_models.size();
    }

    static class ItemHolder extends RecyclerView.ViewHolder {

        final TextView tvTitle,tvDescription;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);




        }
    }
}

