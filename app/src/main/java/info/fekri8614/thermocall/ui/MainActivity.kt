package info.fekri8614.thermocall.ui

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import info.fekri8614.thermocall.ui.theme.ThermoCallTheme
import dev.burnoo.cokoin.Koin
import dev.burnoo.cokoin.navigation.KoinNavHost
import info.fekri8614.thermocall.di.myModules
import info.fekri8614.thermocall.ui.features.account.AccountScreen
import info.fekri8614.thermocall.ui.features.dashboard.DashboardScreen
import info.fekri8614.thermocall.ui.features.setup.SetupScreen
import info.fekri8614.thermocall.ui.features.showItem.ShowItemScreen
import info.fekri8614.thermocall.util.MyScreens
import org.koin.android.ext.koin.androidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
        setContent {
            Koin(appDeclaration = {
                androidContext(this@MainActivity)
                modules(myModules)
            }) {
                ThermoCallTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background,
                    ) {
                        MainAppUi()
                    }
                }
            }
        }
    }
}

@Composable
fun MainAppUi() {
    val controller = rememberNavController()

    KoinNavHost(navController = controller, startDestination = MyScreens.DashboardScreen.route) {
        composable(route = MyScreens.DashboardScreen.route) {
            DashboardScreen()
        }

        composable(route = MyScreens.SetupScreen.route) {
            SetupScreen()
        }

        composable(route = MyScreens.AccountScreen.route) {
            AccountScreen()
        }

        composable(route = MyScreens.ShowItemScreen.route) {
            ShowItemScreen()
        }
    }
}
