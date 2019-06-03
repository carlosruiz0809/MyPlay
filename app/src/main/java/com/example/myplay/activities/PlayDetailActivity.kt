package com.example.myplay.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myplay.Fragments.PlayDetailFragment
import com.example.myplay.PlayDTO
import com.example.myplay.R

class PlayDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_detail)

        var playInfo: PlayDTO = intent?.extras?.getParcelable("play")?:PlayDTO()

        initActivity(playInfo)
    }

    fun initActivity(play:PlayDTO){
        var fragment = PlayDetailFragment.newInstance(play)
        changeFragment(R.id.content,fragment)
    }

    private fun changeFragment(id: Int, frag: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(id, frag)
            .commit()
    }
}
