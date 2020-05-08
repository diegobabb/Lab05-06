package com.example.milogin.activities.JobApplicationList;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.milogin.Logic.JobRequest;
import com.example.milogin.R;

import java.util.ArrayList;

public class JobApplicationAdapter extends RecyclerView.Adapter<JobApplicationAdapter.ViewHolder> {

    private ArrayList<JobRequest> mDataset;
    private OnClickItem onClickItem;

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nombre;
        TextView email;
        TextView telefono;
        OnClickItem onClickItem;

        ViewHolder(@NonNull View itemView, OnClickItem onClickItem) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            email = itemView.findViewById(R.id.email);
            telefono = itemView.findViewById(R.id.phone_number);
            this.onClickItem = onClickItem;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickItem.onClickItem(getAdapterPosition());
        }
    }

    public interface OnClickItem{
        void onClickItem(int position);
    }

    JobApplicationAdapter(ArrayList<JobRequest> mDataset, OnClickItem onClickItem) {
        this.mDataset = mDataset;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view, parent, false), onClickItem);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(mDataset.get(position).getApplicant().getFirstname());
        holder.email.setText(mDataset.get(position).getApplicant().getEmail());
        holder.telefono.setText(Integer.toString(mDataset.get(position).getApplicant().getPhone()));
    }

    public ArrayList<JobRequest> getmDataset() {
        return mDataset;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void updateList(ArrayList<JobRequest> nuevaLista){
        this.mDataset = new ArrayList<>(nuevaLista);
        notifyDataSetChanged();
    }
}