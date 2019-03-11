package com.moictab.curriculumvitae.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.moictab.curriculumvitae.R
import com.moictab.curriculumvitae.model.Training
import java.io.BufferedInputStream

class TrainingAdapter(private val trainings: List<Training>, private val context: Context) : RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {
  class TrainingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvName: TextView = itemView.findViewById(R.id.tv_name)
    var tvPlace: TextView = itemView.findViewById(R.id.tv_place)
    var tvDates: TextView = itemView.findViewById(R.id.tv_dates)
    var ivTraining: ImageView = itemView.findViewById(R.id.iv_training)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
    val inflater = LayoutInflater.from(context)
    val itemView = inflater.inflate(R.layout.training_layout, parent, false)
    return TrainingViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
    holder.tvName.text = trainings[position].name
    holder.tvPlace.text = trainings[position].place
    holder.tvDates.text = trainings[position].dates
    try {
      val stream = BufferedInputStream(context.assets.open(trainings[position].imageName!!))
      val bitmap = BitmapFactory.decodeStream(stream)
      holder.ivTraining.setImageBitmap(bitmap)
    } catch (e: Exception) {
      Log.e(TAG, "Exception getting image from assets", e)
    }
  }

  override fun getItemCount(): Int {
    return trainings.size
  }

  companion object {
    const val TAG = "TrainingAdapter"
  }
}
