package com.revature.expiration_date

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.expiration_date.ui.theme.Expiration_DateTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Expiration_DateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    Column {
        TopAppBar() {
            Text(text = "Login Screen")
        }
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            //TextField Username
            var username by rememberSaveable{ mutableStateOf("")}
            TextField(value = username,
                modifier = Modifier.padding(16.dp),
                onValueChange = {username = it},
                placeholder = { Text(text = "Username")}
            )
            //TextField Password
            var password by rememberSaveable { mutableStateOf("")}
            TextField(value = password,
                modifier = Modifier.padding(16.dp),
                onValueChange = {password = it},
                placeholder = {Text(text = "Password")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            Button(onClick = {

            }) {
               Text(text = "Login")
            }

            //TextField Confirm Password
            //Button 'Login' -> Product View

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Expiration_DateTheme {
        LoginScreen()
    }
}