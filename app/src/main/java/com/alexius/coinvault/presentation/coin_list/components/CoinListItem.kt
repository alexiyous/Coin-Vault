package com.alexius.coinvault.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.alexius.coinvault.domain.model.Coin

@Composable
fun CoinListItem(
    modifier: Modifier = Modifier,
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(coin) })
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = if (coin.isActive) "Active" else "Inactive",
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            modifier = modifier.align(CenterVertically),
            style = MaterialTheme.typography.bodyMedium,
            color = if (coin.isActive) Color.Green else Color.Red
        )
    }

}