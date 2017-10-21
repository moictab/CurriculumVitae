package com.moictab.curriculumvitae.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.moictab.curriculumvitae.R;
import com.moictab.curriculumvitae.activities.ExperienceActivity;
import com.moictab.curriculumvitae.model.Experience;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * Created by moict on 15/10/2017.
 */

public class ExperiencesAdapter extends RecyclerView.Adapter<ExperiencesAdapter.ExperienceViewHolder> {

    private final static String EXPERIENCE_ID = "EXPERIENCE_ID";
    private List<Experience> experiences;
    private Context context;

    public ExperiencesAdapter(List<Experience> experiences, Context context) {
        this.experiences = experiences;
        this.context = context;
    }

    static class ExperienceViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvPeriod;
        TextView tvPlace;
        ImageView ivExperience;
        Button btnViewDetails;

        ExperienceViewHolder(final View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPeriod = itemView.findViewById(R.id.tv_period);
            tvPlace = itemView.findViewById(R.id.tv_place);
            ivExperience = itemView.findViewById(R.id.iv_experience);
            btnViewDetails = itemView.findViewById(R.id.btn_view_detail);

            btnViewDetails.setOnClickListener(new View.OnClickListener() {
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

    public ExperienceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.experience_layout, parent, false);

        return new ExperienceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExperienceViewHolder holder, final int position) {
        holder.tvPeriod.setText(experiences.get(position).period);
        holder.tvPlace.setText(experiences.get(position).place);
        holder.tvTitle.setText(experiences.get(position).title);

        try {
            BufferedInputStream stream = new BufferedInputStream(context.getAssets().open(experiences.get(position).image));
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            holder.ivExperience.setImageBitmap(bitmap);
        } catch (Exception ex) {
            Log.e("ERROR SETTING IMAGE", ex.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return experiences.size();
    }
}
