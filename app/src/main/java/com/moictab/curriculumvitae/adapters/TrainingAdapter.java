package com.moictab.curriculumvitae.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moictab.curriculumvitae.R;
import com.moictab.curriculumvitae.model.Training;

import java.io.BufferedInputStream;
import java.util.List;

/**
 * Created by moict on 19/10/2017.
 */

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder> {

    private List<Training> trainings;
    private Context context;

    public TrainingAdapter(List<Training> trainings, Context context) {
        this.trainings = trainings;
        this.context = context;
    }

    static class TrainingViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvPlace;
        TextView tvDates;
        ImageView ivTraining;

        TrainingViewHolder(final View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvPlace = itemView.findViewById(R.id.tv_place);
            tvDates = itemView.findViewById(R.id.tv_dates);
            ivTraining = itemView.findViewById(R.id.iv_training);
        }
    }

    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.training_layout, parent, false);

        return new TrainingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, final int position) {
        holder.tvName.setText(trainings.get(position).name);
        holder.tvPlace.setText(trainings.get(position).place);
        holder.tvDates.setText(trainings.get(position).dates);

        try {
            BufferedInputStream stream = new BufferedInputStream(context.getAssets().open(trainings.get(position).imageName));
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            holder.ivTraining.setImageBitmap(bitmap);
        } catch (Exception ex) {
            Log.e("ERROR SETTING IMAGE", ex.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

}
