package br.edu.ifsp.scl.sc3044599.soccerscore.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MatchSummaryScreen(
    teamA: String,
    teamB: String,
    goalsA: Int,
    goalsB: Int,
    onConfirmClick: () -> Unit,
    onEditClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Resumo da Partida",
            style = MaterialTheme.typography.titleLarge
        )

        Text(text = "Time A: $teamA")
        Text(text = "Time B: $teamB")

        Text(
            text = "$goalsA x $goalsB",
            style = MaterialTheme.typography.headlineMedium
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)
        ) {
            Button(onClick = onEditClick) {
                Text("Editar")
            }

            Button(onClick = onConfirmClick) {
                Text("Confirmar Resultado")
            }
        }
    }
}

