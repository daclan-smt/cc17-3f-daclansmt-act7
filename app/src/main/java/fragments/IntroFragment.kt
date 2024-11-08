package fragments

import com.example.tagaytaytayo.R

class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentIntroBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_intro, container, false
        )

        binding.buttonGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_homeFragment)
        }

        return binding.root
    }
}
