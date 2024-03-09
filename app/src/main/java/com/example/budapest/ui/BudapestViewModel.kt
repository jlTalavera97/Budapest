package com.example.budapest.ui

import androidx.lifecycle.ViewModel
import com.example.budapest.model.BudapestUiState
import com.example.budapest.model.LugaresItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class BudapestViewModel: ViewModel(){

    //Variable MUTABLE y PRIVADA para modificar de forma segura los valores desde el ViewModel
    private val _uiState = MutableStateFlow(BudapestUiState())
    //Variable INMUTABLE de la que la UI solicitara informacion
    val uiState: StateFlow<BudapestUiState> = _uiState.asStateFlow()

    fun updateOpcion(opcion: LugaresItem){
        _uiState.update { currentState ->
            currentState.copy(
                tipoElegido = opcion.name,
                lugar = currentState.lugar
            )
        }
    }

    fun updateLugar(opcion: LugaresItem){
        _uiState.update { currentState ->
            currentState.copy(
                lugar = opcion.name,
                tipoElegido = currentState.tipoElegido
            )
        }
    }

    //Funcion que nos deja por defecto los valores de la UI
    fun reset(){
        _uiState.value = BudapestUiState()
    }
}