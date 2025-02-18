package es.uma.quiziosity.data.dao

import androidx.room.*
import es.uma.quiziosity.data.entity.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>

    @Delete
    suspend fun deleteUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    suspend fun getUserByUsername(username: String): User?


    @Query("SELECT * FROM users ORDER BY score DESC LIMIT :limit OFFSET :offset")
    suspend fun getUsersByScorePaged(offset: Int, limit: Int): List<User>

    @Query("DELETE FROM users WHERE username = :username")
    suspend fun deleteUserByUsername(username: String)


}