package viktor.braus.kplanner.network

import com.squareup.moshi.JsonClass
import viktor.braus.kplanner.entity.Weather

@JsonClass(generateAdapter = true)
data class NetworkWeatherContainer(
    val name : String,
    val main : Details)

/**
 * Videos represent a devbyte that can be played.
 */
@JsonClass(generateAdapter = true)
data class Details(
    val temp: Float,
    val feels_like: Float
)

/**
 * Convert Network results to database objects
 */
fun NetworkWeatherContainer.asDomainModel(): String {
   return "Місто: $name \nІнформація про стан погоди: \nТемпература повітря: ${main.temp} 'C \nВідчувається як: ${main.feels_like} 'C"
}
fun NetworkWeatherContainer.asDatabaseModel(): Weather {
    return Weather(
            name = name,
            temp = main.temp,
            feels_like = main.feels_like
            )
}
