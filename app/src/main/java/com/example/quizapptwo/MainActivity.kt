package com.example.quizapptwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var questionsList = listOf(
            "How big is an elephant?",
            "Who is CEO of Tesla?",
            "Who is the girlfriend of Mikkey Mouse?"
    )

    val optionOne = listOf(
            "4",
            "Elon Musk",
            "Minnie mouse"
    )

    val optionTwo = listOf(
            "3",
            "Elton John",
            "Donald Duck"
    )

    var answersList = listOf(
            "3",
            "Elon Musk",
            "Minnie Mouse"
    )

    var currentQuestion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setNewQuestionText()

        alternative_one_button.setOnClickListener {
            if(isAnswerCorrect(optionOne)){
                setNewQuestionText()
            }
        }

        alternative_two_button.setOnClickListener {
            if(isAnswerCorrect(optionTwo)){
                setNewQuestionText()
            }
        }
    }

    private fun isAnswerCorrect(list: List<String>) : Boolean {

        if(list[currentQuestion].toLowerCase() == answersList[currentQuestion].toLowerCase()) {
            status_textView.text = "Correct!"

            if(currentQuestion < (answersList.size - 1)){
                currentQuestion++
            }

            return true
        } else {
            status_textView.text = "Wrong answer :("
            return false
        }
    }

    private fun setNewQuestionText() {
        question_textView.text = questionsList[currentQuestion]
        alternative_one_button.text = "Alternative A: ${optionOne[currentQuestion]}"
        alternative_two_button.text = "Alternative B: ${optionTwo[currentQuestion]}"
    }
}