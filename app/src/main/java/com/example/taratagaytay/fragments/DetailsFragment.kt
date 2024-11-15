package com.example.taratagaytay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.taratagaytay.R

class DetailsFragment : Fragment() {

    companion object {
        // Create a new instance of DetailsFragment with the required arguments
        fun newInstance(imageResId: Int, title: String, description: String): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle().apply {
                putInt("imageResId", imageResId)
                putString("title", title)
                putString("description", description)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_details, container, false)

        // Get the arguments passed to this fragment
        val imageResId = arguments?.getInt("imageResId") ?: R.drawable.ic_launcher_foreground
        val title = arguments?.getString("title") ?: "No title"
        val description = arguments?.getString("description") ?: "No description"

        // Set the UI elements
        val imageView = rootView.findViewById<ImageView>(R.id.detailsImage)
        val titleTextView = rootView.findViewById<TextView>(R.id.detailsTitle)
        val descriptionTextView = rootView.findViewById<TextView>(R.id.detailsDesc)

        // Set the data to the views
        imageView.setImageResource(imageResId)
        titleTextView.text = title
        descriptionTextView.text = description

        return rootView
    }
}
