package com.example.budapest.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.budapest.R
import com.example.budapest.data.Datasource
import com.example.budapest.model.LugaresItem

//Clase enum con las posibles pantallas de nuestra app
enum class BudapestScreen(@StringRes val title: Int, val icon: Int){
    Inicio(title = R.string.app_name, R.drawable.bandera_budapest),
    Opciones(title = R.string.inicio, R.drawable.menu),
    Lugares(title = R.string.lugares, R.drawable.location),
    Detalle(title = R.string.detalle, R.drawable.info)
}


/*Funcion que nos crea(la inflaremos en la funcion principal) la barra superior a la que le pasamos los parametros:
* currentScreen -> Para colocarlo como titulo
* canNavigateBack -> Para saber si podemos ir hacia atras(Comprobar si estamos en Inicio)
* navigateUp -> Llamara a la función que nos permitira navegar HACIA ATRAS en la pila
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudapestBar(
    currentScreen: BudapestScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    CenterAlignedTopAppBar(
        title = { Text(stringResource(id = currentScreen.title))},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier,
        navigationIcon = {
            if(canNavigateBack){
                IconButton(onClick =  navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        },
        actions ={
            Image(
                painter = painterResource(currentScreen.icon),
                contentDescription = null,
                modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_small))
            )
        }
    )
}

@Composable
fun BudapestApp(modifier: Modifier){
    //Inicializamos el controlador de navegacion
    val navController: NavHostController = rememberNavController()
    //Guardamos la transicion actual de la pila
    val backStackEntry by navController.currentBackStackEntryAsState()
    //Almacenamos la pantalla actual fijandonos en la pila. Colocamos Inicio por si viene null
    val currentScreen = BudapestScreen.valueOf(
        backStackEntry?.destination?.route ?: BudapestScreen.Inicio.name
    )

    //Instanciamos el ViewModel
    val viewModel: BudapestViewModel = viewModel()

    Scaffold(
        topBar = {
            //Inflamos la barra superior
            BudapestBar(
                //Pantalla actual extraida de la pila
                currentScreen = currentScreen,
                //Si la ultima entrada de la pila es null, estaremos en inicio
                canNavigateBack = navController.previousBackStackEntry != null,
                //Llamamos a navigateUp() para navegar hacia atrás en la pila
                navigateUp = {navController.navigateUp()}
            )
        },
        modifier = Modifier.fillMaxSize()
    ){ innerPadding ->
        //Almacenamos el estado de la UI
        val uiState by viewModel.uiState.collectAsState()

        //Creamos esquema de navegacion
        NavHost(
            navController = navController,
            startDestination = BudapestScreen.Inicio.name,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .fillMaxSize()
        ){
            composable(route = BudapestScreen.Inicio.name){
                InicioScreen(
                    onStartExploringButtonClicked = { navController.navigate(BudapestScreen.Opciones.name) },
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(route = BudapestScreen.Opciones.name){
               OpcionesScreen(
                   options = Datasource.tipoLugar,
                   onOptionClicked = {
                       viewModel.updateOpcion(it)
                       navController.navigate(BudapestScreen.Lugares.name)
                   },
                   modifier = Modifier.fillMaxSize()
               )
            }
            composable(route = BudapestScreen.Lugares.name){
                val opcionesLugar = when (uiState.tipoElegido){
                    R.string.restaurantes -> Datasource.restaurantes
                    R.string.actividades -> Datasource.actividades
                    R.string.monumentos -> Datasource.monumentos
                    else -> Datasource.restaurantes
                }
                LugaresScreen(
                    options = opcionesLugar,
                    onOptionClicked = {
                        viewModel.updateLugar(it)
                        navController.navigate(BudapestScreen.Detalle.name)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(route = BudapestScreen.Detalle.name){
                val opcionesLugar = when (uiState.tipoElegido){
                    R.string.restaurantes -> Datasource.restaurantes
                    R.string.actividades -> Datasource.actividades
                    R.string.monumentos -> Datasource.monumentos
                    else -> Datasource.restaurantes
                }
                val detalleLugar: LugaresItem =
                    opcionesLugar.find { it.name == uiState.lugar } ?: Datasource.restaurantes[3]
                val context = LocalContext.current
                DetallesScreen(
                    detalleLugar,
                    onSearchPlaceClicked = {searchPlace(detalleLugar,context)},
                    onHomeButtonClicked = { goHome(navController) },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

}
//Funcion que nos devolverá a la pantalla de inicio y reseteara la informacion a traves del viewModel
private fun goHome(navController: NavController){
    //popBackStack nos elimina el destino actual y nos permite retroceder a la fase de la pila indicada)
    navController.popBackStack(BudapestScreen.Opciones.name, inclusive = false)
}

private fun searchPlace(lugar: LugaresItem, context: Context){
    val encodedPlaceName = Uri.encode((context.getString(lugar.name)))
    val gmmIntentUri = (Uri.parse("geo:47.50094444, 19.04841667?q=$encodedPlaceName"))
    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
    mapIntent.setPackage("com.google.android.apps.maps")
    context.startActivity(mapIntent)

}
