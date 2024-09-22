package com.example.recetas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.recetas.ui.theme.RecetasTheme

class Comida : ComponentActivity() {
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
fun RecipeApp(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
        .background(Color.White),
    ) {
        item {
            RecipeItem(
                title = "Rellenitos",
                color = Color(0xFF072A6C),
                description = "Los tamalitos de elote tienen la característica de ser dulces. Se hacen con el grano del elote tierno triturado y molido. Se acostumbra servirlos con crema o queso, para acompañar una tarde junto a la familia.",
                imageRes = R.drawable.img_2,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "LISTA DE COMPRAS",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(10.dp).fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color(0xFF072A6C),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "- 6 plátanos maduros\n - 1.5 tazas de agua\n - 1 raja de canela\n - Media taza de miga de pan\n - 1 taza de frijol negro o frijoles volteados\n - Azúcar al gusto\n - Media cucharadita de canela\n - 2 onzas de chocolate\n - Media taza de harina\n - Aceite para freir",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier.padding(start = 16.dp)
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_9),
                    contentDescription = "imagen compras",
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color.White, shape = CircleShape),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "PREPARACIÓN",
                color = Color(0xFF072A6C),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(10.dp).fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = " 1. Primero, cortar el plátano en trozos y cocinar en el agua, con canela en raja y azúcar \n\n 2. Retirar la cáscara, hacerlos puré y agregar la miga de pan\n\n 3. Freír el frijol previamente cocinado y licuado espeso con el azúcar, la canela en polvo y el chocolate\n\n 4. Darle al plátano forma de tortita, rellenar con una cucharada de frijol y cerrar en forma de rellenito\n\n 5. Pasar por harina y freír en aceite.\n\n 6. Espolvorear con azúcar \n\n 7. Si se desea se puede sustituir el frijol por manjar",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier.padding(start = 16.dp)
                        .padding(end = 18.dp)
                        .padding(bottom = 30.dp)
            )
            Text(
                text = "¡HECHO!",
                color = Color(0xFF072A6C),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp).fillMaxWidth()
                    .clickable {
                        navController.navigate("Card")
                    }
            )

        }
    }
}

@Composable
fun RecipeItem(title: String, description: String, imageRes: Int, color: Color) {
    Column {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFF072A6C),
            fontWeight = FontWeight.Bold
        )
        if (description.isNotEmpty()) {
            Text(
                text = description,
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(10.dp).fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_8),
                contentDescription = "imagen compras",
                modifier = Modifier
                    .size(60.dp)
                    .background(Color.White, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeAppPreview() {
    RecipeApp(rememberNavController())
}


