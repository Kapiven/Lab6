package com.example.recetas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recetas.ui.theme.RecetasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecetasTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") { ChefRecipesScreen(navController, Modifier.padding(innerPadding)) }
                        composable("menu") { MainScreen(navController, Modifier.padding(innerPadding)) }
                        composable("home") { RecetasApp(navController, Modifier.padding(innerPadding)) }
                        composable("comida") { RecipeApp(navController, Modifier.padding(innerPadding)) }
                        composable("card") { CongratulatoryPopup(navController) }
                    }
                }
            }
        }
    }
}

@Composable
fun ChefRecipesScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Sombrero",
                modifier = Modifier.size(500.dp)
            )
            Text(
                text = "Chef Recipes",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 50.sp,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.clickable {
                    navController.navigate("menu")
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChefRecipesScreen() {
    RecetasTheme {
        ChefRecipesScreen(rememberNavController())
    }
}
