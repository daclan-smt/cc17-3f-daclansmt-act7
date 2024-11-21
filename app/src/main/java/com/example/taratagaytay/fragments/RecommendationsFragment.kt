package com.example.taratagaytay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taratagaytay.models.Recommendation
import com.example.taratagaytay.models.Category
import com.example.taratagaytay.R
import com.example.taratagaytay.adapter.RecommendationsAdapter

class RecommendationsFragment : Fragment(), RecommendationsAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecommendationsAdapter
    private var recommendations: List<Recommendation> = emptyList()

    companion object {
        fun newInstance(category: Category): RecommendationsFragment {
            val fragment = RecommendationsFragment()
            val args = Bundle()
            args.putString("category_name", category.name)
            args.putInt("category_image", category.imageResId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val categoryName = it.getString("category_name")
            recommendations = getRecommendationsForCategory(categoryName)
        }
    }

    private fun getRecommendationsForCategory(categoryName: String?): List<Recommendation> {
        val context = requireContext()
        return when (categoryName) {
            "Coffee Shops" -> listOf(
                Recommendation(R.drawable.recom1, context.getString(R.string.coffee_one), context.getString(R.string.desc_one)),
                Recommendation(R.drawable.recom2, context.getString(R.string.coffee_two), context.getString(R.string.desc_two)),
                Recommendation(R.drawable.recom3, context.getString(R.string.coffee_three), context.getString(R.string.desc_three))
            )
            "Restaurants" -> listOf(
                Recommendation(R.drawable.recom4, context.getString(R.string.resto_four), context.getString(R.string.desc_four)),
                Recommendation(R.drawable.recom5, context.getString(R.string.resto_five), context.getString(R.string.desc_five)),
                Recommendation(R.drawable.recom6, context.getString(R.string.resto_six), context.getString(R.string.desc_six))
            )
            "Kid-Friendly Places" -> listOf(
                Recommendation(R.drawable.recom7, context.getString(R.string.kidplace_seven), context.getString(R.string.desc_seven)),
                Recommendation(R.drawable.recom8, context.getString(R.string.kidplace_eight), context.getString(R.string.desc_eight)),
                Recommendation(R.drawable.recom9, context.getString(R.string.kidplace_nine), context.getString(R.string.desc_nine))
            )
            "Parks" -> listOf(
                Recommendation(R.drawable.recom10, context.getString(R.string.park_ten), context.getString(R.string.desc_ten)),
                Recommendation(R.drawable.recom11, context.getString(R.string.park_eleven), context.getString(R.string.desc_eleven)),
                Recommendation(R.drawable.recom12, context.getString(R.string.park_twelve), context.getString(R.string.desc_twelve))
            )
            "Shopping" -> listOf(
                Recommendation(R.drawable.recom13, context.getString(R.string.shop_thirteen), context.getString(R.string.desc_thirteen)),
                Recommendation(R.drawable.recom14, context.getString(R.string.shop_fourteen), context.getString(R.string.desc_fourteen)),
                Recommendation(R.drawable.recom15, context.getString(R.string.shop_fifteen), context.getString(R.string.desc_fifteen))
            )
            else -> emptyList()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_view, container, false)

        // Set up the RecyclerView
        recyclerView = rootView.findViewById(R.id.recycle_view)
        adapter = RecommendationsAdapter(recommendations, this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return rootView
    }

    // Implement the onItemClick method from the interface
    override fun onItemClick(recommendation: Recommendation) {
        // Handle item click
    }
}