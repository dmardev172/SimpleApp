package pl.revolshen.simpleapp.data.local
/*
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//if schema changed - type: version = 2 and uncomment fall...
@Database(entities = [Character::class], version = 1)
abstract class HeroDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao
}

object HeroDb {
    private var db: HeroDatabase? = null

    fun getInstance(context: Context): HeroDatabase {
        if (db == null) {
            db = Room.databaseBuilder(
                context,
                HeroDatabase::class.java,
                "character_database"
            )
//                .fallbackToDestructiveMigration()
                .build()
        }
        return db!!
    }
}

 */