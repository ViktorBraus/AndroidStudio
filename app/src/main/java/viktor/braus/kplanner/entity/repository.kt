package viktor.braus.kplanner.entity

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import viktor.braus.kplanner.network.WeatherApi
import viktor.braus.kplanner.network.asDatabaseModel

class WeatherRepository(private val database: NewPlansDatabase) {
    /**
     * A playlist of videos that can be shown on the screen.
     */
    val weather: LiveData<List<String>> =
        Transformations.map(database.weatherDetailsDAO.getVideos()) {
            it.asDomainModel()
        }
    /**
     * Refresh the videos stored in the offline cache.
     *
     * This function uses the IO dispatcher to ensure the database insert database operation
     * happens on the IO dispatcher. By switching to the IO dispatcher using `withContext` this
     * function is now safe to call from any thread including the Main thread.
     *
     * To actually load the videos for use, observe [videos]
     */
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = WeatherApi.devbytes.getProperties().await()
            database.weatherDetailsDAO.insertAll(playlist.asDatabaseModel())
        }
    }
}