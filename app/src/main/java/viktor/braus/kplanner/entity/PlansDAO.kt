package viktor.braus.kplanner.entity

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

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

    @Query("SELECT * FROM Planner ORDER BY EventID DESC LIMIT 1")
    suspend fun getAll(): Plans?
}