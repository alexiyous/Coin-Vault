package com.alexius.coinvault.data.remote.dto

import com.alexius.coinvault.domain.model.CoinDetail
import com.alexius.coinvault.domain.model.TeamMemberDomain
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(

	@field:SerializedName("symbol")
	val symbol: String,

	@field:SerializedName("is_active")
	val isActive: Boolean,

	@field:SerializedName("is_new")
	val isNew: Boolean,

	@field:SerializedName("proof_type")
	val proofType: String,

	@field:SerializedName("first_data_at")
	val firstDataAt: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("team")
	val team: List<TeamMember>,

	@field:SerializedName("links_extended")
	val linksExtended: List<LinksExtendedItem>,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("tags")
	val tags: List<TagsItem>,

	@field:SerializedName("last_data_at")
	val lastDataAt: String,

	@field:SerializedName("whitepaper")
	val whitepaper: Whitepaper,

	@field:SerializedName("org_structure")
	val orgStructure: String,

	@field:SerializedName("hardware_wallet")
	val hardwareWallet: Boolean,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("development_status")
	val developmentStatus: String,

	@field:SerializedName("hash_algorithm")
	val hashAlgorithm: String,

	@field:SerializedName("rank")
	val rank: Int,

	@field:SerializedName("logo")
	val logo: String,

	@field:SerializedName("started_at")
	val startedAt: String,

	@field:SerializedName("links")
	val links: Links,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("open_source")
	val openSource: Boolean
)

data class Whitepaper(

	@field:SerializedName("thumbnail")
	val thumbnail: String,

	@field:SerializedName("link")
	val link: String
)

data class TagsItem(

	@field:SerializedName("coin_counter")
	val coinCounter: Int,

	@field:SerializedName("ico_counter")
	val icoCounter: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String
)

data class LinksExtendedItem(

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("stats")
	val stats: Stats
)

data class TeamMember(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("position")
	val position: String
)

data class Links(

	@field:SerializedName("youtube")
	val youtube: List<String>,

	@field:SerializedName("website")
	val website: List<String>,

	@field:SerializedName("facebook")
	val facebook: List<String>,

	@field:SerializedName("explorer")
	val explorer: List<String>,

	@field:SerializedName("reddit")
	val reddit: List<String>,

	@field:SerializedName("source_code")
	val sourceCode: List<String>
)

data class Stats(

	@field:SerializedName("followers")
	val followers: Int,

	@field:SerializedName("contributors")
	val contributors: Int,

	@field:SerializedName("stars")
	val stars: Int,

	@field:SerializedName("subscribers")
	val subscribers: Int
)

fun TeamMember.toDomainModel(): TeamMemberDomain {
	return TeamMemberDomain(
		name = name,
		id = id,
		position = position
	)
}

fun CoinDetailDto.toDomainModel(): CoinDetail {
	return CoinDetail(
		coinId = id,
		name = name,
		description = description,
		symbol = symbol,
		rank = rank,
		isActive = isActive,
		tags = tags.map { it.name },
		team = team.map { it.toDomainModel() }
	)
}