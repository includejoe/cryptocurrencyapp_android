package org.includejoe.cryptocurrencyapp.domain.repository

import org.includejoe.cryptocurrencyapp.data.remote.dto.CoinDTO
import org.includejoe.cryptocurrencyapp.data.remote.dto.CoinDetailDTO

interface CoinRepository {
    suspend fun getCoins(): List<CoinDTO>

    suspend fun getCoinById(coinId: String): CoinDetailDTO
}