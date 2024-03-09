package ui.screens

import AppState
import androidx.compose.runtime.Composable
import api.BackendClient
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ui.components.form.HardwareForm

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun HardwareUpdate(onNavigate: (Screen) -> Unit) {
    HardwareForm(
        hardware = AppState.selectedHardware,
        onSubmit = { hardware ->
        GlobalScope.launch {
            BackendClient.putUpdatedHardware(hardware)
        }
        onNavigate(Screen.HARDWARE)
    })
}