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
import com.moictab.curriculumvitae.model.Formation;

import java.io.BufferedInputStream;
import java.util.List;

/**
 * Created by moict on 19/10/2017.
 */

public class FormationAdapter extends RecyclerView.Adapter<FormationAdapter.FormationViewHolder> {

    private List<Formation> formations;
    private Context context;

    public FormationAdapter(List<Formation> formations, Context context) {
        this.formations = formations;
        this.context = context;
    }

    static class FormationViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvPlace;
        TextView tvDates;
        ImageView ivFormation;

        FormationViewHolder(final View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvPlace = itemView.findViewById(R.id.tv_place);
            tvDates = itemView.findViewById(R.id.tv_dates);
            ivFormation = itemView.findViewById(R.id.iv_formation);
        }
    }

    public FormationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.formation_layout, parent, false);

        return new FormationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FormationViewHolder holder, final int position) {
        holder.tvName.setText(formations.get(position).name);
        holder.tvPlace.setText(formations.get(position).place);
        holder.tvDates.setText(formations.get(position).dates);

        try {
            BufferedInputStream stream = new BufferedInputStream(context.getAssets().open(formations.get(position).imageName));
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            holder.ivFormation.setImageBitmap(bitmap);
        } catch (Exception ex) {
            Log.e("ERROR SETTING IMAGE", ex.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return formations.size();
    }

}
