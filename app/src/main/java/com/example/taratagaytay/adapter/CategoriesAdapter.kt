package com.example.taratagaytay.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taratagaytay.models.Category
import com.example.taratagaytay.R

class CategoriesAdapter(
    private val categories: List<Category>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    // Define the OnItemClickListener interface
    interface OnItemClickListener {
        fun onItemClick(category: Category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false) // Use the correct layout file for the item
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int = categories.size

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val textView: TextView = itemView.findViewById(R.id.textView2)

        fun bind(category: Category) {
            imageView.setImageResource(category.imageResId)
            textView.text = category.name

            // Handle the click event
            itemView.setOnClickListener {
                itemClickListener.onItemClick(category)
            }
        }
    }
}
