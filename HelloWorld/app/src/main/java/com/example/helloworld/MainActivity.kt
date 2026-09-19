package com.example.helloworld

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = "Hello World"
        Log.i(TAG, message)

        val textView = TextView(this).apply {
            text = message
            textSize = 32f
            setPadding(48, 48, 48, 48)
        }
        setContentView(textView)
    }

    companion object {
        private const val TAG = "HelloWorld"
    }
}
