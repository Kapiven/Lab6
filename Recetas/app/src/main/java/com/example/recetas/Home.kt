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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.recetas.ui.theme.RecetasTheme

class Home : ComponentActivity() {
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
fun RecetasApp(navController: NavHostController, modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        TopAppBar(
            modifier = Modifier
                .background(Color.White),
            title = { Text("POPULAR RECIPES") },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Favorite, contentDescription = "Bookmark")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Red,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White,
                navigationIconContentColor = Color.White
            )
        )

        TabRow(selectedTabIndex = 0, modifier = Modifier.padding(20.dp)) {
            Tab(selected = true, onClick = { }, modifier = Modifier.background(Color.White)) {
                Text("APPETIZERS")
            }
            Tab(selected = false, onClick = { }, modifier = Modifier.background(Color.White)) {
                Text("ENTREES")
            }
            Tab(selected = false, onClick = { }, modifier = Modifier.background(Color.White)) {
                Text("DESSERT")
            }
        }

        LazyRow(modifier = Modifier.padding(16.dp)) {
            items(listOf(
                Recipe("Rellenitos", "Estos pequeños postres son muy típicos de Guatemala y se preparan a base de plátano maduro relleno de frijoles dulces.", 185, R.drawable.img_2),
                Recipe("Tamalitos de elote", "Los tamalitos de elote tienen la característica de ser dulces. Se hacen con el grano del elote tierno triturado y molido. Se acostumbra servirlos con crema o queso.", 107, R.drawable.img_3),
                Recipe("Chuchitos", "Platillo elaborado a base de maíz y rellenado con un recado delicioso que puedes acompañar con carne de pollo, res y cerdo.", 150, R.drawable.img_7),
                Recipe("Arroz en leche", " Postre típico de la gastronomía de múltiples países hecho cociendo lentamente arroz con leche y azúcar. Se sirve frío o caliente y se le suele espolvorear canela o vainilla.", 130, R.drawable.img_6),
                Recipe("Hilachas", "Preparación a base de  carne de res deshilachada, que se cocina lentamente con  verduras y especias para obtener un guiso suave y sabroso.", 175, R.drawable.img_5),
                Recipe("Tamales", "Aprende a preparar este platillo tradicional de Guatemala con masa de maíz, carne de cerdo, recado y frutas secas.", 100, R.drawable.img_4)
            )) { recipe ->
                RecetaItem(
                    navController = navController,
                    title = recipe.title,
                    description = recipe.description,
                    likes = recipe.likes,
                    imageRes = recipe.imageRes
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}

data class Recipe(val title: String, val description: String, val likes: Int, val imageRes: Int)

@Composable
fun RecetaItem(navController: NavHostController, title: String, description: String, likes: Int, imageRes: Int) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = title, style = MaterialTheme.typography.titleLarge,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 8.dp)
                .clickable {
                    navController.navigate("comida")
                }

        )
        if (description.isNotEmpty()) {
            Text(text = description, style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    modifier = Modifier
                    .padding(vertical = 10.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Favorite, contentDescription = "Likes")
            Text(text = "$likes", color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecetasAppPreview() {
    RecetasApp(rememberNavController())
}
