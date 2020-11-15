package viktor.braus.kplanner.entity

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MondayPlanDAO {

    @Insert
    suspend fun insert(plans: MondayPlan)

    @Update
    suspend fun update(plans: MondayPlan)


    @Query("SELECT * from Monday WHERE EventID = :key")
    suspend fun get(key: Long): MondayPlan?

    @Query("DELETE FROM Monday")
   suspend fun clear()

    @Query("SELECT * FROM Monday"+"ORDER BY EventID DESC")
    fun getAllPlans(): LiveData<List<MondayPlan>>

    @Query("SELECT * FROM Monday ORDER BY EventID DESC LIMIT 1")
   suspend fun getAll(): MondayPlan?
}