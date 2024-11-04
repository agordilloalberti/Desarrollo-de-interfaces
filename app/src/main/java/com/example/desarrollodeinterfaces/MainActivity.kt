package com.example.desarrollodeinterfaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.desarrollodeinterfaces.ui.theme.DesarrolloDeInterfacesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesarrolloDeInterfacesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ReplicarLayout2(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyBox(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Box(modifier=Modifier.width(50.dp).height(50.dp).background(Color.Cyan))
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    DesarrolloDeInterfacesTheme {
        ReplicarLayout2()
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
