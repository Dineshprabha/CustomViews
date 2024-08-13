package com.dinesh.customviews

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var customImageView: CustomImageView? = null
    private var et: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        customImageView = findViewById(R.id.custom_image_view)
        et = findViewById(R.id.et)

        customImageView?.setCustomImageData(null, Color.BLACK, "Dinesh")

        customImageView?.getRootViewClick()?.setOnClickListener {
            // pick image from gallery if required and call the function again to set data
        }

        et?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                customImageView?.setCustomImageData(null, Color.BLACK, s.toString())
            }
        })

    }
}