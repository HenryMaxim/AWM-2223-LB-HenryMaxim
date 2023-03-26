package com.example.lemonade

import android.graphics.ColorSpace.Rgb
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonTapper()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonTapper()
    }
}

@Composable
fun LemonTapper(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf( 1) }
    var toRandom by remember { mutableStateOf( 1) }
    var random by remember { mutableStateOf( 1) }
    var resultText = when(result){
        1 -> R.string.step1
        2 -> R.string.step2
        3 -> R.string.step3
        else -> R.string.step4
    }
    var resultImage = when(result){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    var imageDescription = when(result){
        1 -> R.string.lemon_tree
        2 -> R.string.lemon
        3 -> R.string.glass_of_lemonade
        else -> R.string.empty_glass
    }
    Surface(
            modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colors.background,
    ){
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = stringResource(resultText),fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(resultImage),
            contentDescription = imageDescription.toString(),
            modifier =
            Modifier
                .border(
                width = 2.dp,
                shape = RoundedCornerShape(topStart = 4.dp),
                color = Color(105, 205, 216))
                .clickable {
                    if (result >= 4) {
                        result = 1
                    } else if (result == 2) {
                        random = (1..6).random()
                        if (toRandom == random) {
                            toRandom = 1; result += 1
                        } else if (toRandom > random) {
                            toRandom = 1; result += 1
                        } else {
                            toRandom += 1
                        }
                    } else {
                        result += 1
                    }
                })
       
        
    }}
}