package info.fekri8614.thermocall.ui.features.dashboard

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.material.DrawerValue
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.burnoo.cokoin.navigation.getNavController
import dev.burnoo.cokoin.navigation.getNavViewModel
import info.fekri8614.thermocall.util.MyScreens
import kotlinx.coroutines.launch
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    val uiController = rememberSystemUiController()
    val materialColorScheme = MaterialTheme.colors
    val context = LocalContext.current
    val navigation = getNavController()
    // val viewModel = getNavViewModel<DashboardViewModel>()

    val collapsingState = rememberCollapsingToolbarScaffoldState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerContent(onItemClicked = { id ->
                scope.launch {
                    scaffoldState.drawerState.close()
                }
                navigation.navigate(id)
            })
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Open Drawer") },
                icon = { Icon(Icons.Default.Menu, contentDescription = "Menu") },
                onClick = { scope.launch { scaffoldState.drawerState.open() } },
                modifier = modifier.padding(bottom = 32.dp)
            )
        },
        content = { paddingValues ->
            Column(
                modifier.fillMaxSize().padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hi there",
                    style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
                )
            }
        }
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

