package fragments

import com.example.tagaytaytayo.R
import viewmodel.CityViewModel

class HomeFragment : Fragment() {

    private lateinit var viewModel: CityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )

        viewModel = ViewModelProvider(this).get(CityViewModel::class.java)

        binding.buttonCoffeeShops.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_coffeeShopsFragment)
        }
        binding.buttonRestaurants.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_restaurantsFragment)
        }
        binding.buttonParks.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_parksFragment)
        }
        binding.buttonShoppingCenters.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_shoppingCentersFragment)
        }

        return binding.root
    }
}
