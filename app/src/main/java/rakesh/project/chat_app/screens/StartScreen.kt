package rakesh.project.chat_app.screens

import android.graphics.drawable.Icon
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import rakesh.project.chat_app.R
import rakesh.project.chat_app.navigation.Screens

@Composable
fun StartScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Black
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(id = R.drawable.backgroundframe),
            contentDescription = "backgroundframe",
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "hello rakesh!!!",
            fontSize = 50.sp,
            color = Color.White,
            lineHeight = 20.sp
        )
        Row {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = " ",
                tint = Color.White
            )


            Text(
                text = "secure,private messaging",
                fontSize = 20.sp,
                color = Color.White,
                lineHeight = 20.sp,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(10.dp))


        }
        Button(onClick = { navController.navigate(Screens.SignInScreen.route)},
            modifier = Modifier.
            clip(RoundedCornerShape(topStart = 5.dp, topEnd = 90.dp))
        .fillMaxWidth()) {
            Text(text = "Get started")
        }
    }
}