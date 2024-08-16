package com.gojiraf.androidnativeclientapp

import android.net.Uri
import android.util.Log
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsServiceConnection
import androidx.browser.customtabs.CustomTabsSession
import androidx.browser.customtabs.TrustedWebUtils
import android.content.ComponentName

class TwaActivity : AppCompatActivity() {

    private var customTabsSession: CustomTabsSession? = null
    private var customTabsClient: CustomTabsClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val connection = object : CustomTabsServiceConnection() {
            override fun onCustomTabsServiceConnected(name: ComponentName, client: CustomTabsClient) {
                Log.d("TWA", "Custom Tabs Service Connected")
                customTabsClient = client
                customTabsClient?.warmup(0L)
                customTabsSession = customTabsClient?.newSession(null)
                if (customTabsSession == null) {
                    Log.e("TWA", "Failed to create Custom Tabs Session")
                } else {
                    launchTwa()
                }
            }

            override fun onServiceDisconnected(name: ComponentName) {
                Log.e("TWA", "Custom Tabs Service Disconnected")
                customTabsClient = null
            }
        }

        // Conectar con el servicio de Custom Tabs
        val bound = CustomTabsClient.bindCustomTabsService(this, "com.android.chrome", connection)
        if (!bound) {
            Log.e("TWA", "Failed to bind to Custom Tabs Service")
        }
    }

    private fun launchTwa() {
        val url = Uri.parse("https://videocommerce-staging.gojiraf.ai/company/liverpool")
        //val url = Uri.parse("https://videocommerce.gojiraf.ai/company/liverpool")

        // Asegurarse de que la sesión no sea nula antes de continuar
        val session = customTabsSession
        if (session == null) {
            Log.e("TWA", "Session is null. Cannot launch TWA.")
            return
        }

        // Construir el CustomTabsIntent con la sesión activa
        val customTabsIntent = CustomTabsIntent.Builder(session).build()

        // Lanzar el Trusted Web Activity
        try {
            TrustedWebUtils.launchAsTrustedWebActivity(this, customTabsIntent, url)
        } catch (e: Exception) {
            Log.e("TWA", "Error launching TWA: ${e.message}")
        }

        finish()
    }
}
