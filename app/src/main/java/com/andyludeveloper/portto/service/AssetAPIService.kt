package com.andyludeveloper.portto.service

import com.andyludeveloper.portto.model.Assets
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface AssetAPIService {
    @GET("assets")
    suspend fun getCollection(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20,
        @Query("format") format: String = "json",
        @Query("owner") owner: String = "0x19818f44faf5a217f619aff0fd487cb2a55cca65",
    ): Response<Assets>
}