package com.moictab.curriculumvitae.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.moictab.curriculumvitae.R
import com.moictab.curriculumvitae.model.Project

class ProjectsAdapter(private val projects: List<Project>, private val context: Context) : RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>() {
  class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    var tvPeriod: TextView = itemView.findViewById(R.id.tv_period)
    var tvDescription: TextView = itemView.findViewById(R.id.tv_description)
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
