package viktor.braus.kplanner.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Monday")
data class MondayPlan(
    @PrimaryKey(autoGenerate = true)
    var EventID: Long = 0L,
    @ColumnInfo(name = "Name of Event")
    val EventName: String = "",
    @ColumnInfo(name = "Time of Event")
    var Time: String = "",
    @ColumnInfo(name = "Time Start")
    var StartTime: String = "",
    @ColumnInfo(name = "Time End")
    var EndTime: String = ""
)