package ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import api.BackendClient
import io.ktor.client.plugins.*
import kotlinx.coroutines.launch
import model.Hardware
import ui.components.table.DisplayHardware

@Composable
fun HardwareScreen(onNavigate: (Screen) -> Unit) {

    val scope = rememberCoroutineScope()
      LaunchedEffect(hardwares) {
        scope.launch {
            try {
                hardwares = BackendClient.getAllHardware()
            } catch (e: ClientRequestException) {
                println("Error fetching data: ${e.message}")
            }
        }
    }
    Column {
        Button(onClick = { onNavigate(Screen.HARDWARE_UPDATE) }) {
            Text("Go to Details")
        }
        DisplayHardware(hardwares)
    }
}