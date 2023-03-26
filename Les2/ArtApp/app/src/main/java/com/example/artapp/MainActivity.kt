package com.example.artapp

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artapp.ui.theme.ArtAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtViewer()
                }
            }
        }
    }
}

@Composable
fun ArtViewer(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf( 1) }
    var resultImage = when(result){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    var imageDescription = when(result){
        1 -> R.string.lemon_tree_description
        2 -> R.string.lemon_description
        3 -> R.string.lemon_glass_description
        else -> R.string.empty_glass_description
    }
    var imageTitle = when(result){
        1 -> R.string.lemon_tree_title
        2 -> R.string.lemon_description
        3 -> R.string.lemon_glass_title
        else -> R.string.empty_glass_title
    }
    Column(modifier = modifier,  horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
       Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier
           .width(300.dp)
           .height(300.dp)
           .border(
               width = 2.dp,
               shape = RoundedCornerShape(topStart = 4.dp),
               color = Color(214, 217, 218)

           )) {

        Image(painter = painterResource(resultImage), contentDescription = imageTitle.toString())
       }
       Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
           .width(300.dp)
           .border(
               width = 2.dp,
               shape = RoundedCornerShape(topStart = 4.dp),
               color = Color(214, 217, 218)

           )) {
           Spacer(modifier = Modifier.height(height = 10.dp))
          Text(text = stringResource(imageTitle))
           Spacer(modifier = Modifier.height(height = 10.dp))
          Text(text = stringResource(imageDescription))
           Spacer(modifier = Modifier.height(height = 10.dp))
       }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(modifier = Modifier.width(120.dp) ,onClick = {if (result == 1){result=4}else{result-=1} }) {
                Text(text = stringResource(R.string.previous_button))
            }

            Button(modifier = Modifier.width(120.dp) ,onClick = {if (result == 4){result=1}else{result+=1} }) {
                Text(text = stringResource(R.string.next_button))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtAppTheme {
        ArtViewer()
    }
}