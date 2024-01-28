package com.example.catsdogs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.catsdogs.data.Animal
import com.example.catsdogs.data.FakeRepository
import com.example.catsdogs.ui.theme.CatsDogsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatsDogsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var isDialogVisible by remember { mutableStateOf(false) }
    val animals = FakeRepository().loadData()
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(text = "Cats and Dogs", style = MaterialTheme.typography.headlineLarge)
        }
        items(animals) { animal ->
            AnimalCard(animal = animal, onItemClick = { Log.d("Event", "Item clicked")}, onFavClick = {
                Log.d("Event", "Fav clicked")
            }, onShareClick = { Log.d("Event", "Share clicked")})
        }
    }
//    Card(
//        colors = CardDefaults.cardColors(
//            containerColor = Color.White
//        ),
//        modifier = Modifier
//            .padding(start = 35.dp, top = 100.dp, bottom = 500.dp, end = 10.dp)
//            .size(350.dp)
//            .border(
//                BorderStroke(10.dp, Color.Unspecified),
//                shape = RoundedCornerShape(10.dp)
//            )
//            .padding(end = 10.dp)
//    ) {
//        // Text(text ="CAT", color = Color.Black, modifier = Modifier.padding(start = 160.dp, top= 5.dp,))
//        Row {
//            Image(
//                painter = painterResource(id = R.drawable.cat3),
//                contentDescription = "cat",
//                modifier = Modifier
//                    .size(220.dp)
//                    .padding(top = 65.dp, end = 25.dp)
//            )
//            Column {
//                Text(
//                    text = "Name : Cutie",
//                    modifier = Modifier.padding(top = 95.dp),
//                    color = Color.Black
//                )
//                Text(
//                    text = "Age : 6",
//                    modifier = Modifier.padding(top = 10.dp),
//                    color = Color.Black
//                )
//                Text(
//                    text = "AnimalType : Cat",
//                    modifier = Modifier.padding(top = 10.dp),
//                    color = Color.Black
//                )
//            }
//        }
//    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun AnimalCard(
    modifier: Modifier = Modifier,
    animal: Animal,
    onItemClick: () -> Unit = {},
    onFavClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
) {
//    Text(text = animal.title)
    Card(
        onClick = onItemClick,
        modifier = modifier.padding()
    ) {
        Box {
            GlideImage(
                model = animal.image,
                loading = placeholder(ColorPainter(Color.LightGray)),
                contentDescription = animal.title,
                transition = CrossFade,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp)
            )
            Badge(
                modifier = Modifier
                    .padding(16.dp)
                    .align(
                        alignment = Alignment.TopEnd
                    )
            ) {
                Text(
                    text = animal.type.name, style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    )
                )
            }
            Text(
                text = "${animal.age} Yrs",
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(alignment = Alignment.BottomEnd)
                    .alpha(0.8f)

            )
        }
        Row(modifier=Modifier, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(
                    text = animal.title,
                    modifier = Modifier.padding(top = 10.dp, end = 230.dp),
                    fontWeight = FontWeight.W900,
                    fontSize = 23.sp
                )
            Row{
                IconButton(onClick = onFavClick) {
                    Icon(
                        imageVector = Icons.Default.Favorite, contentDescription = "Favorite",
                        modifier = Modifier.padding(start = 0.dp, top = 12.dp)
                    )
                }
                IconButton(onClick = onShareClick) {
                    Icon(
                        imageVector = Icons.Default.Share, contentDescription = "Share",
                        modifier = Modifier.padding(start = 7.dp, top = 12.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {
    CatsDogsTheme {
        //  AnimalCard(Animal(R.drawable.cat5, "Tia", 1, AnimalType.Cat))
        HomeScreen()
    }
}