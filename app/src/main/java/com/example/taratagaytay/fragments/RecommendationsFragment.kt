package com.example.taratagaytay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taratagaytay.models.Category
import com.example.taratagaytay.models.Recommendation
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
            fragment.arguments = args
            return fragment
        }
    }

    // This function gets the recommendations based on the category
    private fun getRecommendationsForCategory(category: Category, context: android.content.Context): List<Recommendation> {
        return when (category.name) {
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
                Recommendation(R.drawable.recom5, context.getString(R.string.kidplace_seven), context.getString(R.string.desc_seven)),
                Recommendation(R.drawable.recom6, context.getString(R.string.kidplace_eight), context.getString(R.string.desc_eight)),
                Recommendation(R.drawable.recom7, context.getString(R.string.kidplace_nine), context.getString(R.string.desc_nine))
            )
            "Parks" -> listOf(
                Recommendation(R.drawable.recom8, context.getString(R.string.park_ten), context.getString(R.string.desc_ten)),
                Recommendation(R.drawable.recom9, context.getString(R.string.park_eleven), context.getString(R.string.desc_eleven)),
                Recommendation(R.drawable.recom10, context.getString(R.string.park_twelve), context.getString(R.string.desc_twelve))
            )
            "Shops" -> listOf(
                Recommendation(R.drawable.recom11, context.getString(R.string.shop_thirteen), context.getString(R.string.desc_thirteen)),
                Recommendation(R.drawable.recom12, context.getString(R.string.shop_fourteen), context.getString(R.string.desc_fourteen)),
                Recommendation(R.drawable.recom13, context.getString(R.string.shop_fifteen), context.getString(R.string.desc_fifteen))
            )
            else -> emptyList()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_recommendations, container, false)

        // Get the recommendations from the arguments
        val categoryName = arguments?.getString("category_name") ?: ""
        val category = Category(categoryName, 0)  // You can modify this as needed to get the proper category object.

        // Pass the context here
        recommendations = getRecommendationsForCategory(category, requireContext())

        // Initialize the RecyclerView
        recyclerView = rootView.findViewById(R.id.recycle_view_recommendation)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = RecommendationsAdapter(recommendations, this)
        recyclerView.adapter = adapter

        return rootView
    }

    override fun onItemClick(recommendation: Recommendation) {
        val detailsFragment = DetailsFragment.newInstance(
            recommendation.imageResId,
            recommendation.title,
            recommendation.description
        )

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailsFragment)
            .addToBackStack(null)
            .commit()
    }
}
