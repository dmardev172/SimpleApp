package pl.revolshen.simpleapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import pl.revolshen.simpleapp.data.models.SerialCharacter

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(serialCharacters: List<SerialCharacter>)

    @Delete
    suspend fun delete(serialCharacters: List<SerialCharacter>)

    @Update
    suspend fun update(serialCharacters: List<SerialCharacter>)

    @Query("SELECT * FROM characters_table")
    fun getAll(): Flow<List<SerialCharacter>>

    @Query("SELECT * FROM characters_table WHERE id=:id")
    fun getCharacter(id: Int): Flow<SerialCharacter>

    @Query("DELETE FROM characters_table")
    suspend fun dropDatabase()
}