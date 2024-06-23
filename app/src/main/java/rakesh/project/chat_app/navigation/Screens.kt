package rakesh.project.chat_app.navigation

sealed class Screens(val route: String){




    object SignInScreen:Screens("sign_in")
    object HomeScreen:Screens("home")
    object StartScreen: Screens("start")
    object ChatScreen: Screens("chat")
    object SplashScreen: Screens("splash")
    object ProfileScreen: Screens("profile")
}
