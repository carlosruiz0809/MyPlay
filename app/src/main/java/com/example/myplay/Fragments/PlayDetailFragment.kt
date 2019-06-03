package com.example.myplay.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myplay.PlayDTO
import com.example.myplay.R
import kotlinx.android.synthetic.main.fragment_play_detail.view.*

class PlayDetailFragment : Fragment() {

    private var play = PlayDTO()
    private lateinit var fragmentView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_play_detail, container, false)
        fragmentView = view

        bindData()

        return view
    }

    fun bindData(){

        fragmentView.equipoA.text = play.equipoA
        fragmentView.equipoB.text = play.equipoB
        fragmentView.puntos_equipoA.text = play.puntosEquipoA.toString()
        fragmentView.puntos_equipoB.text = play.puntosEquipoB.toString()
        fragmentView.fecha_play.text = play.fecha
        fragmentView.hora_play.text = play.hora

        if (play.puntosEquipoA > play.puntosEquipoB){
            fragmentView.ganador.text = "Ganador: " + play.equipoA
        }else{
            fragmentView.ganador.text = "Ganador: " + play.equipoB
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(play: PlayDTO):PlayDetailFragment{
            val newFragment = PlayDetailFragment()
            newFragment.play = play

            return newFragment
        }
    }
}
