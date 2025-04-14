package com.example.lab3_intencje

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.provider.CalendarContract.CalendarCache.URI
import android.provider.Settings
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.net.Uri
import android.provider.MediaStore
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun callIntent(intent: Intent){
        try{
            startActivity(intent)
        }
        catch (e: Exception){
            println(e.message)
        }
    }


    fun showSettings(view : View){
        val settingsIntent: Intent = Intent().apply {
            action = Settings.ACTION_DISPLAY_SETTINGS
        }

        callIntent(settingsIntent)
    }

    fun showLocation(view: View){
        val textView = findViewById<EditText>(R.id.editText)
        val location = textView.text.toString()
        val querry = "geo:0,0?q=$location"
        val geoIntent: Intent = Intent().apply{
            action = Intent.ACTION_VIEW
            data = querry.toUri()
        }

        callIntent(geoIntent)
    }

    fun takePhoto(view: View){
        val capturePhotoIntent: Intent = Intent().apply{
            action = MediaStore.ACTION_IMAGE_CAPTURE
        }

        startActivityForResult(capturePhotoIntent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as? android.graphics.Bitmap
            imageBitmap?.let {
                imageView.setImageBitmap(it)
            }
        }
    }
}