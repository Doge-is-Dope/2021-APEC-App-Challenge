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

    private val _currentAttraction = MutableLiveData<Attraction>()
    val currentAttraction: LiveData<Attraction>
        get() = _currentAttraction

    init {
        getAttractionsFromDatabase()
    }

    private fun getAttractionsFromDatabase() {
        _isLoading.value = true
        viewModelScope.launch {
            // dummy data
            _attractions.value = mutableListOf(
                Attraction(0, "Taipei 101", 25.03386008609641, 121.56453891088545,true, 1200, "Not busy", R.raw.taipei101),
                Attraction(1, "F Gallery", 25.051727157387027, 121.54556492601324,true, 800, "Not busy", R.raw.gallery),
                Attraction(2, "The Grand Hotel", 25.08016571343226, 121.52641635846334,true, 2000, "Not busy", R.raw.grandhotel),
                Attraction(3, "National Concert Hall", 25.037014761248585, 121.51905112759383,true, 500, "Not busy", R.raw.national_concert_hall),
            )
            _isLoading.value = false
        }
    }

    fun setCurrentAttraction(index: Int) {
        _currentAttraction.value = _attractions.value?.get(index)
    }

    fun refresh() {
        getAttractionsFromDatabase()
    }
}