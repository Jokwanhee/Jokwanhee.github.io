package com.kwanhee.gym.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageEntry(
    @SerialName("state")
    val state: Int,
    @SerialName("share_token")
    val shareToken: String,
    @SerialName("date")
    val date: String? = null // Supabase will auto-generate, but useful for retrieval
)