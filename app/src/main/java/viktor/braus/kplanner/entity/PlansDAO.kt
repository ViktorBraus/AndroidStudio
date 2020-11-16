package viktor.braus.kplanner.entity

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PlansDAO {

    @Insert
    fun insert(plans: Plans)

    @Update
    fun update(plans: Plans)


    @Query("SELECT * from Planner WHERE EventID = :key")
     fun get(key: Long): Plans?

    @Query("DELETE FROM Planner")
     fun clear()

    @Query("SELECT * FROM Planner ORDER BY EventID DESC")
   fun getAllPlans(): LiveData<List<Plans>>

    @Query("SELECT * FROM Planner ORDER BY EventID DESC LIMIT 1")
     fun getAll(): Plans?
}