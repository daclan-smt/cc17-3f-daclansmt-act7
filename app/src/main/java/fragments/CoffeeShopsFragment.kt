package fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tagaytaytayo.R
import viewmodel.CityViewModel

class CoffeeShopsFragment : Fragment() {

    private lateinit var viewModel: CityViewModel
    private lateinit var adapter: RecommendationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCoffeeShopsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_coffee_shops, container, false
        )

        viewModel = ViewModelProvider(this).get(CityViewModel::class.java)
        viewModel.loadRecommendations("Coffee Shops")

        viewModel.recommendations.observe(viewLifecycleOwner, Observer {
            adapter = RecommendationsAdapter(it, "Coffee Shops")
            binding.recyclerView.adapter = adapter
        })

        return binding.root
    }
}
