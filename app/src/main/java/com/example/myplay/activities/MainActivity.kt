package com.example.myplay.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myplay.DataBasePlay.Entities.Play
import com.example.myplay.PlayAdapter.PlayAdapter
import com.example.myplay.PlayDTO
import com.example.myplay.PlayViewModel.PlayViewModel
import com.example.myplay.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var playViewModel: PlayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playViewModel = ViewModelProviders.of(this).get(PlayViewModel::class.java)

        val play: LiveData<List<Play>> = playViewModel.getAllPlay()

        val playObserver = Observer<List<Play>>{ lista ->
            if(lista.size > 0){
                setUpView(getDTOList(lista))
            }else{
                Log.d("prueba","no hay tags")
            }
        }

        play.observe(this,playObserver)

        fab.setOnClickListener { view ->
            val intent = Intent(this@MainActivity, NewPlayActivity::class.java)
            startActivityForResult(intent, newPlayActivityRequestCode)
        }
    }

    fun getDTOList(partidos: List<Play>): ArrayList<PlayDTO>{
        val playDTOList = ArrayList<PlayDTO>()

        for(i in partidos){
            playDTOList.add(PlayDTO(i.EquipoA,i.EquipoB,i.PuntosEquipoA,i.PuntosEquipoB,i.Fecha,i.Hora))
        }

        return playDTOList
    }

    fun setUpView(play: ArrayList<PlayDTO>){

        var viewManager = LinearLayoutManager(this)

        lateinit var viewAdapter: PlayAdapter

        viewAdapter = PlayAdapter(this,{ playItem: PlayDTO -> itemClickedPortrait(playItem)})

        viewAdapter.setPlay(play)

        play_rv.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    fun itemClickedPortrait(play: PlayDTO){

        val playBundle = Bundle()
        playBundle.putParcelable("play",play)

        startActivity(Intent(this, PlayDetailActivity::class.java).putExtras(playBundle))
    }

    companion object {
        const val newPlayActivityRequestCode = 1
    }
}
