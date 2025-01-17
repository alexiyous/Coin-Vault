package com.alexius.coinvault.domain.repository

import com.alexius.coinvault.common.Resource
import com.alexius.coinvault.domain.model.Coin
import com.alexius.coinvault.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    fun getCoins(): Flow<Resource<List<Coin>>>

    fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}