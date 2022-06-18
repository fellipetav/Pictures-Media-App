package com.example.picturesmediaapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.IntegerRes
import java.lang.Integer.parseInt
import kotlin.random.Random

class AudioActivity : AppCompatActivity() {

    lateinit var number: EditText
    lateinit var guessBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        var sound : MediaPlayer = MediaPlayer.create(this, R.raw.sound)
        number = findViewById(R.id.number)
        guessBtn = findViewById(R.id.guessBtn)
        setOnclickListenerOnGuessingButton(sound)
    }

    private fun setOnclickListenerOnGuessingButton(sound: MediaPlayer) {
        guessBtn.setOnClickListener {
            val randText = ""
            lateinit var randNum: Random
            val random: Int = randNum.nextInt(5) + 1
            val userChoice: Int = parseInt(number.text.toString().trim())
            if (userChoice < 1 || userChoice > 5) {
                showToast("Please guess a number between 1 and 5")
            } else if (userChoice == random) {
                /*If User worked out guessing the number correctly
                        Crowd Cheering sound will start*/
                if (sound.isPlaying) {
                    sound.seekTo(0)
                } else {
                    sound.start()
                }
                showToast("Congratulations, you guessed the number correctly")
            } else {
                showToast("Sorry, better luck next time!")
            }
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}