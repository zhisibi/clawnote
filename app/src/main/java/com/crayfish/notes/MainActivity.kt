package com.crayfish.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.crayfish.notes.ui.screens.NoteEditorScreen
import com.crayfish.notes.ui.screens.TimelineScreen
import com.crayfish.notes.ui.screens.SettingsScreen
import com.crayfish.notes.ui.theme.CrayfishNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrayfishNotesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "timeline") {
        composable("timeline") {
            TimelineScreen(
                viewModel = hiltViewModel(),
                onNoteClick = { noteId ->
                    navController.navigate("editor/$noteId")
                },
                onNewNoteClick = {
                    navController.navigate("editor/new")
                }
            )
        }
        composable("editor/{noteId}") { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")
            val editorViewModel: com.crayfish.notes.ui.viewmodel.NoteEditorViewModel = hiltViewModel()
            androidx.compose.runtime.LaunchedEffect(noteId) {
                editorViewModel.loadNote(noteId)
            }
            NoteEditorScreen(
                viewModel = editorViewModel,
                onBack = { navController.popBackStack() }
            )
        }
        composable("settings") {
            SettingsScreen(
                viewModel = hiltViewModel(),
                onBack = { navController.popBackStack() }
            )
        }
    }
}
