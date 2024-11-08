package viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CityViewModel : ViewModel() {
    private val _recommendations = MutableLiveData<List<String>>()
    val recommendations: LiveData<List<String>> get() = _recommendations

    fun loadRecommendations(category: String) {
        // Load recommendations based on the category
        _recommendations.value = when (category) {
            "Coffee Shops" -> listOf("Coffee Shop 1", "Coffee Shop 2", "Coffee Shop 3")
            "Restaurants" -> listOf("Restaurant 1", "Restaurant 2", "Restaurant 3")
            "Parks" -> listOf("Park 1", "Park 2", "Park 3")
            "Shopping Centers" -> listOf("Shopping Center 1", "Shopping Center 2", "Shopping Center 3")
            else -> emptyList()
        }
    }
}