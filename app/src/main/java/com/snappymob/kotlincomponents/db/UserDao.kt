package com.snappymob.kotlincomponents.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.snappymob.kotlincomponents.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM user WHERE login = :arg0")
    fun findByLogin(login: String): LiveData<User>
}