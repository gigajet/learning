package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        val imageView1: ImageView = findViewById(R.id.imageView)
        val imageView2: ImageView = findViewById(R.id.imageView2)
        rollDice(imageView1)
        rollDice(imageView2)
        rollButton.setOnClickListener {
            rollDice(imageView1)
            rollDice(imageView2)
        }
    }

    fun rollDice(diceImageView: ImageView) {
        val roll_result = Dice(6).roll()
        val drawableResult = when (roll_result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImageView.setImageResource(drawableResult)
        diceImageView.contentDescription = roll_result.toString()
    }
}

class Dice(val sides: Int) {
    fun roll(): Int = (1..sides).random()
}
