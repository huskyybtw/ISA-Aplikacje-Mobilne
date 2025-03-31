package com.example.lab2_kalkulatornapiwkow

import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calculate (view: View){
        val priceField = findViewById<TextInputEditText>(R.id.PriceFIeld)
        val tipField = findViewById<TextInputEditText>(R.id.TIpFIeld)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        var price: Float = 0.0f
        var tip : Float = 1.0f
        var rating : Float = 1.0f
        var error = Toast.makeText(this, null, Toast.LENGTH_LONG)
        try{
            price = priceField.text.toString().toFloat()
            tip = tipField.text.toString().toFloat() / 100
            rating = ratingBar.rating
        }
        catch (e: Exception){
           error.setText(e.message)
            error.show()
            tip = 1.0f
        }

        var totalTip = (price * tip) + rating * 5
        var totalTipString = "Napiwek wyszedl" + totalTip.toString() + "zl"
        val resultToast = Toast.makeText(this, totalTipString, Toast.LENGTH_LONG)
        resultToast.show()
    }

    fun toggleComment (view: View){
        val switch = findViewById<Switch>(R.id.switchComment)
        val commentSection = findViewById<TextInputLayout>(R.id.CommentLayout)
        if(switch.isChecked){
            commentSection.visibility = View.VISIBLE
        }
        else{
            commentSection.visibility = View.GONE
        }
    }
}