package com.example.galeriadarte

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.galeriadarte.ui.theme.GaleriaDArteTheme
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GaleriaDArteTheme {

            }
        }
    }
}

@Composable
fun galery(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Fotos
        Box(
            modifier = Modifier
                .padding(top=100.dp)
                .background(Color.Red)
                .width(400.dp)
                .height(300.dp)
        ){

        }

        //Descripción
        Box(
            modifier = Modifier
                .padding(top=200.dp)
                .width(300.dp)
                .height(100.dp)
                .background(Color.Blue)

        ){

        }

        //Botones
        Box(){

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GaleryPreview(){
    galery()
}