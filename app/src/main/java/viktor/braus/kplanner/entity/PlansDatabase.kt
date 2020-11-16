package viktor.braus.kplanner.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Plans::class], version = 3,exportSchema = false)
abstract class PlansDatabase : RoomDatabase()
{
    abstract val plansDAO: PlansDAO
    //abstract val mondayPlanDAO: MondayPlanDAO
    companion object{
        @Volatile
        private var INSTANCE: PlansDatabase? = null

        fun getInstance(context: Context):PlansDatabase{
              synchronized(this){
                  var instance = INSTANCE
                  if(instance==null)
                  {
                      instance = Room.databaseBuilder(
                          context.applicationContext,
                          PlansDatabase::class.java,
                          "All Plans"
                      ) .fallbackToDestructiveMigration()
                          .build()
                      INSTANCE = instance
                  }
                  return instance
              }
        }
    }
}