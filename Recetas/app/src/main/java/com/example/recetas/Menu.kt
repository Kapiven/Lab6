package com.example.recetas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.recetas.ui.theme.RecetasTheme

class Menu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecetasTheme {

                    }

                }
            }
        }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen(navController: NavHostController, modifier: Modifier = Modifier) {
        val drawerState = rememberDrawerState(DrawerValue.Open)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(navController)
            }
        ) {

        }
    }

    @Composable
    fun DrawerContent(navController: NavHostController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .padding(40.dp)
        ) {
            Text(
                text = "POPULAR RECIPES",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
                    .clickable {
                        navController.navigate("home")
                    }
            )
            Text(
                text = "SAVED RECIPES",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "SHOPPING LIST",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "SETTINGS",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "imagen usuario",
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.White, shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "HARRY TRUMAN",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewMainScreen() {
        RecetasTheme {
            MainScreen(rememberNavController())
        }
    }
