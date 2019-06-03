package com.example.myplay.DataBasePlay.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myplay.DataBasePlay.Entities.Play

@Dao
interface PlayDAO {

    @Query("SELECT * FROM Play order by Id_Play ASC")
    fun getAllPlay(): LiveData<List<Play>>

    @Insert
    suspend fun insertPlay(play:Play)

    @Query("DELETE FROM Play")
    fun deleteAllPlay()
}