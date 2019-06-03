package com.example.myplay.PlayViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myplay.DataBasePlay.Entities.Play
import com.example.myplay.DataBasePlay.Repository.PlayRepository
import com.example.myplay.DataBasePlay.RoomDataBase.PlayRoomDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayViewModel(app:Application):AndroidViewModel(app) {

    private var repository: PlayRepository? = null

    init {
        addPlay()
    }

    fun addPlay(){
        val playDAO = PlayRoomDataBase.getInstance(getApplication(),viewModelScope).playDAO()
        repository = PlayRepository(playDAO)
    }

    //insert
    fun insertPlay(play: Play) = viewModelScope.launch(Dispatchers.IO) {
        repository!!.insertPlay(play)
    }

    //getAll
    fun getAllPlay(): LiveData<List<Play>> = repository!!.getAllPlay()

}