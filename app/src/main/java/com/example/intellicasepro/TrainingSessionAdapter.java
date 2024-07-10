package com.example.intellicasepro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TrainingSessionAdapter extends RecyclerView.Adapter<TrainingSessionAdapter.ViewHolder> {

    private List<TrainingSession> trainingSessions;

    public TrainingSessionAdapter(List<TrainingSession> trainingSessions) {
        this.trainingSessions = trainingSessions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_training_session, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TrainingSession session = trainingSessions.get(position);
        holder.tvDate.setText(session.getDate());
        holder.tvTitle.setText(session.getTitle());
        holder.tvInstructor.setText(session.getInstructor());
        holder.tvLocation.setText(session.getLocation());
    }

    @Override
    public int getItemCount() {
        return trainingSessions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDate, tvTitle, tvInstructor, tvLocation;
        public Button btnRegister;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvInstructor = itemView.findViewById(R.id.tvInstructor);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            btnRegister = itemView.findViewById(R.id.btnRegister);
        }
    }
}