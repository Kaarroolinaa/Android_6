package com.example.android_6

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var gameView: GameView
    private lateinit var menuLayout: LinearLayout
    private lateinit var playButton: Button
    private lateinit var pauseButton: Button

    private var isPaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameView = findViewById(R.id.game_view)
        menuLayout = findViewById(R.id.menu_layout)
        playButton = findViewById(R.id.play_button)
        pauseButton = findViewById(R.id.pause_button)

        playButton.setOnClickListener {
            menuLayout.visibility = View.GONE
            pauseButton.visibility = View.VISIBLE
            gameView.resumeGame()
        }

        pauseButton.setOnClickListener {
            if (!isPaused) {
                gameView.pauseGame()
                isPaused = true
            } else {
                gameView.resumeGame()
                isPaused = false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (menuLayout.visibility == View.GONE && !isPaused) {
            gameView.resumeGame()
        }
    }

    override fun onPause() {
        super.onPause()
        gameView.pauseGame()
    }
}
