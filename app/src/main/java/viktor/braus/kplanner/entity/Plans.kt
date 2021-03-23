package viktor.braus.kplanner.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Planner")
data class Plans(
        @PrimaryKey(autoGenerate = true)
            var EventID: Long = 0L,
        @ColumnInfo(name = "Day of Event")
        var EventDay: String = "",
        @ColumnInfo(name = "Name of Event")
            var EventName: String = "",
        @ColumnInfo(name = "Time of Event")
            var Time: String = "",
        @ColumnInfo(name = "Time Start")
            var StartTime: String = "",
        @ColumnInfo(name = "Time End")
            var EndTime: String = ""
)
@Entity(tableName = "NewWeather")
data class Weather constructor(
        @PrimaryKey(autoGenerate = true)
        var ID: Long = 0L,
        @ColumnInfo(name = "Місто")
        var name: String,
        @ColumnInfo(name = "Температура")
        var temp: Float,
        @ColumnInfo(name = "Відчувається як")
        var feels_like: Float
)
fun List<Weather>.asDomainModel(): List<String> {
    return map {
        "Місто: " + it.name + "\nТемпература повітря: " + it.temp.toString() + "'C \nВідчуваєтсья як: " + it.feels_like.toString() + "'C"
    }
}