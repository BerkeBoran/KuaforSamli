package com.example.kuaforsamli

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen(
                onTimeout = {
                    // 3 saniye sonra MainActivity'ye geç
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            )
        }

}
}
@Composable
fun SplashScreen(onTimeout: () -> Unit){
    LaunchedEffect(true) {
        delay(3000)
        onTimeout()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
            Image(
                painter = painterResource(id = R.drawable.bg_splash),
                contentDescription = "Logo",
                modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop


            )
            Text(
                text = "Şamlı Kuafor",
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic ,
                fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary,

            )

    }



}