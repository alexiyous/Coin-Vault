package com.alexius.coinvault.domain.usecase.get_coins

import com.alexius.coinvault.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke() = repository.getCoins()
}