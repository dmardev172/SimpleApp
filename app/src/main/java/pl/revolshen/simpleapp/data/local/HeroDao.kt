package pl.revolshen.simpleapp.data.local
/*
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import pl.revolshen.simpleapp.data.models.Hero
//import pl.revolshen.simpleapp.domain.models.Hero

@Dao
interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(serialHeroes: List<Hero>)

    @Delete
    suspend fun delete(serialHeroes: List<Hero>)

    @Update
    suspend fun update(serialHeroes: List<Hero>)

    @Query("SELECT * FROM characters_table")
    fun getAll(): Flow<List<Hero>>

    @Query("SELECT * FROM characters_table WHERE id=:id")
    fun getHero(id: Int): Flow<Hero>

    @Query("DELETE FROM characters_table")
    suspend fun dropDatabase()
}

 */