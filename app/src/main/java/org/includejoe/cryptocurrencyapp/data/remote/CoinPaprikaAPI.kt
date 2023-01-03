package org.includejoe.cryptocurrencyapp.data.remote

import org.includejoe.cryptocurrencyapp.data.remote.dto.CoinDTO
import org.includejoe.cryptocurrencyapp.data.remote.dto.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {
    @GET("coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDTO
}