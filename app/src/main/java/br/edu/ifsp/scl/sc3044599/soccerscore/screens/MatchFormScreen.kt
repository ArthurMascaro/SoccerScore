package br.edu.ifsp.scl.sc3044599.soccerscore.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import br.edu.ifsp.scl.sc3044599.soccerscore.utils.MatchFormValidator

@Composable
fun MatchFormScreen(
    onViewResultClick: (teamA: String, teamB: String, goalsA: Int, goalsB: Int) -> Unit
) {
    var teamA: String by rememberSaveable { mutableStateOf("") }
    var teamAError: String? by rememberSaveable { mutableStateOf(null) }

    var teamB: String by rememberSaveable { mutableStateOf("") }
    var teamBError: String? by rememberSaveable { mutableStateOf(null) }

    var goalsAInput: String by rememberSaveable { mutableStateOf("") }
    var goalsAError: String? by rememberSaveable { mutableStateOf(null) }

    var goalsBInput: String by rememberSaveable { mutableStateOf("") }
    var goalsBError: String? by rememberSaveable { mutableStateOf(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Configuração da Partida",
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = teamA,
            onValueChange = {
                teamA = it
                teamAError = null
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Nome do Time A") },
            isError = teamAError != null,
            supportingText = {
                Text(
                    text = teamAError ?: "",
                    color = MaterialTheme.colorScheme.error
                )
            },
            singleLine = true
        )

        OutlinedTextField(
            value = teamB,
            onValueChange = {
                teamB = it
                teamBError = null
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Nome do Time B") },
            isError = teamBError != null,
            supportingText = {
                Text(
                    text = teamBError ?: "",
                    color = MaterialTheme.colorScheme.error
                )
            },
            singleLine = true
        )

        OutlinedTextField(
            value = goalsAInput,
            onValueChange = { value ->
                goalsAInput = value
                goalsAError = null
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Gols do Time A") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = goalsAError != null,
            supportingText = {
                Text(
                    text = goalsAError ?: "",
                    color = MaterialTheme.colorScheme.error
                )
            },
            singleLine = true
        )

        OutlinedTextField(
            value = goalsBInput,
            onValueChange = { value ->
                goalsBInput = value
                goalsBError = null
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Gols do Time B") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = goalsBError != null,
            supportingText = {
                Text(
                    text = goalsBError ?: "",
                    color = MaterialTheme.colorScheme.error
                )
            },
            singleLine = true
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    val trimmedTeamA = teamA.trim()
                    val trimmedTeamB = teamB.trim()

                    teamAError = MatchFormValidator.validateTeamName(trimmedTeamA, "Time A")
                    teamBError = MatchFormValidator.validateTeamName(trimmedTeamB, "Time B")
                    goalsAError = MatchFormValidator.validateGoals(goalsAInput, "Time A")
                    goalsBError = MatchFormValidator.validateGoals(goalsBInput, "Time B")

                    val hasError = teamAError != null ||
                        teamBError != null ||
                        goalsAError != null ||
                        goalsBError != null

                    if (!hasError) {
                        val goalsA = goalsAInput.toInt()
                        val goalsB = goalsBInput.toInt()
                        onViewResultClick(trimmedTeamA, trimmedTeamB, goalsA, goalsB)
                    }
                }
            ) {
                Text("Ver Resultado")
            }
        }
    }
}

