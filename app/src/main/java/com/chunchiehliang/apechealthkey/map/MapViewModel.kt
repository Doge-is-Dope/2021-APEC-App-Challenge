package com.chunchiehliang.apechealthkey.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chunchiehliang.apechealthkey.R
import com.chunchiehliang.apechealthkey.models.Attraction
import kotlinx.coroutines.launch

class MapViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _attractions = MutableLiveData<List<Attraction>>()
    val attractions: LiveData<List<Attraction>>
        get() = _attractions

    init {
        getAttractionsFromDatabase()
    }

    private fun getAttractionsFromDatabase() {
        _isLoading.value = true
        viewModelScope.launch {
            // dummy data
            _attractions.value = mutableListOf(
                Attraction(0, "Taipei 101", true, 1200, "Not busy", R.raw.taipei101),
                Attraction(1, "F Gallery", true, 800, "Not busy",R.raw.gallery),
                Attraction(2, "The Grand Hotel", true, 2000, "Not busy", R.raw.grandhotel),
                Attraction(3, "Bakery & Cafe ", true, 500, "Not busy",R.raw.bakery),
            )
            _isLoading.value = false
        }
    }

    fun refresh() {
        getAttractionsFromDatabase()
    }
}