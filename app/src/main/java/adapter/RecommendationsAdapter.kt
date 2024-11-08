package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecommendationsAdapter(private val recommendations: List<String>, private val category: String) :
    RecyclerView.Adapter<RecommendationsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recommendation, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = recommendations[position]
        holder.imageView.setImageResource(getImageResource(category))
    }

    override fun getItemCount() = recommendations.size

    private fun getImageResource(category: String): Int {
        return when (category) {
            "Coffee Shops" -> R.drawable.coffee_shop
            "Restaurants" -> R.drawable.restaurant
            "Parks" -> R.drawable.park
            "Shopping Centers" -> R.drawable.shopping_center
            else -> R.drawable.ic_launcher_foreground
        }
    }
}
