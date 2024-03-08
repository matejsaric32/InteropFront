package ui.components.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import model.Hardware
import model.Type
import java.math.BigDecimal

@Composable
fun HardwareForm(hardware: Hardware? = null, onSubmit: (Hardware) -> Unit) {
    var name by remember { mutableStateOf(hardware?.name ?: "") }
    var expanded by remember { mutableStateOf(false) }
    val items = Type.values().toList().map { it.name }
    var selectedIndex by remember { mutableStateOf(hardware?.type?.ordinal ?: 0) }
    var code by remember { mutableStateOf(hardware?.code ?: "") }
    var stock by remember { mutableStateOf(hardware?.stock?.toString() ?: "") }
    var price by remember { mutableStateOf(hardware?.price?.toString() ?: "") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
        // Assuming you have a custom DropdownMenu composable that behaves as described
        Button(onClick = { expanded = !expanded }) {
            Text(if (selectedIndex >= 0) items[selectedIndex] else "Select an Option")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            items = items,
            selectedIndex = selectedIndex,
            onItemSelected = { index ->
                selectedIndex = index
                expanded = false
            }
        )
        TextField(
            value = code,
            onValueChange = { code = it },
            label = { Text("Code") }
        )
        TextField(
            value = stock,
            onValueChange = { stock = it },
            label = { Text("Stock") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                autoCorrect = false,
                imeAction = ImeAction.Next
            )
        )
        TextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Price") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        Button(onClick = {
            val updatedHardware = Hardware(
                name = name,
                type = Type.values()[selectedIndex],
                code = code,
                stock = stock.toIntOrNull() ?: 0,
                price = price.toBigDecimalOrNull() ?: BigDecimal.ZERO
            )
            onSubmit(updatedHardware)
        }) {
            Text("Submit")
        }
    }
}