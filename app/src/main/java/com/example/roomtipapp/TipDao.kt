package com.example.roomtipapp
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomtipapp.Tip

@Dao
interface TipDao {
    @Insert
    suspend fun insertTip(tip: Tip)

    @Query("SELECT * FROM tips")
    suspend fun getAllTips(): List<Tip>
}

