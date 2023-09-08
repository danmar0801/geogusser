package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    private val questionBank = listOf(
        Question(R.string.question_earth, true),
        Question(R.string.question_mars, true),
        Question(R.string.question_jupiter, false),
        Question(R.string.question_pluto, false),
        Question(R.string.question_uranus, false),
        Question(R.string.question_venus, false)
    )
    private var currentIndex = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener { view: View ->
            Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT
            ).show()

        }
        falseButton.setOnClickListener { view: View->
            Toast.makeText(
                this,  
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
