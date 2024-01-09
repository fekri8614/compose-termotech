package info.fekri8614.thermocall.ui.features.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.burnoo.cokoin.navigation.getNavController
import info.fekri8614.thermocall.model.data.ThermoItem
import info.fekri8614.thermocall.ui.theme.Shapes
import info.fekri8614.thermocall.ui.theme.md_theme_light_tertiary
import info.fekri8614.thermocall.util.MyScreens
import info.fekri8614.thermocall.util.TextBlackBoldx16
import info.fekri8614.thermocall.util.TextBlackNormalx24
import info.fekri8614.thermocall.util.TextLightGrayNormalx8
import info.fekri8614.thermocall.util.thermoItemList
import kotlinx.coroutines.launch
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    val uiController = rememberSystemUiController()
    val materialColorScheme = MaterialTheme.colors
    val context = LocalContext.current
    val navigation = getNavController()
    //val viewModel = getNavViewModel<DashboardViewModel>()

    val collapsingState = rememberCollapsingToolbarScaffoldState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)
    val scope = rememberCoroutineScope()

    SideEffect {
        uiController.setStatusBarColor(md_theme_light_tertiary)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            DashboardTopAppBar(materialColorScheme.primary) {
                scope.launch { scaffoldState.drawerState.open() }
            }
        },
        drawerContent = {
            DrawerContent(onItemClicked = { id ->
                scope.launch {
                    scaffoldState.drawerState.close()
                }
                navigation.navigate(id)
            })
        },
        content = { paddingValues ->
            Column(
                modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ScrollableThermoItems(thermoItemList)
                OutlinedButton(
                    onClick = { /* Add a ThermoItem */ },
                    content = {
                        Text(
                            "Add using share code".uppercase(),
                            modifier.padding(8.dp)
                        )
                    },
                    border = BorderStroke(3.dp, materialColorScheme.primary),
                    modifier = modifier
                        .fillMaxWidth(0.9f)
                )
            }
        }
    )
}

// -----------------------------------------------=-------------------------------

@Composable
fun ScrollableThermoItems(thermoItems: List<ThermoItem>) {
    LazyColumn {
        items(thermoItems) { thermoItem ->
            DashboardThermoItem(data = thermoItem)
        }
    }
}

@Composable
fun DashboardThermoItem(data: ThermoItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 2.dp,
        shape = Shapes.medium
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = data.title, style = TextBlackNormalx24)
                Text(
                    text = data.kind ?: "",
                    color = data.kindColor ?: MaterialTheme.colors.secondary
                )
                Text(data.time, style = TextLightGrayNormalx8)
            }
            Card() {
                Surface() {
                    Text(data.temperature.toString(), style = TextBlackBoldx16)
                }
            }
        }
    }
}

// -=----------------------------------------------------------------------------

@Composable
fun DashboardTopAppBar(background: Color, onIconClicked: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onIconClicked) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Dashboard") },
        backgroundColor = background,
        elevation = 0.dp
    )
}

// -----------------------------------------------------------------------------

@Composable
fun DrawerContent(onItemClicked: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {

            Spacer(modifier = Modifier.height(10.dp))

            DrawerItem(
                text = "Dashboard",
                onItemClick = { onItemClicked.invoke(MyScreens.DashboardScreen.route) }
            )

            DrawerItem(
                text = "Setup",
                onItemClick = { onItemClicked.invoke(MyScreens.SetupScreen.route) }
            )

            DrawerItem(
                text = "Account",
                onItemClick = { onItemClicked.invoke(MyScreens.AccountScreen.route) }
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = "Developed by ", fontSize = 14.sp, color = Color.Black
            )
            Text(
                text = "fekri8614",
                fontSize = 16.sp,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Composable
fun DrawerItem(text: String, onItemClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { onItemClick() },
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

// -----------------------------------------------------------------------------

