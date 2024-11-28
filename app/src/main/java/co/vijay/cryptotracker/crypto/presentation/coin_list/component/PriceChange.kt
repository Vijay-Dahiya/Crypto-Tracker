package co.vijay.cryptotracker.crypto.presentation.coin_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.vijay.cryptotracker.crypto.presentation.models.DisplayableNumber
import co.vijay.cryptotracker.ui.theme.CryptoTrackerTheme
import co.vijay.cryptotracker.ui.theme.greenBackground

@Composable
fun PriceChange(
    modifier: Modifier = Modifier,
    change: DisplayableNumber,
) {
    val contentColor = if (change.value < 0.0) {
        MaterialTheme.colorScheme.onErrorContainer
    } else Color.Green
    val backGroundColor = if (change.value < 0.0) {
        MaterialTheme.colorScheme.errorContainer
    } else greenBackground

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(100f))
            .background(backGroundColor)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (change.value < 0.0) {
                Icons.Default.KeyboardArrowDown
            } else {
                Icons.Default.KeyboardArrowUp
            },
            contentDescription = null,
            tint = contentColor
        )

        Text(
            text = change.formatted +" %",
            fontSize = 14.sp,
            color = contentColor,
            fontWeight = FontWeight.Medium
        )
    }
}

@PreviewLightDark
@Composable
private fun PriceChangePreview() {
    CryptoTrackerTheme {
        PriceChange(
            change = DisplayableNumber(
                value = 2.43,
                formatted = "2.43"
            )
        )
    }
}