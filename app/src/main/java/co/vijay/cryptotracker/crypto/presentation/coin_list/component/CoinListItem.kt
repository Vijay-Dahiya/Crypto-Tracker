package co.vijay.cryptotracker.crypto.presentation.coin_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.vijay.cryptotracker.crypto.domain.Coin
import co.vijay.cryptotracker.crypto.presentation.models.CoinUi
import co.vijay.cryptotracker.crypto.presentation.models.toCoinUi
import co.vijay.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListItemItem(modifier: Modifier = Modifier, coinUi: CoinUi, onClick: () -> Unit) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = coinUi.iconRes),
            contentDescription = coinUi.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )

    }
}

@Preview
@Composable
private fun CoinListItemPreview() {
    CryptoTrackerTheme {
        CoinListItemItem(coinUi = previewCoin.toCoinUi()) {
            
        }
    }
}

internal val previewCoin = Coin(
    id = "bitcoin",
    rank = 1,
    name = "BitCoin",
    symbol = "BTC",
    marketCapUsd = 124127395896.75,
    priceUsd = 62875.25,
    changePercent24Hr = 0.1
)