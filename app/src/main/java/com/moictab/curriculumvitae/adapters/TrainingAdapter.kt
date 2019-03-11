package com.moictab.curriculumvitae.adapters

import android.content.Context
import android.graphics.Bitmap
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

/**
 * Created by moict on 19/10/2017.
 */

public class TrainingAdapter(private val trainings: List<Training>, private val context: Context) : RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {

    class TrainingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvName: TextView
        var tvPlace: TextView
        var tvDates: TextView
        var ivTraining: ImageView

        init {

            tvName = itemView.findViewById(R.id.tv_name)
            tvPlace = itemView.findViewById(R.id.tv_place)
            tvDates = itemView.findViewById(R.id.tv_dates)
            ivTraining = itemView.findViewById(R.id.iv_training)
        }
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
        } catch (ex: Exception) {
            Log.e("ERROR SETTING IMAGE", ex.message)
        }

    }

    override fun getItemCount(): Int {
        return trainings.size
    }

}
