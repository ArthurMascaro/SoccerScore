package br.edu.ifsp.scl.sc3044599.soccerscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.edu.ifsp.scl.sc3044599.soccerscore.screens.SoccerScoreApp
import br.edu.ifsp.scl.sc3044599.soccerscore.ui.theme.SoccerScoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoccerScoreTheme {
                SoccerScoreApp()
            }
        }
    }
}
