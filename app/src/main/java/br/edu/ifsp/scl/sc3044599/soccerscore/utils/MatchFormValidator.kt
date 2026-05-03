package br.edu.ifsp.scl.sc3044599.soccerscore.utils

object MatchFormValidator {
    fun validateTeamName(teamName: String, teamLabel: String): String? {
        if (teamName.isBlank()) {
            return "Nome do $teamLabel é obrigatório"
        }

        return null
    }

    fun validateGoals(goalsInput: String, teamLabel: String): String? {
        if (goalsInput.isBlank()) {
            return "Gols do $teamLabel é obrigatório"
        }

        val goals = goalsInput.toIntOrNull()
            ?: return "Gols do $teamLabel deve ser um número inteiro"

        if (goals < 0) {
            return "Gols do $teamLabel deve ser maior ou igual a zero"
        }

        return null
    }
}

