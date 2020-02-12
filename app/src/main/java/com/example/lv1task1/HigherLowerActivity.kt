package com.example.lv1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)

        higherBtn.setOnClickListener {
            onHigherClick()
        }

        equalBtn.setOnClickListener{
            onEqualClick()
        }

        lowerBtn.setOnClickListener {
            onLowerClick()
        }

    }

    fun updateUI()
    {
        //how do I get the current image from an imageView?!?!
        //Can I add a variable to a resource path?
        ///lastThrowImg.setImageResource(currentThrowImg.id)//NOPE


        //doing it dirty until I find a way
        when(lastThrow) {
            1 -> lastThrowImg.setImageResource(R.drawable.dice1)
            2 -> lastThrowImg.setImageResource(R.drawable.dice2)
            3 -> lastThrowImg.setImageResource(R.drawable.dice3)
            4 -> lastThrowImg.setImageResource(R.drawable.dice4)
            5 -> lastThrowImg.setImageResource(R.drawable.dice5)
            6 -> lastThrowImg.setImageResource(R.drawable.dice6)
            else -> println("Number mismatch")
        }

        when(currentThrow) {
            1 -> currentThrowImg.setImageResource(R.drawable.dice1)
            2 -> currentThrowImg.setImageResource(R.drawable.dice2)
            3 -> currentThrowImg.setImageResource(R.drawable.dice3)
            4 -> currentThrowImg.setImageResource(R.drawable.dice4)
            5 -> currentThrowImg.setImageResource(R.drawable.dice5)
            6 -> currentThrowImg.setImageResource(R.drawable.dice6)
            else -> println("Number mismatch")
        }
    }

    private fun rollDie() {//rollDie, because -dice- is plural damnit
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick()
    {
        //Implement this function yourself!
        rollDie()
        if(currentThrow > lastThrow){
            onAnswerCorrect()
        }
        else{
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick()
    {
        rollDie()
        if(currentThrow < lastThrow){
            onAnswerCorrect()
        }
        else{
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick()
    {
        rollDie()
        if(currentThrow == lastThrow){
            onAnswerCorrect()
        }
        else{
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect()
    {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    private fun onAnswerIncorrect()
    {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }





}
