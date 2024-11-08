package com.example.desarrollodeinterfaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.desarrollodeinterfaces.ui.theme.DesarrolloDeInterfacesTheme
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun MyBox(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Box(modifier=Modifier.width(50.dp).height(50.dp).background(Color.Cyan))
    }
}

@Composable
fun ReplicarLayout(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Box (modifier = modifier.fillMaxWidth().weight(2f).background(Color.Cyan), contentAlignment = Alignment.Center) {
            Text(text = "Ejemplo 1")
        }
        Row(modifier = modifier.fillMaxWidth().weight(2f)) {
            Box(modifier = modifier.fillMaxHeight().weight(1f).background(Color.Red), contentAlignment = Alignment.Center) {
                Text(text = "Ejemplo 2")
            }
            Box(modifier = modifier.fillMaxHeight().weight(1f).background(Color.Green), contentAlignment = Alignment.Center){
                Text(
                    text = "Ejemplo 3"
                )
            }
        }
        Box(modifier = modifier.fillMaxWidth().weight(2f).background(Color.Magenta), contentAlignment = Alignment.BottomCenter) {
            Text(text = "Ejemplo 4")
        }
    }
}

@Composable
fun ReplicarLayout2(modifier: Modifier=Modifier){
    Column(modifier = modifier.fillMaxSize()) {
        Row(modifier = modifier.fillMaxWidth().weight(1f)) {
            Box(modifier = modifier.fillMaxHeight().weight(2f).background(Color.Blue), contentAlignment = Alignment.Center){
                Text(text = "Columna Azul")
            }
            Box(modifier = modifier.fillMaxHeight().weight(1f).background(Color.Red)){
                Text(text = "Columna Roja")
            }
        }
        Row(modifier = modifier.fillMaxWidth().weight(1f)) {
            Box(modifier = modifier.fillMaxHeight().weight(3f).background(Color.Yellow)){
                Text(text = "Columna Amarilla")
            }
            Box(modifier = modifier.fillMaxHeight().weight(1f).background(Color.Magenta)){
                Text(text = "Columna Magenta")
            }
            Box(modifier = modifier.fillMaxHeight().weight(2f).background(Color.Cyan)){
                Text(text = "Columna Cyan")
            }
            Box(modifier = modifier.fillMaxHeight().weight(1f).background(Color.Green)){
                Text(text = "Columna Verde")
            }
        }
    }
}

@Composable
fun ReplicarLayout3(modifier: Modifier = Modifier){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxC, boxB,boxG,boxR,boxM,boxY) = createRefs()
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Cyan)
            .constrainAs(boxC){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxB){
                end.linkTo(boxR.start)
                bottom.linkTo(boxR.top)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxG){
                bottom.linkTo(boxR.top)
                start.linkTo(boxR.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxR){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxM){
                top.linkTo(boxR.bottom)
                end.linkTo(boxR.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxY){
                top.linkTo(boxR.bottom)
                start.linkTo(boxR.end)
            })
    }
}

@Composable
fun MyStateLayout(modifier: Modifier = Modifier){
    var counter by rememberSaveable() { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {counter+=1}){
            Text(text = "pulsar")
        }
        Text(text = "He sido pulsado $counter veces")
    }
}

@Composable
fun MyText(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize()){
        Text(text = "Ejemplo 1")
        Text(
            text = "Ejemplo 2",
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "Ejemplo 3",
            textDecoration = TextDecoration.LineThrough
            )
        Text(text = "Ejemplo 4")
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesarrolloDeInterfacesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyStateLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    DesarrolloDeInterfacesTheme {
        MyText()
    }
}