package pl.revolshen.simpleapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.revolshen.simpleapp.data.models.SerialCharacter

//if schema changed - type: version = 2 and uncomment fall...
@Database(entities = [SerialCharacter::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}

object CharacterDb {
    private var db: CharacterDatabase? = null

    fun getInstance(context: Context): CharacterDatabase {
        if (db == null) {
            db = Room.databaseBuilder(
                context,
                CharacterDatabase::class.java,
                "character_database"
            )
//                .fallbackToDestructiveMigration()
                .build()
        }
        return db!!
    }
}