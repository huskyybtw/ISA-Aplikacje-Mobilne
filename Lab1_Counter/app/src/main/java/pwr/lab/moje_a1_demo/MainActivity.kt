package pwr.lab.moje_a1_demo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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


    //
    var state = 0;
    fun gatherNumbers(view: View){
        findViewById<TextView>(R.id.textView2).text = "kliknieto"
    }

    fun Left(view: View){
        findViewById<Button>(R.id.buttonRight).visibility = View.VISIBLE
        findViewById<Button>(R.id.buttonLeft).visibility = View.INVISIBLE
        state++
        findViewById<TextView>(R.id.textViewCounter).text = state.toString()
    }

    fun Right(view: View){
        findViewById<Button>(R.id.buttonLeft).visibility = View.VISIBLE
        findViewById<Button>(R.id.buttonRight).visibility = View.INVISIBLE
        state++
        findViewById<TextView>(R.id.textViewCounter).text = state.toString()
    }


}