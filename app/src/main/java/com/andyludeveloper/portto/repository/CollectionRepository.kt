package com.andyludeveloper.portto.repository

import com.andyludeveloper.portto.service.AssetAPIService
import javax.inject.Inject

class CollectionRepository
@Inject
constructor(private val apiService: AssetAPIService) {
    suspend fun getCollection(offset: Int = 0) = apiService.getCollection(offset)
}
