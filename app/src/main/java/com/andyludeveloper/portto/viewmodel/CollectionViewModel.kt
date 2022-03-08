package com.andyludeveloper.portto.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andyludeveloper.portto.model.Asset
import com.andyludeveloper.portto.repository.CollectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "CollectionViewModel"

@HiltViewModel
class CollectionViewModel
@Inject
constructor(private val repository: CollectionRepository) : ViewModel() {
    private var _collections: MutableLiveData<List<Asset>> = MutableLiveData()
    val collections: LiveData<List<Asset>> = _collections

    private var _currentAsset: MutableLiveData<Asset> = MutableLiveData()
    val currentAsset:LiveData<Asset> = _currentAsset

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            repository.getCollection().let { response ->
                if (response.isSuccessful) {
                    _collections.value = response.body()?.assets
                } else {
                    Log.d(TAG, "onFailure: ${response.message()}")
                }
            }
        }
    }

    fun setCurrentAsset(asset: Asset) {
        _currentAsset.value = asset
    }
}
