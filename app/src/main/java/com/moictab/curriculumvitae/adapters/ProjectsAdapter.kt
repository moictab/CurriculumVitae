package com.moictab.curriculumvitae.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.moictab.curriculumvitae.R
import com.moictab.curriculumvitae.model.Project

/**
 * Created by moict on 16/10/2017.
 */

class ProjectsAdapter(private val projects: List<Project>, private val context: Context) : RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>() {

    class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView
        var tvPeriod: TextView
        var tvDescription: TextView

        init {

            tvTitle = itemView.findViewById(R.id.tv_title)
            tvPeriod = itemView.findViewById(R.id.tv_period)
            tvDescription = itemView.findViewById(R.id.tv_description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.project_layout, parent, false)

        return ProjectViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.tvDescription.text = projects[position].description
        holder.tvPeriod.text = projects[position].period
        holder.tvTitle.text = projects[position].title
    }

    override fun getItemCount(): Int {
        return projects.size
    }
}
