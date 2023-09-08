package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener { view: View ->
            checkAnswer(true)

        }
        binding.falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) %questionBank.size
            updateQuestion()
        }
        binding.prevButton.setOnClickListener {
            currentIndex = (currentIndex - 1) %questionBank.size
            updateQuestion()
        }

        updateQuestion()

    }
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }


    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }
}
