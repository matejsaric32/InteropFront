package ui.components.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup

@Composable
fun DropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    items: List<String>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    if (expanded) {
        Popup(onDismissRequest = onDismissRequest) {
            Row(Modifier.background(color = Color.White).padding(4.dp)) {
                items.forEachIndexed { index, item ->
                    Button(
                        onClick = { onItemSelected(index) },
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(item)
                    }
                }
            }
        }
    }
}