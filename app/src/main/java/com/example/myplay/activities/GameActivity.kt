package com.example.myplay.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.example.myplay.DataBasePlay.Entities.Play
import com.example.myplay.PlayDTO
import com.example.myplay.PlayViewModel.PlayViewModel
import com.example.myplay.PlayViewModel.ScoreViewModel
import com.example.myplay.R
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private lateinit var scoreViewModel: ScoreViewModel
    private lateinit var playViewModel: PlayViewModel
    private lateinit var playInfo: PlayDTO
    private lateinit var auxPlay: Play

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        playInfo = intent?.extras?.getParcelable("equipos")?:PlayDTO()

        playViewModel = ViewModelProviders.of(this).get(PlayViewModel::class.java)
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        teamA.setText(playInfo.equipoA)
        teamB.setText(playInfo.equipoB)

        displayScore(
            tv_score_team_a,
            playInfo.puntosEquipoA
        )

        displayScore(
            tv_score_team_b,
            playInfo.puntosEquipoB
        )
    }

    fun addOneTeamA(v: View) {
        displayScore(
            tv_score_team_a,
            ++scoreViewModel.scoreTeamA
        )
    }

    fun addOneTeamB(v: View) {
        displayScore(
            tv_score_team_b,
            ++scoreViewModel.scoreTeamB
        )
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA += 2
        displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB += 2
        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )
    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA += 3
        displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB += 3
        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )
    }

    fun saveScores(v: View) {

        auxPlay = Play(playInfo.equipoA,
                       playInfo.equipoB,
                       scoreViewModel.scoreTeamA,
                       scoreViewModel.scoreTeamB,
                       playInfo.fecha,
                       playInfo.hora)
        playViewModel.insertPlay(auxPlay)

        finish()
    }

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }
}
