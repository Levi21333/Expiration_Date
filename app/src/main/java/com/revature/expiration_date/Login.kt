package com.revature.expiration_date

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.revature.expiration_date.datamodels.User
import com.revature.expiration_date.ui.theme.Expiration_DateTheme
import com.revature.expiration_date.viewmodels.UserViewModel

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userViewModel =ViewModelProvider(this).get(UserViewModel::class.java)
        setContent {
            Expiration_DateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen(userViewModel)
                }
            }
        }
    }
}

@Composable
fun LoginScreen(userViewModel: UserViewModel) {

    val userList = userViewModel.readAllData().observeAsState(arrayListOf())

    val context = LocalContext.current
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
            var word by rememberSaveable { mutableStateOf("")}
            TextField(value = word,
                modifier = Modifier.padding(16.dp),
                onValueChange = {word = it},
                placeholder = {Text(text = "Password")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            //Can I treat an object like a list?
            Button(onClick = {
                val holder =userList.value
                holder.forEach { user ->
                    if (username.equals(user.name) && word.equals(user.password)){
                        context.startActivity(Intent(context,ProductView::class.java))
                    }else{
                        Toast.makeText(context,"Invalid username or password",Toast.LENGTH_SHORT).show()
                    }
                }
            }) {
               Text(text = "Login")
            }

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview2() {
//    Expiration_DateTheme {
//        LoginScreen()
//    }
//}