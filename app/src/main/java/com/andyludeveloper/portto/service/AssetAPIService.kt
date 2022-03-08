package com.andyludeveloper.portto.service

import com.andyludeveloper.portto.model.Assets
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface AssetAPIService {
    @Headers("X-API-KEY:5b294e9193d240e39eefc5e6e551ce83")
    @GET("assets")
    suspend fun getCollection(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20,
        @Query("format") format: String = "json",
        @Query("owner") owner: String = "0x19818f44faf5a217f619aff0fd487cb2a55cca65",
    ): Response<Assets>
}