package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{ rollDice() }

        // Do a dice roll when the app starts
        rollDice()

    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice01 = Dice(6)
        val dice02 = Dice(6)

        val diceRoll01 = dice01.roll()
        val diceRoll02 = dice02.roll()

        // Find the ImageView in the layout
       val diceImage01: ImageView = findViewById(R.id.imageView)
        val diceImage02: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource id to use based on the dice roll
        val drawableResource01 = when (diceRoll01) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource02 = when (diceRoll02) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage01.setImageResource(drawableResource01)
        diceImage02.setImageResource(drawableResource02)

        // Update the content description
        diceImage01.contentDescription = diceRoll01.toString()
        diceImage02.contentDescription = diceRoll02.toString()

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}