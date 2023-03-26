package com.example.tipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipapp.data.Tip
import com.example.tipapp.data.tips
import com.example.tipapp.ui.theme.TipAppTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipAppTheme {
                // A surface container using the 'background' color from the theme
                TipApp()
            }
        }
    }
}

@Composable
fun TipApp() {
    Scaffold(
        topBar = {
            TipTopAppBar()
        }
    ){ paddingValues ->
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background).padding(paddingValues)) {
            items(tips) {
                TipItem(tip = it)
            }
        }
    }
}

@Composable
fun TipTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .size(90.dp)
                .padding(8.dp),
            painter = painterResource(R.drawable.gym_and_fitness_logo_png),
            /*
             * Content Description is not needed here - image is decorative, and setting a null
             * content description allows accessibility services to skip this element during
             * navigation.
             */
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.title),
            style = MaterialTheme.typography.h1,
            fontSize = 35.sp
        )
    }
}

@Composable
fun TipItem(tip: Tip, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = 4.dp,
        modifier = modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )


                )
        ) {
            TipInformation(tip.name, tip.day, tip.imageResourceId)
            TipItemButton(
                expanded = expanded,
                onClick = { expanded = !expanded },
            )
            if (expanded) {
        TipInformation(tip.explanation)
        }
    }

    }
}

@Composable
fun TipInformation(@StringRes tipName: Int, tipDay: Int, @DrawableRes tipImage: Int , modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = stringResource(R.string.what_day, tipDay), 
            style = MaterialTheme.typography.body1,
            fontSize = 25.sp

        )
        Text(
            text = stringResource(tipName),
            style = MaterialTheme.typography.h2,
            modifier = modifier.padding(top = 8.dp),
            fontSize = 25.sp
        )

        Image(
            painter = painterResource(tipImage),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )

    }
}

@Composable
fun TipInformation(@StringRes tipInfo: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {  Text(
        text = stringResource(R.string.about),
        style = MaterialTheme.typography.h3,
        fontSize = 35.sp
    )
        Text(
            text = stringResource(tipInfo),
            style = MaterialTheme.typography.body1,
        )}
}

@Composable
private fun TipItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipAppTheme(darkTheme = false) {
        TipApp()
    }
}

/**
 *    https://www.health.com/fitness/30-tips-to-get-fitter-in-30-days.
 */