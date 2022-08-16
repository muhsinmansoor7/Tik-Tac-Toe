package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View) {
        val buttonSelected = view as Button
        var cellId = 0
        when (buttonSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }
//        Log.d("buttonClick",buttonSelected.id.toString())
//        Log.d("buttonClick: cellId:" , cellId.toString())
        playGame(cellId, buttonSelected)
    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()


    fun playGame(cellId: Int, buttonSelected: Button) {

        if (activePlayer == 1) {
            buttonSelected.text = "X"
            buttonSelected.setBackgroundResource(R.color.myDarkGreen)
            player1.add(cellId)
            activePlayer = 2
        } else {
            buttonSelected.text = "O"
            buttonSelected.setBackgroundResource(R.color.myRed)
            player2.add(cellId)
            activePlayer = 1
        }
        buttonSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1;
        // for row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        // for row2
        else if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // for row3
        else if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        // for col1
        else if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        // for col2
        else if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        } else if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        // for col3
        else if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        // for dia1
        else if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        // for dia2
        else if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        } else if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner == 1) {
            Toast.makeText(this, "Player one has won the game.", Toast.LENGTH_LONG).show()
        } else if (winner == 2) {
            Toast.makeText(this, "Player two has won the game.", Toast.LENGTH_LONG).show()
        }

    }
}