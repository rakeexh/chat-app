package rakesh.project.chat_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import rakesh.project.chat_app.bottombar.BottomBar
import rakesh.project.chat_app.navigation.MainNavController
import rakesh.project.chat_app.navigation.Screens
import rakesh.project.chat_app.screens.ChatScreen
import rakesh.project.chat_app.screens.HomeScreen
import rakesh.project.chat_app.screens.StartScreen
import rakesh.project.chat_app.signin.SignInScreen
import rakesh.project.chat_app.ui.theme.ChatappTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navController = rememberNavController()
                    val bottomBarState = rememberSaveable { mutableStateOf(true) }
                    val navBackStackEntry by navController.currentBackStackEntryAsState()


                    navBackStackEntry?.destination?.route?.let { route ->
                        bottomBarState.value = when (route) {
                            Screens.HomeScreen.route,
                            Screens.ProfileScreen.route ->true
                            else -> false
                        }
                    }


                    Scaffold(
                        bottomBar = {
                            BottomBar(
                                navController = navController,
                                bottomBarState = bottomBarState
                            )
                        }
                    ) {
                        val scaffoldState = rememberScaffoldState()
                        MainNavController(
                            navController
                        )
                    }
                }
            }
        }
    }

}
