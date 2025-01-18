package com.alexius.coinvault.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alexius.coinvault.presentation.Route
import com.alexius.coinvault.presentation.coin_list.components.CoinListItem

@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(state.coins){ coin ->
            CoinListItem(
                coin = coin,
                onItemClick = {
                    navController.navigate(Route.CoinDetailScreen.route + "/${it.id}")
                }
            )
        }
    }

    if(state.error.isNotBlank()){
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            )
        }
    }
    if (state.isLoading){
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }

}