package com.alexius.coinvault.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexius.coinvault.common.Resource
import com.alexius.coinvault.domain.usecase.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CoinListState())
    val state: StateFlow<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        viewModelScope.launch {
            getCoinsUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = CoinListState(coins = result.data ?: emptyList())
                    }

                    is Resource.Error -> {
                        _state.value =
                            CoinListState(error = result.message ?: "An unexpected error occurred")
                    }

                    is Resource.Loading -> {
                        _state.value = CoinListState(isLoading = true)
                    }

                }
            }
        }
    }
}