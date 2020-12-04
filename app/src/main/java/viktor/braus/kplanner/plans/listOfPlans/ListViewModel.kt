package viktor.braus.kplanner.plans.listOfPlans

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import timber.log.Timber
import viktor.braus.kplanner.mainPage.*
import viktor.braus.kplanner.network.WeatherApi
import viktor.braus.kplanner.network.asDomainModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import viktor.braus.kplanner.entity.*
import viktor.braus.kplanner.entity.WeatherDbDao
import java.io.IOException
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class ListViewModel(application: Application,
        private val plansDAO: PlansDAO,
        private val weatherDbDao: WeatherDbDao): AndroidViewModel(application)
{
    private val database = getDatabase(application)
    private val videosRepository = WeatherRepository(database)
    companion object {
        const val cityName: String = "Chernivtsi"
        var S: Int? = null
    }
    //////////////////////////////////////////////////////////
    private val _username = MutableLiveData<String>()
    val username : LiveData<String>
        get() = _username
    init {
        _username.value = ""

    }
    val playlist = videosRepository.weather
    fun showUser():String
    {
        Timber.i("-------------------------------------")
        _username.value = "Вітаю, "+MainActivity.S
        return _username.value.toString()
    }
    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackbar : LiveData<Boolean>
        get()=_showSnackbarEvent
    fun doneShowingSnackbar()
    {
        _showSnackbarEvent.value = false
    }
    /////////////////Coroutine//////////////////////////////
    var _textTime = MutableLiveData<String>()
    val textTime: LiveData<String>
        get() = _textTime
    private var plan = MutableLiveData<Plans?>()
    val plans = plansDAO.getAllPlans()
    val MplansString = Transformations.map(plans) { nights ->
        MondayFormat(nights, application.resources)
    }
    val TplansString = Transformations.map(plans) { nights ->
        TuesdayFormat(nights, application.resources)
    }
    val WplansString = Transformations.map(plans) { nights ->
        WednesdayFormat(nights, application.resources)
    }
    val ThplansString = Transformations.map(plans) { nights ->
        ThursdayFormat(nights, application.resources)
    }
    val FplansString = Transformations.map(plans) { nights ->
        FridayFormat(nights, application.resources)
    }
    val StplansString = Transformations.map(plans) { nights ->
        SaturdayFormat(nights, application.resources)
    }
    val SplansString = Transformations.map(plans) { nights ->
        SundayFormat(nights, application.resources)
    }
    private suspend fun clear()
    {
        plansDAO.clear()
        weatherDbDao.clear()

    }
    fun onClear() {
        viewModelScope.launch {
            // Clear the database table.
            clear()
            // And clear tonight since it's no longer in the database
            plan.value = null
            _response.value = null
        }
        _showSnackbarEvent.value = true
    }
    ////////Network//////////////////////////////////////////////////
    private val _response = MutableLiveData<String>()

    fun setWeather()
    {
        viewModelScope.launch {
            videosRepository.refreshVideos()
        }
    }
    class Factory(val app: Application,val plansDAO: PlansDAO, val weatherDbDao: WeatherDbDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ListViewModel(app,plansDAO,weatherDbDao) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}