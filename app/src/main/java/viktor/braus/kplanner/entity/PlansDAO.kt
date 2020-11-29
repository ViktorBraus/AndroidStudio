package viktor.braus.kplanner.entity

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlansDAO {
    @Insert
    suspend fun insert(plans: Plans)
    @Update
    suspend fun update(plans: Plans)
    @Query("SELECT * from Planner WHERE EventID = :key")
     suspend fun get(key: Long): Plans?
    @Query("DELETE FROM Planner")
     suspend fun clear()
    @Query("SELECT * FROM Planner ORDER BY EventID DESC")
   fun getAllPlans(): LiveData<List<Plans>>
    @Query("SELECT * FROM Planner Where `Day of Event` = 'Понеділок' ")
    fun getMondayPlans(): LiveData<List<Plans>>
    @Query("SELECT * FROM Planner ORDER BY EventID DESC LIMIT 1")
    suspend fun getAll(): Plans?
}
@Dao
interface WeatherDbDao {
    @Query("select * from newweather ORDER BY ID DESC LIMIT 1")
    fun getVideos(): LiveData<List<Weather>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(videos: Weather)
    @Query("DELETE FROM newweather")
    suspend fun clear()
}
