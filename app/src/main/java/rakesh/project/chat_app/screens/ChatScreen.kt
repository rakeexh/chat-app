package rakesh.project.chat_app.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import rakesh.project.chat_app.R
import rakesh.project.chat_app.data.Chat
import rakesh.project.chat_app.data.chatList
import rakesh.project.chat_app.ui.theme.Gray400
import rakesh.project.chat_app.ui.theme.LightRed
import rakesh.project.chat_app.ui.theme.LightYellow


@Composable
fun ChatScreen(navController: NavController) {


    var message by remember { mutableStateOf("") }




    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            UserNameRow(
                modifier = Modifier.padding(top = 60.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.White, RoundedCornerShape(
                            topStart = 30.dp, topEnd = 30.dp
                        )
                    )
                    .padding(top = 25.dp)


            ) {
                LazyColumn(
                    modifier = Modifier.padding(
                        start = 15.dp,
                        top = 25.dp,
                        end = 15.dp,
                        bottom = 75.dp
                    )
                ) {
                    items(chatList, key = { it.id }) {
                        ChatRow(chat = it)
                    }
                }
            }
        }


        CustomTextField(
            text = message, onValueChange = { message = it },
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .align(BottomCenter)
        )
    }


}


@Composable
fun ChatRow(
    chat: Chat
) {


    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (chat.direction) Alignment.Start else Alignment.End
    ) {
        Box(
            modifier = Modifier
                .background(
                    if (chat.direction) LightRed else LightYellow,
                    RoundedCornerShape(100.dp)
                ),
            contentAlignment = Center
        ) {
            Text(
                text = chat.message, style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp),
                textAlign = TextAlign.End
            )
        }
        Text(
            text = chat.time,
            style = TextStyle(
                color = Gray,
                fontSize = 12.sp
            ),
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp),
        )
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    text: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = text, onValueChange = { onValueChange(it) },
        placeholder = {
            Text(
                text = "type_message",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black
                ),
                textAlign = TextAlign.Center
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Gray400,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = { CommonIconButton(imageVector = Icons.Default.Add) },
        trailingIcon = { CommonIconButton(imageVector = Icons.Default.ArrowForward) },
        modifier = modifier.fillMaxWidth(),
        shape = CircleShape
    )


}


@Composable
fun CommonIconButton(
    imageVector: ImageVector
) {


    Box(
        modifier = Modifier
            .background(Yellow, CircleShape)
            .size(33.dp), contentAlignment = Center
    ) {
        IconComponentImageVector(icon = imageVector, size = 15.dp, tint = Color.Black)
    }


}


@Composable
fun CommonIconButtonDrawable(
    @DrawableRes icon: Int
) {
    Box(
        modifier = Modifier
            .background(Yellow, CircleShape)
            .size(33.dp), contentAlignment = Center
    ) {
        Icon(
            painter = painterResource(id = icon), contentDescription = "",
            tint = Color.Black,
            modifier = Modifier.size(15.dp)
        )
    }


}


@Composable
fun UserNameRow(
    modifier: Modifier = Modifier,
) {


    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {


            IconComponentDrawable(icon = R.drawable.backgroundframe, size = 42.dp)
            SpacerWidth()
            Column {
                Text(
                    text = "Nandini Singh", style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = "online", style = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp
                    )
                )
            }
        }
        IconComponentImageVector(icon = Icons.Default.MoreVert, size = 24.dp, tint = Color.White)
    }


}


