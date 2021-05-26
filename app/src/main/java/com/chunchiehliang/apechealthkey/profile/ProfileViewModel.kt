package com.chunchiehliang.apechealthkey.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chunchiehliang.apechealthkey.models.Check
import kotlinx.coroutines.launch
import java.util.*

class ProfileViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _checks = MutableLiveData<List<Check>>()
    val checks: LiveData<List<Check>>
        get() = _checks

    init {
        getChecksFromDatabase()
    }

    private fun getChecksFromDatabase() {
        _isLoading.value = true
        viewModelScope.launch {
            // dummy data
            _checks.value = mutableListOf(
                Check(0, true, "Vaccinated", Date(1622378628000)),
                Check(1, true, "COVID-19 Tested Negative", Date(1622378628000)),
                Check(2, true, "14 Days without contact with diagnosed", Date(1622378628000)),
//                Check(3, true, "14 Days without contact with diagnosed", Date(1622378628000)),
            )
            _isLoading.value = false
        }
    }

    fun refresh() {
        getChecksFromDatabase()
    }
}