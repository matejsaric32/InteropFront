import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import model.Hardware
import ui.components.navigation.NavigationBar
import ui.screens.HardwareInsert
import ui.screens.HardwareScreen
import ui.screens.HardwareUpdate
import ui.screens.Screen

@Composable
@Preview
fun App() {

    MaterialTheme {
        Surface {
            Column {
                NavigationBar(AppState.currentScreen)
                when (AppState.currentScreen) {
                    Screen.HARDWARE -> HardwareScreen(onNavigate = { AppState.currentScreen = it})
                    Screen.HARDWARE_INSERT -> HardwareInsert(onNavigate = { AppState.currentScreen = it })
                    Screen.HARDWARE_UPDATE -> HardwareUpdate(onNavigate = { AppState.currentScreen = it })

                    else -> {
                        println("NavNo goo")
                    }
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

