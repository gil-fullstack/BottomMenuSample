package com.tinellus.bottommenusample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.webkit.Profile
import com.tinellus.bottommenusample.ui.theme.BottomMenuSampleTheme
import com.tinellus.bottommenusample.ui.theme.GreenJC

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomMenuSampleTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBottomAppBar()
                }
            }
        }
    }
}

@Composable
fun MyBottomAppBar() {
     val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = GreenJC) {
                IconButton(onClick = {
                    selected.value = Icons.Default.Home
                    navigationController.navigate(Screens.Home.screenName){
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                    )
                }
                IconButton(onClick = {
                    selected.value = Icons.Default.Search
                    navigationController.navigate(Screens.Search.screenName){
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Search) Color.White else Color.DarkGray
                    )
                }
                Box(modifier = Modifier.weight(1f)
                    .padding(16.dp),
                    contentAlignment = Alignment.Center
                    ){
                    FloatingActionButton(
                        onClick = {Toast.makeText(context,
                            "Floating Action Button",
                            Toast.LENGTH_SHORT).show()}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = GreenJC
                        )
                    }
                }
                IconButton(onClick = {
                    selected.value = Icons.Default.Person
                    navigationController.navigate(Screens.Profile.screenName){
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Person) Color.White else Color.DarkGray
                    )
                }
                IconButton(onClick = {
                    selected.value = Icons.Default.Notifications
                    navigationController.navigate(Screens.Notifications.screenName){
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Notifications) Color.White else Color.DarkGray
                    )
                }

            }

        }
    ) {
        paddingValues ->
        NavHost(navController = navigationController,
            startDestination = Screens.Home.screenName,
            modifier = Modifier.padding(paddingValues)){
            composable(Screens.Home.screenName){
                Home()
            }
            composable(Screens.Profile.screenName){
                Profile()
            }
            composable(Screens.Search.screenName){
                Search()
            }
            composable(Screens.Notifications.screenName){
                Notification()
            }

        }
    }
}