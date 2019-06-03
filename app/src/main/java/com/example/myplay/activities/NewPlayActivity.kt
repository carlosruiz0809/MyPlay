package com.example.myplay.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myplay.PlayDTO
import com.example.myplay.R
import kotlinx.android.synthetic.main.activity_new_play.*

class NewPlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_play)

        init()
    }

    fun init(){

        var equiposBundle = Bundle()
        var equipos: PlayDTO
        btn_iniciar.setOnClickListener {
            equipos = PlayDTO(name_equipoA.text.toString(),
                              name_equipoB.text.toString(),
                             0,
                             0,
                              fecha_game.text.toString(),
                              hora_game.text.toString())
            equiposBundle.putParcelable("equipos",equipos)
            startActivity(Intent(this, GameActivity::class.java).putExtras(equiposBundle))

            finish()
        }
    }
}
