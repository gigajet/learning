package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import com.example.diceroll.databinding.ActivityMainBinding

const val KEY_RESULT = "result_key"

class MainActivity : AppCompatActivity() {
    private var lastRollResult: Int = 1
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lastRollResult = Dice(6).roll()
        displayRollResult(binding.imageView, lastRollResult)
        binding.button.setOnClickListener {
            lastRollResult = Dice(6).roll()
            displayRollResult(binding.imageView, lastRollResult)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_RESULT, lastRollResult)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        lastRollResult = savedInstanceState.getInt(KEY_RESULT, 1)
        displayRollResult(binding.imageView, lastRollResult)
    }

    fun displayRollResult(diceImageView: ImageView, rollResult: Int) {
        val drawableResult = when (rollResult) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImageView.setImageResource(drawableResult)
        diceImageView.contentDescription = rollResult.toString()
    }
}

class Dice(val sides: Int) {
    fun roll(): Int = (1..sides).random()
}
