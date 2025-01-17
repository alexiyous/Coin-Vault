package com.alexius.coinvault.data.remote.dto

import com.alexius.coinvault.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(

	@field:SerializedName("CoinDto")
	val coinDto: List<CoinDtoItem>
)

data class CoinDtoItem(

	@field:SerializedName("symbol")
	val symbol: String,

	@field:SerializedName("is_active")
	val isActive: Boolean,

	@field:SerializedName("is_new")
	val isNew: Boolean,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("rank")
	val rank: Int,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("type")
	val type: String
)

fun CoinDtoItem.toCoin(): Coin {
	return Coin(
		symbol = symbol,
		isActive = isActive,
		name = name,
		rank = rank,
		id = id
	)
}