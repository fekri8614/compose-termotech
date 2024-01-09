package info.fekri8614.thermocall.model.data

import androidx.compose.ui.graphics.Color

data class ThermoItem(
    val title: String,
    val kind: String?,
    val kindColor: Color = Color.Black,
    val time: String,
    val temperature: Double
)
