package ui.components.table

import AppState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import api.BackendClient
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import model.Hardware
import ui.screens.Screen

@Composable
fun HardwareHeader(
    modifier: Modifier =
        Modifier.fillMaxWidth()
            .padding(8.dp)
) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = "Name",
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "Type",
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "Code",
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "Stock",
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "Price",
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "Update",
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "Delete",
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun HardwareRowComposable(
    index: Int,
    hardware: Hardware,
    modifier: Modifier
) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = hardware.name,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.body1
        )
        Text(
            text = hardware.type.name,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.body1
        )
        Text(
            text = hardware.code,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.body1
        )
        Text(
            text = hardware.stock.toString(),
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "$${hardware.price}",
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.body1
        )
        Button(
            onClick = {
                AppState.selectedHardware = hardware
                AppState.currentScreen = Screen.HARDWARE_UPDATE
            }, modifier = Modifier.weight(1f)
        ) {
            Text("Update")
        }
        Button(onClick = {
            println(hardware)
            GlobalScope.launch {
                BackendClient.deleteHardware(hardware)
            }
        }
        ) {
            Text("Delete")
        }
    }
}