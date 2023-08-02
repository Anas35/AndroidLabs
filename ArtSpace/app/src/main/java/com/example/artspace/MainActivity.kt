package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var index by remember { mutableStateOf(0) }
    val images = listOf(R.drawable.art, R.drawable.art_, R.drawable.art_2)
    val descriptions = listOf(R.string.art1, R.string.art2, R.string.art3)
    val testTag = listOf("Index-0", "Index-1", "Index-2")

    Column (
        modifier = modifier.testTag(testTag[index]),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Frame(
            image = images[index],
            description = descriptions[index],
        )
        Spacer(modifier.height(20.dp))
        Texture(
            text = descriptions[index],
        )
        Spacer(modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp).align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                          index = when(index) {
                              0 -> 2
                              1 -> 0
                              else -> 1
                          }
                },
                content = {
                    Text(stringResource(R.string.previous))
                },
                modifier = Modifier.width(150.dp).height(50.dp)
            )
            Button(
                onClick = {
                    index = when(index) {
                        0 -> 1
                        1 -> 2
                        else -> 0
                    }
                },
                content = {
                    Text(stringResource(R.string.next))
                },
                modifier = Modifier.width(150.dp).height(50.dp)
            )
        }
    }
}

@Composable
fun Frame(
    @DrawableRes image: Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier.padding(24.dp),
        shape = ShapeDefaults.Small,
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(50.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = stringResource(description),
            modifier = Modifier.padding(32.dp)
        )
    }
}

@Composable
fun Texture(
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(text),
        modifier = modifier
            .padding(16.dp)
            .background(Color.LightGray)
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}