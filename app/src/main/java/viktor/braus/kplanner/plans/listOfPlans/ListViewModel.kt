package viktor.braus.kplanner.plans.listOfPlans

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import timber.log.Timber
import viktor.braus.kplanner.entity.Plans
import viktor.braus.kplanner.entity.PlansDAO
import viktor.braus.kplanner.mainPage.*
import viktor.braus.kplanner.network.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import viktor.braus.kplanner.network.WeatherProperty
import java.util.*

//import viktor.braus.kplanner.entity.Plans

class ListViewModel(application: Application,
        private val plansDAO: PlansDAO): AndroidViewModel(application)
{
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
    init
    {
        initializePlans()

    }
    private fun initializePlans()
    {
        viewModelScope.launch {
            plan.value = getPlanFromDb()
        }
    }
    private suspend fun getPlanFromDb(): Plans?
    {

        var planning = plansDAO.getAll()
        if (planning?.EventName != "") {
            planning=null
        }
        return planning
    }
    private suspend fun insert(plan: Plans)
    {
        plansDAO.insert(plan)
    }
    private suspend fun update(plan: Plans)
    {
        plansDAO.update(plan)

    }
    private suspend fun clear()
    {
        plansDAO.clear()

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
    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    fun setWeather()
    {
        getMarsRealEstateProperties()
    }
    /**
     * Sets the value of the response LiveData to the Mars API status or the successful number of
     * Mars properties retrieved.
     */
    private fun getMarsRealEstateProperties() {
        WeatherApi.retrofitService.getProperties().enqueue( object: Callback<WeatherProperty> {
            override fun onFailure(call: Call<WeatherProperty>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }
            override fun onResponse(call: Call<WeatherProperty>, response: Response<WeatherProperty>) {
                _response.value = "Прогноз для міста ${response.body()?.name} на сьогодні: ${response.body()?.main?.temp} 'C \n Відчувається як: ${response.body()?.main?.feels_like} 'C "
            }
        })
    }

}