package com.example.taratagaytay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taratagaytay.models.Category
import com.example.taratagaytay.R
import com.example.taratagaytay.adapter.CategoriesAdapter

class CategoriesFragment : Fragment(), CategoriesAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoriesAdapter
    private var categories: List<Category> = emptyList()

    companion object {
        fun newInstance(): CategoriesFragment {
            return CategoriesFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_view, container, false)

        // Initialize categories
        categories = listOf(
            Category("Coffee Shops", R.drawable.coffee),
            Category("Restaurants", R.drawable.resto),
            Category("Kid-Friendly Places", R.drawable.kid),
            Category("Parks", R.drawable.park),
            Category("Shopping", R.drawable.shop)
        )

        // Set up RecyclerView
        recyclerView = rootView.findViewById(R.id.recycle_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = CategoriesAdapter(categories, this)
        recyclerView.adapter = adapter


        return rootView
    }

    override fun onItemClick(category: Category) {
        val recommendationsFragment = RecommendationsFragment.newInstance(category)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, recommendationsFragment)
            .addToBackStack(null)
            .commit()
    }
}