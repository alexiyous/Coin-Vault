package com.alexius.coinvault.data.remote

import com.alexius.coinvault.data.remote.dto.CoinDetailDto
import com.alexius.coinvault.data.remote.dto.CoinDto
import com.alexius.coinvault.data.remote.dto.CoinDtoItem
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDtoItem>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailDto
}