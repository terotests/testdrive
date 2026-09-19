package com.example.helloworld

// Written once by ranger-starter, and yours now: nothing regenerates it.
//
// `Shared` is compiled from the shared module into
// `src/main/generated/` by `npm run android:compile`, which `android:build`
// runs first. Do not edit the generated file, and do not commit it.

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { AppScreen() } }
    }
}

@Composable
fun AppScreen() {
    // The one line that crosses the seam: everything above is the host, and
    // everything the greeting knows is Ranger.
    val model = Shared()
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = model.greeting(), style = MaterialTheme.typography.headlineSmall)
        }
    }
}
