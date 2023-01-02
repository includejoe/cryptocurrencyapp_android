package org.includejoe.cryptocurrencyapp.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.includejoe.cryptocurrencyapp.common.Resource
import org.includejoe.cryptocurrencyapp.data.remote.dto.toCoin
import org.includejoe.cryptocurrencyapp.data.remote.dto.toCoinDetail
import org.includejoe.cryptocurrencyapp.domain.model.Coin
import org.includejoe.cryptocurrencyapp.domain.model.CoinDetail
import org.includejoe.cryptocurrencyapp.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server, check your internet connection"))
        }
    }
}