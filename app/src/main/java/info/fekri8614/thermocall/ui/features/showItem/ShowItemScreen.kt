package info.fekri8614.thermocall.ui.features.showItem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.burnoo.cokoin.navigation.getNavController

@Composable
fun ShowItemScreen(modifier: Modifier = Modifier) {
    val uiController = rememberSystemUiController()
    val materialColorScheme = MaterialTheme.colors
    val context = LocalContext.current
    val navigation = getNavController()
    SideEffect {
        uiController.setSystemBarsColor(materialColorScheme.primary)
        uiController.setNavigationBarColor(materialColorScheme.background)
    }

    Scaffold { paddingValues ->
        Column(
            modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Show Item Screen",
                style = TextStyle(
                    fontSize = 30.sp,
                    color = Color.Cyan,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
