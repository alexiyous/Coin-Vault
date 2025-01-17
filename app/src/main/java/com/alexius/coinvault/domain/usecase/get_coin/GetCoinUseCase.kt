package com.alexius.coinvault.domain.usecase.get_coin

import com.alexius.coinvault.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String) = repository.getCoinById(coinId)
}