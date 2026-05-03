package br.edu.ifsp.scl.sc3044599.soccerscore.domain

import android.net.Uri

object SoccerScoreRoutes {
    const val MATCH_FORM = "match_form"

    private const val MATCH_SUMMARY = "match_summary"
    private const val MATCH_RESULT = "match_result"

    val MATCH_SUMMARY_ROUTE =
        "$MATCH_SUMMARY/{${MatchNavArgs.TEAM_A}}/{${MatchNavArgs.TEAM_B}}/{${MatchNavArgs.GOALS_A}}/{${MatchNavArgs.GOALS_B}}"

    val MATCH_RESULT_ROUTE =
        "$MATCH_RESULT/{${MatchNavArgs.TEAM_A}}/{${MatchNavArgs.TEAM_B}}/{${MatchNavArgs.GOALS_A}}/{${MatchNavArgs.GOALS_B}}"

    fun summaryRoute(teamA: String, teamB: String, goalsA: Int, goalsB: Int): String {
        return "$MATCH_SUMMARY/${Uri.encode(teamA)}/${Uri.encode(teamB)}/$goalsA/$goalsB"
    }

    fun resultRoute(teamA: String, teamB: String, goalsA: Int, goalsB: Int): String {
        return "$MATCH_RESULT/${Uri.encode(teamA)}/${Uri.encode(teamB)}/$goalsA/$goalsB"
    }
}

