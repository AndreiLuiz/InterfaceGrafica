package com.example.interfacegrafica

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity()
{
    private lateinit var minhaViewModeQueEuCrieiAgoraPouco: MinhaViewBemSimples

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        minhaViewModeQueEuCrieiAgoraPouco = ViewModelProvider(this).get(MinhaViewBemSimples::class.java)
        setContent {
            MainScreen(minhaViewModeQueEuCrieiAgoraPouco)
        }
    }
}

@Composable
fun MainScreen(umaViewModel: MinhaViewBemSimples){
    var contadorNaView by remember {
        mutableStateOf(0)
    }

    val contadorProvenienteDaMinhaModelView by umaViewModel.contadorDaViewPublico.collectAsState()

    Column() {
        Button(onClick = {contadorNaView = contadorNaView + 1
            umaViewModel.incremenaContador()
            Log.i("NOSSO_LOG", "Vlr do Contador = $contadorNaView")
        }) {
            Text(text = "INCRIMENTO CONTADOR")
        }
        Text(text = "Vlr do Contador Controlado pela View = $contadorNaView")
        Text(text = "Vlr do Contador Controlado pela ViewModel = $contadorProvenienteDaMinhaModelView")
    }
}

@Composable
fun MinhaSaudacao(
    nomeX :String = "World",
    adjetivoDoNomex: String,
    modificador : Modifier){

    Text(text = "Hello $nomeX $adjetivoDoNomex", modifier = modificador)
}
@Composable
fun Greeting(name: String, modificador: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modificador
    )
}
@Preview(showBackground = true)
@Composable
fun MinhaPreview() {

}