package com.alexius.coinvault.data.remote

import com.alexius.coinvault.data.remote.dto.CoinDetailDto
import com.alexius.coinvault.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): CoinDto

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailDto
}