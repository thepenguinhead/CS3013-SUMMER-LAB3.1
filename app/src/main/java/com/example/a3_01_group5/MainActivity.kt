package com.example.a3_01_group5

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var questionText: TextView
    private lateinit var answerFeedback: TextView
    private val questions = listOf(
        R.string.largest_planet,
        R.string.most_moons,
        R.string.side_spinning
    )
    private val correctAnswers = listOf(
        R.string.jupiter,
        R.string.saturn,
        R.string.uranus
    )
    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionText = findViewById(R.id.question_text)
        answerFeedback = findViewById(R.id.answer_feedback)

        updateQuestion()

        val planets = listOf(
            findViewById<Button>(R.id.mercury),
            findViewById<Button>(R.id.venus),
            findViewById<Button>(R.id.earth),
            findViewById<Button>(R.id.mars),
            findViewById<Button>(R.id.jupiter),
            findViewById<Button>(R.id.saturn),
            findViewById<Button>(R.id.uranus),
            findViewById<Button>(R.id.neptune)
        )

        for (planet in planets) {
            planet.setOnClickListener {
                checkAnswer(planet.text.toString())
            }
        }
    }

    private fun updateQuestion() {
        questionText.setText(questions[currentQuestionIndex])
        answerFeedback.visibility = View.GONE
    }

    private fun checkAnswer(answer: String) {
        val correctAnswer = getString(correctAnswers[currentQuestionIndex])
        if (answer.equals(correctAnswer, ignoreCase = true)) {
            answerFeedback.text = getString(R.string.correct)
            currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
            updateQuestion()
        } else {
            answerFeedback.text = getString(R.string.wrong)
        }
        answerFeedback.visibility = View.VISIBLE
    }
}
