package org.includejoe.cryptocurrencyapp.data.repository

import org.includejoe.cryptocurrencyapp.data.remote.CoinPaprikaAPI
import org.includejoe.cryptocurrencyapp.data.remote.dto.CoinDTO
import org.includejoe.cryptocurrencyapp.data.remote.dto.CoinDetailDTO
import org.includejoe.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
): CoinRepository {
    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return api.getCoinById(coinId)
    }
}