package com.alexius.coinvault.presentation

sealed class Route(val route: String) {

    object CoinListScreen : Route(route = "coinListScreen")
    object CoinDetailScreen : Route(route = "coinDetailScreen")
}