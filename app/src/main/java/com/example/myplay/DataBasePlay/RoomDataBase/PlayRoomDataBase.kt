package com.example.myplay.DataBasePlay.RoomDataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myplay.DataBasePlay.DAO.PlayDAO
import com.example.myplay.DataBasePlay.Entities.Play
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = arrayOf(Play::class),version = 1,exportSchema = false)
public abstract class PlayRoomDataBase:RoomDatabase() {

    abstract fun playDAO(): PlayDAO

    companion object{

        @Volatile
        private var INSTANCE: PlayRoomDataBase? = null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ):PlayRoomDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context,PlayRoomDataBase::class.java,"PlayDB")
                    .addCallback(PlayDBCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        private class PlayDBCallback(private val scope: CoroutineScope): RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase){
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDBPlay(database.playDAO())
                    }
                }
            }
        }

        suspend fun populateDBPlay(playDAO: PlayDAO){
            //playDAO.deleteAllPlay()
        }


    }
}