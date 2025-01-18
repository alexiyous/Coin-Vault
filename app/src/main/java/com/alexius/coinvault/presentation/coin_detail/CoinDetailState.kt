package com.alexius.coinvault.presentation.coin_detail

import com.alexius.coinvault.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
