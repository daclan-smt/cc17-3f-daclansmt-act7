package com.example.taratagaytay.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taratagaytay.models.Recommendation
import com.example.taratagaytay.R

class RecommendationsAdapter(
    private val recommendations: List<Recommendation>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecommendationsAdapter.RecommendationViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(recommendation: Recommendation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        // Inflate the view for each item (card)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recommendation, parent, false)
        return RecommendationViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        val recommendation = recommendations[position]
        holder.bind(recommendation)
    }

    override fun getItemCount(): Int = recommendations.size

    inner class RecommendationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recommendationImage: ImageView = itemView.findViewById(R.id.recommendationImage)
        private val recommendationTitle: TextView = itemView.findViewById(R.id.recommendationTitle)
        private val recommendationIcon: ImageView = itemView.findViewById(R.id.recommendationIcon)

        fun bind(recommendation: Recommendation) {
            // Set the image for recommendation image
            recommendationImage.setImageResource(recommendation.imageResId)

            // Set the title for recommendation
            recommendationTitle.text = recommendation.title

            // Set the icon (this could be any resource you want)
            recommendationIcon.setImageResource(R.drawable.forward_arrow)

            // Set a click listener on the item
            itemView.setOnClickListener {
                itemClickListener.onItemClick(recommendation)
            }
        }
    }
}
