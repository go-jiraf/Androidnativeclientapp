package com.gojiraf.androidnativeclientapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.gojiraf.androidnativeclientapp.ui.theme.AndroidnativeclientappTheme
import androidx.core.content.ContextCompat
import android.graphics.BitmapFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidnativeclientappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(onClick = {
        openCustomTab(context, "https://video-commerce.vercel.app/company/just?category=belleza")
    }, modifier = modifier) {
        Text(text = "Open Custom Tab")
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


/*fun openCustomTab(context: Context, url: String) {
    val builder = CustomTabsIntent.Builder()
    builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
    builder.addDefaultShareMenuItem()
    builder.setShowTitle(true)
    val customTabsIntent = builder.build()
    val packageName = "com.android.chrome"
    customTabsIntent.intent.setPackage(packageName)
    customTabsIntent.launchUrl(context, Uri.parse(url))
}*/

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidnativeclientappTheme {
        Greeting("Android")
    }
}



/*
package com.gojiraf.androidnativeclientapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gojiraf.androidnativeclientapp.ui.theme.AndroidnativeclientappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidnativeclientappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidnativeclientappTheme {
        Greeting("Android")
    }
}*/
