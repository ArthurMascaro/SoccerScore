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
fun MatchResultScreen(
    teamA: String,
    teamB: String,
    goalsA: Int,
    goalsB: Int,
    onNewGameClick: () -> Unit
) {
    val resultText = when {
        goalsA > goalsB -> "$teamA venceu!"
        goalsB > goalsA -> "$teamB venceu!"
        else -> "Empate emocionante!"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Resultado Final",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "$goalsA x $goalsB",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = resultText,
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)
        ) {
            Button(onClick = onNewGameClick) {
                Text("Novo Jogo")
            }
        }
    }
}

