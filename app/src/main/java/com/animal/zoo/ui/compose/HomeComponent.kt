package com.animal.zoo.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.animal.presentation.model.Animal
import com.animal.zoo.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HomeComponent(data: Animal, onItemClicked: (Animal) -> Unit, modifier: Modifier = Modifier) {
    val typography = MaterialTheme.typography
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 2.dp,
                top = 2.dp,
            )
            .fillMaxWidth()
            .clickable(onClick = {
                onItemClicked(data)
            }),
        elevation = 8.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = data.image_link,
                    builder = {
                        crossfade(true)
                        placeholder(R.drawable.place_holder)
                    }
                ),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = modifier
                    .size(100.dp, 100.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .weight(1f)
            ) {
                Text(text = data.name, color = MaterialTheme.colors.primaryVariant, style = typography.h6)
                Text(
                    text = data.latin_name,
                    fontStyle = FontStyle.Italic,
                    style = typography.subtitle1
                )
                Text(
                    modifier = modifier.padding(top = 5.dp),
                    text = data.diet(),
                    style = typography.subtitle2
                )
                Text(text = data.lifespan(), style = typography.subtitle2)
            }
        }
    }
}