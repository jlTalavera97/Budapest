package com.example.budapest.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budapest.R
import com.example.budapest.model.LugaresItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpcionesScreen(
    options: List<LugaresItem>,
    onOptionClicked: (LugaresItem) -> Unit,
    modifier: Modifier = Modifier
){
    var selectedOptionName by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_large))) {
        options.forEach{ item ->
            val onClick ={
                selectedOptionName = item.name.toString()
                onOptionClicked(item)
            }
            Card(modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.padding_medium))
                .fillMaxWidth()
                .clickable(onClick = onClick)
            ){
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(item.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(vertical = dimensionResource(R.dimen.padding_small))
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))
                    Text(
                        text = stringResource(item.name),
                        fontSize = with(LocalDensity.current){ dimensionResource(R.dimen.font_size_big).toSp()},
                        fontWeight = FontWeight.Bold

                    )
                }
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))
        }
    }
}

