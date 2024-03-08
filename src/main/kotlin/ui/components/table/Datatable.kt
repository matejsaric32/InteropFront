package ui.components.table

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.Hardware
import ui.screens.Screen

@Composable
fun <T> DataTable(
    headerComposable: @Composable (Modifier) -> Unit,
    data: List<T>,
    rowComposable: @Composable (Int, T, Modifier) -> Unit // Now includes a Modifier parameter,
) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .border(1.dp, Color.LightGray)
        .padding(8.dp)) {

        headerComposable(Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp))
        Divider()

        data.forEachIndexed { index, item ->
            val backgroundColor = if (index % 2 == 0) Color(0xFFF7F7F7) else Color.Transparent // Alternate row color
            val rowModifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(backgroundColor)

            rowComposable(index, item, rowModifier)
        }
    }
}
@Composable
fun DisplayHardware(data: List<Hardware>){
    DataTable(
        headerComposable = { HardwareHeader() },
        data = data,
        rowComposable = { index, hardware, modifier  ->
            HardwareRowComposable(index, hardware, modifier)
        }
    )
}