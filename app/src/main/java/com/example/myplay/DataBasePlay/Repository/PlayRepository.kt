package com.example.myplay.DataBasePlay.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.myplay.DataBasePlay.DAO.PlayDAO
import com.example.myplay.DataBasePlay.Entities.Play

class PlayRepository(private val playDAO: PlayDAO) {

    //get play
    fun getAllPlay(): LiveData<List<Play>> = playDAO.getAllPlay()

    //insert play
    @WorkerThread
    suspend fun insertPlay(play:Play) = playDAO.insertPlay(play)
}