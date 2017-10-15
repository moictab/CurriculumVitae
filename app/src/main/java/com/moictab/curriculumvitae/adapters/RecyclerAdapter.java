package com.moictab.curriculumvitae.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moictab.curriculumvitae.R;
import com.moictab.curriculumvitae.model.Experience;

import java.util.List;

/**
 * Created by moict on 15/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {

    private List<Experience> experiences;
    private Context context;

    public RecyclerAdapter(List<Experience> experiences, Context context) {
        this.experiences = experiences;
        this.context = context;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvPeriod;
        public TextView tvPlace;
        public TextView tvDescription;

        public CustomViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPeriod = itemView.findViewById(R.id.tv_period);
            tvPlace = itemView.findViewById(R.id.tv_place);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }


    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.experience_layout, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.tvDescription.setText(experiences.get(position).description);
        holder.tvPeriod.setText(experiences.get(position).period);
        holder.tvPlace.setText(experiences.get(position).place);
        holder.tvTitle.setText(experiences.get(position).title);
    }

    @Override
    public int getItemCount() {
        return experiences.size();
    }
}
