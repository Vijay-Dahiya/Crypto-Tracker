package co.vijay.cryptotracker.crypto.presentation.models

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import androidx.compose.ui.res.integerResource
import co.vijay.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.util.getDrawableIdForCoin
import java.util.Locale

data class CoinUi (
    val id: String,
    val rank: Int,
    val name: String,
    val symbol : String,
    val marketCapUsd : DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercentage: DisplayableNumber,
    @DrawableRes val iconRes : Int
)


data class DisplayableNumber(
    val value: Double,
    val formatted: String
)

fun Coin.toCoinUi() : CoinUi{
    return CoinUi(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDisplayableNumber(),
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        changePercentage = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumber() : DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}