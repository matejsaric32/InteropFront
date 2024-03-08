package ui.components.navigation

import AppState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.screens.Screen

@Composable
fun NavigationBar(currentScreen: Screen) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
            .padding(bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = { AppState.currentScreen = Screen.HARDWARE }) {
            Text("HARDWARE")
        }
        Button(onClick = { AppState.currentScreen = Screen.HARDWARE_INSERT }) {
            Text("HARDWARE INSERT")
        }
    }
}