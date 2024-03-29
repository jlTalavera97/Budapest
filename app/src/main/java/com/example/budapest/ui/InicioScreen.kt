package com.example.budapest.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.budapest.R


@Composable
fun InicioScreen(
    onStartExploringButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(modifier = Modifier
        .fillMaxHeight()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(contentAlignment = Alignment.BottomCenter){
                    Image(
                        painter = painterResource(R.drawable.descubre_budapest),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .alpha(0.70f)
                            .height(785.dp)

                    )
                    Button(
                        onClick = onStartExploringButtonClicked,
                        modifier = Modifier
                            .padding(bottom = dimensionResource(R.dimen.padding_extra_large)),


                    ) {
                        Text(stringResource(R.string.descubre))
                    }
                }
            }
        }
    
    }
}

@Preview
@Composable
fun InicioScreenPreview(){
    InicioScreen(onStartExploringButtonClicked = { })
}