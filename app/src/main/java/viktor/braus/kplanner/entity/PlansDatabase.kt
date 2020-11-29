package viktor.braus.kplanner.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Plans::class,Weather::class], version = 4)
abstract class NewPlansDatabase : RoomDatabase() {
    abstract val plansDAO: PlansDAO
    abstract val weatherDetailsDAO: WeatherDbDao
}
private lateinit var INSTANCE: NewPlansDatabase
fun getDatabase(context: Context):NewPlansDatabase
{
    synchronized(NewPlansDatabase::class.java)
    {
                  if(!::INSTANCE.isInitialized)
                  {
                      INSTANCE = Room.databaseBuilder(
                          context.applicationContext,
                          NewPlansDatabase::class.java,
                          "Plans"
                      ).fallbackToDestructiveMigration()
                          .build()
                  }
              }
    return INSTANCE
}