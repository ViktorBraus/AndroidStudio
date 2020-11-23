package viktor.braus.kplanner.network



data class WeatherProperty(
    val main: Weather,
    val name: String
)
data class Weather(
    val temp: Float,
    val feels_like: Float
)