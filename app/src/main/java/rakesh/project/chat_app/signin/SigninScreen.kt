package rakesh.project.chat_app.signin

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*


import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import rakesh.project.chat_app.R
import rakesh.project.chat_app.navigation.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(navController: NavController) {
    val context = LocalContext.current






    var storedVerificationId: String = ""






//    val context = LocalContext.current
    var phoneNumber by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var otp by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var isOtpVisible by remember { mutableStateOf(false) }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {




        // LottieAnimation for profile image
        val compnotify by rememberLottieComposition(
            spec = LottieCompositionSpec.Asset("ani.json")
        )
        val progress by animateLottieCompositionAsState(compnotify)
        LottieAnimation(
            composition = compnotify,
            iterations = Int.MAX_VALUE,
            isPlaying = true,
            contentScale = ContentScale.Crop,
            speed = 0.45f,
            modifier = Modifier
                .size(220.dp)
                .padding(2.dp)
                .clickable {
                    // Action when profile image clicked
                })


        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Signin", fontWeight = FontWeight.Bold, fontSize = 35.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "via", fontSize = 18.sp)


        Spacer(modifier = Modifier.height(20.dp))


        // Google sign-in button
        Card(
            modifier = Modifier
                .size(80.dp)
                .clickable {  },
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(id = R.drawable.kaneki),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().clickable { navController.navigate(Screens.HomeScreen.route) },
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "OR", fontSize = 18.sp)


        Spacer(modifier = Modifier.height(10.dp))


        // Phone number field
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                if (it.text.length <= 10) phoneNumber = it
            },
            label = { Text(text = "Phone No.", color = Color.Gray) },
            placeholder = { Text(text = "Name", fontSize = 14.sp) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .size(60.dp)


        )


        Spacer(modifier = Modifier.height(30.dp))


        if(isOtpVisible) {
            TextField(
                value = otp,
                placeholder = { Text("Enter otp") },
                onValueChange = { otp = it },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 4.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }


        if(!isOtpVisible) {
            Row( modifier = Modifier
                .padding(top = 8.dp)
                .padding(horizontal = 50.dp)) {
                Button(
                    onClick = {


                    },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 8.dp)
                ) {


                    Text(text = "Send otp", color = Color.White)
                }}
        }




        if(isOtpVisible) {


            Row( modifier = Modifier
                .padding(top = 8.dp)
                .padding(horizontal = 50.dp)) {
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 8.dp)


                ) {
                    Text(text = "Verify", color = Color.White)
                }
            }
        }






        Spacer(modifier = Modifier.height(30.dp))




    }
}
