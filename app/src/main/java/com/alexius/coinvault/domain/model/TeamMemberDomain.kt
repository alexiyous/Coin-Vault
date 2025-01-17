package com.alexius.coinvault.domain.model

import com.google.gson.annotations.SerializedName

data class TeamMemberDomain(
    val name: String,
    val id: String,
    val position: String
)
