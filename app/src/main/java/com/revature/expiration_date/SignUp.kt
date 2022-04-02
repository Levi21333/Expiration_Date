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
import androidx.lifecycle.ViewModelProvider
import com.revature.expiration_date.datamodels.User
import com.revature.expiration_date.ui.theme.Expiration_DateTheme
import com.revature.expiration_date.viewmodels.UserViewModel

class SignUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setContent {
            Expiration_DateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SignUpScreen(userViewModel)
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(userViewModel: UserViewModel) {

    Column {
        TopAppBar {
            Text(text = "Sign Up Screen")
        }
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            var email by rememberSaveable{ mutableStateOf("")}
            TextField(value = email,
                modifier = Modifier.padding(16.dp),
                onValueChange = {email = it},
                placeholder = { Text(text = "Username")}
            )
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
                userViewModel.insertUser(User(
                    email = email,
                    name = username,
                    password = password)
                )
            }) {
               Text(text = "Sign Up")
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview41() {
//    val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
//    Expiration_DateTheme {
//        SignUpScreen(userViewModel)
//    }
//}