package viktor.braus.kplanner.plans.listOfPlans

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import timber.log.Timber
import viktor.braus.kplanner.entity.Plans
import viktor.braus.kplanner.entity.PlansDAO
import viktor.braus.kplanner.mainPage.*
//import viktor.braus.kplanner.entity.Plans

class ListViewModel(application: Application,
        private val plansDAO: PlansDAO): AndroidViewModel(application)
{
    companion object {

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
    private val plans = plansDAO.getAllPlans()
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
    fun onStartTracking()
    {
        val newPlan = Plans()
        viewModelScope.launch{
            newPlan.EventName = "TextName"
            newPlan.Time = "TestTime"
            insert(newPlan)
            plan.value = getPlanFromDb()

        }
        Timber.i("vbvbvbvbvb ${newPlan.EventName}")
        Timber.i("vbvbvbvbvb ${newPlan.Time}")
        //MainActivity().returning()
    }
    fun onStopTracking()
    {
        viewModelScope.launch {
            var oldPlan = plan.value ?: return@launch
            oldPlan.EventName = "TextNameccc"
            oldPlan.EventName = "TestTimecc"
            update(oldPlan)
        }
    }
    fun onClear() {
        viewModelScope.launch {
            // Clear the database table.
            clear()
            // And clear tonight since it's no longer in the database
            plan.value = null
        }
        _showSnackbarEvent.value = true
    }
}