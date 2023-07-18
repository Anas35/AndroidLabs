package com.anas.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anas.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(R.color.back_ground),
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box {
        TitleCard(Modifier.align(Alignment.Center))
        DetailCard(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun TitleCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp, 120.dp)
                .background(Color.DarkGray)
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(R.string.dev),
            color = colorResource(R.color.green),
            fontSize = 20.sp,
        )
    }
}

@Composable
fun DetailCard(modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp)) {
        CardTemplate(text = R.string.number, icon = Icons.Rounded.Call, iconDescription = R.string.call_icon)
        CardTemplate(text = R.string.tag, icon = Icons.Rounded.Call, iconDescription = R.string.share_icon)
        CardTemplate(text = R.string.mail, icon = Icons.Rounded.Call, iconDescription = R.string.mail_icon)
    }
}

@Composable
fun CardTemplate(text: Int, icon: ImageVector, iconDescription: Int, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = 8.dp)
    ) {
       Icon(
           imageVector = icon,
           contentDescription = stringResource(iconDescription),
           tint = colorResource(R.color.green),
       )
        Box(Modifier.width(20.dp))
        Text(stringResource(text))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}