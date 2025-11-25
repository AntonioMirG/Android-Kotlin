package com.example.galeriadarte

//import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.galeriadarte.ui.theme.GaleriaDArteTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.rememberComposableLambdaN
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.max
import kotlin.math.round


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GaleriaDArteTheme {
                galery()
            }
        }
    }
}

data class obrasDArte(
    val imagen: Int,
    val descripcion: String
)


@Composable
fun galery(){

    val imagenes = listOf(
        obrasDArte(R.drawable.foto1,"Torre Eiffel - pintura al óleo" ),
        obrasDArte(R.drawable.foto2,"Stuke - pintura en lienzo" ),
        obrasDArte(R.drawable.foto3,"El grito - Edvard Munch (1893)" ),
        obrasDArte(R.drawable.foto4,"La Promenenade - Claude Monet (1875)" ),
    )
    val maxSize = imagenes.size

    val colorFondo = Color(0xFFAEC6CF)
    val colorAnterior = Color(0xFFFFB6C1)
    val colorSiguiente = Color(0xFFB4FBB4)



    var numeroImagen by remember { mutableIntStateOf(0) }

    var obra = imagenes[numeroImagen]

    fun anterior(){
        numeroImagen = (numeroImagen - 1 + maxSize) % maxSize
    }

    fun siguiente(){
        numeroImagen = (numeroImagen +1 ) % maxSize
    }

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
                .padding(top = 100.dp)
                .width(400.dp)
                .height(300.dp)
        ){

            Image(
                painter = painterResource(obra.imagen),
                contentDescription = "Foto1",
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        //Descripción
        Box(
            modifier = Modifier
                .padding(top = 40.dp)
                .width(300.dp)
                .height(100.dp)
                .background(colorFondo, shape = RoundedCornerShape(20.dp))


        ){

            Text(
                text = obra.descripcion,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Row (

            modifier = Modifier
                .width(250.dp)

            ,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Botones
            Box(
                modifier = Modifier
                    .padding(top = 140.dp)
                    .height(100.dp)
                    .width(120.dp)

            ){

                Button(
                    onClick = {anterior() },
                    colors = ButtonDefaults.buttonColors(colorAnterior),


                ){
                    Text("Anterior")
                }
            }

            //Botones
            Box(
                modifier = Modifier
                    .padding(top = 140.dp)
                    .height(100.dp)
                    .width(120.dp)
            ){

                Button(
                    onClick = { siguiente()},
                    colors = ButtonDefaults.buttonColors(containerColor = colorSiguiente )
                ){
                    Text("Siguiente")
                }

            }

        }


    }

}

@Preview(showBackground = true)
@Composable
fun GaleryPreview(){
    galery()
}