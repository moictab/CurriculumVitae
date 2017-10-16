package com.moictab.curriculumvitae.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moictab.curriculumvitae.R;
import com.moictab.curriculumvitae.model.Project;

import java.util.List;

/**
 * Created by moict on 16/10/2017.
 */

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {

    private List<Project> projects;
    private Context context;

    public ProjectsAdapter(List<Project> projects, Context context) {
        this.projects = projects;
        this.context = context;
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvPeriod;
        TextView tvDescription;

        ProjectViewHolder(final View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPeriod = itemView.findViewById(R.id.tv_period);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }

    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.project_layout, parent, false);

        return new ProjectViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, final int position) {
        holder.tvDescription.setText(projects.get(position).description);
        holder.tvPeriod.setText(projects.get(position).period);
        holder.tvTitle.setText(projects.get(position).title);
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }
}
