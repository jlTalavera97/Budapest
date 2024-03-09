package com.example.budapest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.budapest.R
import com.example.budapest.model.LugaresItem

@Composable
fun DetallesScreen(
    lugar: LugaresItem,
    onSearchPlaceClicked: () -> Unit,
    onHomeButtonClicked: () -> Unit,
    modifier: Modifier
){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                dimensionResource(R.dimen.padding_medium)
            ),
            shape = RoundedCornerShape(dimensionResource(R.dimen.padding_small))

        ) {
            Image(
                painter = painterResource(lugar.image),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Card(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                dimensionResource(R.dimen.padding_small)
            ),
            shape = RoundedCornerShape(dimensionResource(R.dimen.padding_small))

        ){
            Text(
                text = lugar.description,
                fontWeight = FontWeight.Normal,
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Row(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(
                    MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(
                        dimensionResource(R.dimen.padding_medium)
                    )
                )
                .clickable(onClick =  onSearchPlaceClicked)
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_very_small))
                )
                Text(
                    text = lugar.ubication,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_very_small))
                )
            }
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))
        Button(
            onClick =  onHomeButtonClicked
        ) {
            Text(text = stringResource(R.string.inicio))
        }


    }

}