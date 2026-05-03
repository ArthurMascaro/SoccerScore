package br.edu.ifsp.scl.sc3044599.soccerscore.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.edu.ifsp.scl.sc3044599.soccerscore.domain.MatchNavArgs
import br.edu.ifsp.scl.sc3044599.soccerscore.domain.SoccerScoreRoutes

@Composable
fun SoccerScoreApp() {
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = SoccerScoreRoutes.MATCH_FORM,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = SoccerScoreRoutes.MATCH_FORM) {
                MatchFormScreen(
                    onViewResultClick = { teamA, teamB, goalsA, goalsB ->
                        navController.navigate(
                            SoccerScoreRoutes.summaryRoute(
                                teamA = teamA,
                                teamB = teamB,
                                goalsA = goalsA,
                                goalsB = goalsB
                            )
                        )
                    }
                )
            }

            composable(
                route = SoccerScoreRoutes.MATCH_SUMMARY_ROUTE,
                arguments = listOf(
                    navArgument(MatchNavArgs.TEAM_A) { type = NavType.StringType },
                    navArgument(MatchNavArgs.TEAM_B) { type = NavType.StringType },
                    navArgument(MatchNavArgs.GOALS_A) { type = NavType.IntType },
                    navArgument(MatchNavArgs.GOALS_B) { type = NavType.IntType }
                )
            ) { entry ->
                val teamA = entry.arguments?.getString(MatchNavArgs.TEAM_A).orEmpty()
                val teamB = entry.arguments?.getString(MatchNavArgs.TEAM_B).orEmpty()
                val goalsA = entry.arguments?.getInt(MatchNavArgs.GOALS_A) ?: 0
                val goalsB = entry.arguments?.getInt(MatchNavArgs.GOALS_B) ?: 0

                MatchSummaryScreen(
                    teamA = teamA,
                    teamB = teamB,
                    goalsA = goalsA,
                    goalsB = goalsB,
                    onConfirmClick = {
                        navController.navigate(
                            SoccerScoreRoutes.resultRoute(
                                teamA = teamA,
                                teamB = teamB,
                                goalsA = goalsA,
                                goalsB = goalsB
                            )
                        )
                    },
                    onEditClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable(
                route = SoccerScoreRoutes.MATCH_RESULT_ROUTE,
                arguments = listOf(
                    navArgument(MatchNavArgs.TEAM_A) { type = NavType.StringType },
                    navArgument(MatchNavArgs.TEAM_B) { type = NavType.StringType },
                    navArgument(MatchNavArgs.GOALS_A) { type = NavType.IntType },
                    navArgument(MatchNavArgs.GOALS_B) { type = NavType.IntType }
                )
            ) { entry ->
                val teamA = entry.arguments?.getString(MatchNavArgs.TEAM_A).orEmpty()
                val teamB = entry.arguments?.getString(MatchNavArgs.TEAM_B).orEmpty()
                val goalsA = entry.arguments?.getInt(MatchNavArgs.GOALS_A) ?: 0
                val goalsB = entry.arguments?.getInt(MatchNavArgs.GOALS_B) ?: 0

                MatchResultScreen(
                    teamA = teamA,
                    teamB = teamB,
                    goalsA = goalsA,
                    goalsB = goalsB,
                    onNewGameClick = {
                        navController.navigate(SoccerScoreRoutes.MATCH_FORM) {
                            popUpTo(SoccerScoreRoutes.MATCH_FORM) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}
