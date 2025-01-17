package com.alexius.coinvault.presentation.coin_list

import com.alexius.coinvault.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
