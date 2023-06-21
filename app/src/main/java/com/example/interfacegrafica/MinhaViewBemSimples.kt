package com.example.interfacegrafica

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MinhaViewBemSimples : ViewModel ()
{
    private val _contadorDaViewModel = MutableStateFlow(0)
    val contadorDaViewPublico: StateFlow<Int> get() = _contadorDaViewModel

    fun incremenaContador()
    {
        _contadorDaViewModel.value = _contadorDaViewModel.value + 1
    }
}
