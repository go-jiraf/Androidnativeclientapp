package com.gojiraf.androidnativeclientapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gojiraf.androidnativeclientapp.ui.theme.AndroidnativeclientappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidnativeclientappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(16.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        OpenTwaButton()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(onClick = {
        openCustomTab(context, "https://videocommerce-staging.gojiraf.ai/company/liverpool")
    }, modifier = modifier) {
        Text(text = "Open Custom Tab")
    }
}

@Composable
fun OpenTwaButton(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, TwaActivity::class.java))
    }, modifier = modifier) {
        Text(text = "Open TWA")
    }
}

fun openCustomTab(context: Context, url: String) {
    // Create a CustomTabColorSchemeParams to set the toolbar color
    val colorSchemeParams = CustomTabColorSchemeParams.Builder()
        .setToolbarColor(Color.BLACK) // Set the toolbar color to black
        .build()

    // Build the CustomTabsIntent with the color scheme
    val customTabsIntent = CustomTabsIntent.Builder()
        .setDefaultColorSchemeParams(colorSchemeParams)
        .build()

    // Launch the Custom Tab
    customTabsIntent.launchUrl(context, Uri.parse(url))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidnativeclientappTheme {
        Greeting("Android")
    }
}
