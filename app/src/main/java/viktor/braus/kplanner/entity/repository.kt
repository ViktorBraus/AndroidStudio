package viktor.braus.kplanner.entity

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import viktor.braus.kplanner.network.WeatherApi
import viktor.braus.kplanner.network.asDatabaseModel

class WeatherRepository(private val database: NewPlansDatabase) {
    val weather: LiveData<List<String>> =
        Transformations.map(database.weatherDetailsDAO.getVideos()) {
            it.asDomainModel()
        }
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = WeatherApi.devbytes.getProperties().await()
            database.weatherDetailsDAO.insertAll(playlist.asDatabaseModel())
        }
    }
}