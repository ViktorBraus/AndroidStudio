package viktor.braus.kplanner.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface WeatherApiService {
    @GET("weather?q=Chernivtsi&APPID=4fea738c01cb1842489b3cb8527d3cee&units=metric&lang=ru")
    fun getProperties(): Deferred<NetworkWeatherContainer>
}
object WeatherApi {
    val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    val devbytes = retrofit.create(WeatherApiService::class.java)
}