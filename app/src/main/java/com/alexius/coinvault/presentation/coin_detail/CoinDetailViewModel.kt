package com.alexius.coinvault.presentation.coin_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexius.coinvault.common.Constants.PARAM_COIN_ID
import com.alexius.coinvault.domain.usecase.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle // this is useful when we want some data to persist even though the screen is rotated or killed
) : ViewModel(){

    private val _state = MutableStateFlow(CoinDetailState())
    val state: StateFlow<CoinDetailState> = _state

    // init will be called again when screen is rotated
    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoinById(coinId)
        }
    }

    fun getCoinById(coinId: String){
        viewModelScope.launch{
            getCoinUseCase(coinId).collect { result ->
                when(result){
                    is com.alexius.coinvault.common.Resource.Success -> {
                        _state.value = CoinDetailState(coin = result.data)
                    }
                    is com.alexius.coinvault.common.Resource.Error -> {
                        _state.value = CoinDetailState(error = result.message ?: "An unexpected error occurred")
                    }
                    is com.alexius.coinvault.common.Resource.Loading -> {
                        _state.value = CoinDetailState(isLoading = true)
                    }
                }
            }
        }
    }

}