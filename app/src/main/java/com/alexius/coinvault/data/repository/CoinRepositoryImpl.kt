package com.alexius.coinvault.data.repository

import com.alexius.coinvault.common.Resource
import com.alexius.coinvault.data.remote.CoinPaprikaApi
import com.alexius.coinvault.data.remote.dto.toCoin
import com.alexius.coinvault.data.remote.dto.toDomainModel
import com.alexius.coinvault.domain.model.Coin
import com.alexius.coinvault.domain.model.CoinDetail
import com.alexius.coinvault.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = api.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

    override fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>  = flow {
        try {
            emit(Resource.Loading())
            val coinDetail = api.getCoinById(coinId).toDomainModel()
            emit(Resource.Success(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

}


