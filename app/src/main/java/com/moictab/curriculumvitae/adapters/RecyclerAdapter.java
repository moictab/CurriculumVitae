package com.moictab.curriculumvitae.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moictab.curriculumvitae.R;
import com.moictab.curriculumvitae.activities.ExperienceActivity;
import com.moictab.curriculumvitae.model.Experience;

import java.util.List;

/**
 * Created by moict on 15/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {

    private final static String EXPERIENCE_ID = "EXPERIENCE_ID";
    private List<Experience> experiences;
    private Context context;

    public RecyclerAdapter(List<Experience> experiences, Context context) {
        this.experiences = experiences;
        this.context = context;
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvPeriod;
        TextView tvPlace;
        TextView tvDescription;

        CustomViewHolder(final View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPeriod = itemView.findViewById(R.id.tv_period);
            tvPlace = itemView.findViewById(R.id.tv_place);
            tvDescription = itemView.findViewById(R.id.tv_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = itemView.getContext();
                    Intent intent = new Intent(context, ExperienceActivity.class);
                    intent.putExtra(EXPERIENCE_ID, getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.experience_layout, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
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
