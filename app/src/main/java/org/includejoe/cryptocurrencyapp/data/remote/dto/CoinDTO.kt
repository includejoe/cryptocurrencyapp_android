package org.includejoe.cryptocurrencyapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import org.includejoe.cryptocurrencyapp.domain.model.Coin

data class CoinDTO(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDTO.toCoin(): Coin {
    return Coin (
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}