package ui.components.table

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ReviewHeader() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .background(Color.LightGray)) {
        Text("Title", modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1)
        Text("Text", modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1)
        Text("Rating", modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1)
        Text("Hardware", modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1)
    }
}