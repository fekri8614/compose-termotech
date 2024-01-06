package info.fekri8614.thermocall.util

sealed class MyScreens(val route: String) {
    object DashboardScreen : MyScreens("dashboardScreen")
    object SetupScreen : MyScreens("setupScreen")
    object AccountScreen : MyScreens("accountScreen")
    object ShowItemScreen : MyScreens("showItemScreen")
}