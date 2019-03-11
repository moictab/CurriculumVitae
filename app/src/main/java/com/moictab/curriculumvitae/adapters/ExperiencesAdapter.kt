package com.moictab.curriculumvitae.adapters

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.moictab.curriculumvitae.R
import com.moictab.curriculumvitae.activities.ExperienceActivity
import com.moictab.curriculumvitae.model.Experience
import java.io.BufferedInputStream

class ExperiencesAdapter(private val experiences: List<Experience>, private val context: Context) : RecyclerView.Adapter<ExperiencesAdapter.ExperienceViewHolder>() {
  class ExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    var tvPeriod: TextView = itemView.findViewById(R.id.tv_period)
    var tvPlace: TextView = itemView.findViewById(R.id.tv_place)
    var ivExperience: ImageView = itemView.findViewById(R.id.iv_experience)
    var btnViewDetails: Button = itemView.findViewById(R.id.btn_view_detail)

    init {
      btnViewDetails.setOnClickListener {
        val context = itemView.context
        val intent = Intent(context, ExperienceActivity::class.java)
        intent.putExtra(EXPERIENCE_ID, adapterPosition)
        context.startActivity(intent)
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
    val inflater = LayoutInflater.from(context)
    val itemView = inflater.inflate(R.layout.experience_layout, parent, false)

    return ExperienceViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
    holder.tvPeriod.text = experiences[position].period
    holder.tvPlace.text = experiences[position].place
    holder.tvTitle.text = experiences[position].title
    try {
      val stream = BufferedInputStream(context.assets.open(experiences[position].image!!))
      val bitmap = BitmapFactory.decodeStream(stream)
      holder.ivExperience.setImageBitmap(bitmap)
    } catch (e: Exception) {
      Log.e("ERROR SETTING IMAGE", e.message)
    }

  }

  override fun getItemCount(): Int {
    return experiences.size
  }

  companion object {
    private const val EXPERIENCE_ID = "EXPERIENCE_ID"
  }
}
