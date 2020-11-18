package viktor.braus.kplanner.plans.plansCreating

import android.annotation.SuppressLint
import android.app.Application
import android.app.TimePickerDialog
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.*
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.entity.Plans
import viktor.braus.kplanner.entity.PlansDAO
import viktor.braus.kplanner.mainPage.MainActivity
import viktor.braus.kplanner.mainPage.formatNights
import viktor.braus.kplanner.plans.listOfPlans.ListFragment
import viktor.braus.kplanner.plans.listOfPlans.ListViewModel
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

class PlansViewModel(application: Application,
                     private val plansDAO: PlansDAO) : AndroidViewModel(application) {
    //////////////////////                                      Для связи с БД
    private var plan = MutableLiveData<Plans?>()
    private val plans = plansDAO.getAllPlans()
    val nightsString = Transformations.map(plans) { nights ->
        formatNights(nights, application.resources)
    }
    var counter: Boolean = true
    /////////////////////////////////////////////////////       для записи значений имени и времени события

    private val _selectedTime = MutableLiveData<LocalTime>()
    val selectedTime: LiveData<LocalTime> = _selectedTime
    fun setSelectedTime(time: LocalTime) {
        _selectedTime.value = time
    }
    private val _selectedStartTime = MutableLiveData<LocalTime>()
    val selectedStartTime: LiveData<LocalTime> = _selectedStartTime
    fun setSelectedStartTime(time: LocalTime) {
        _selectedStartTime.value = time
    }
    private val _selectedEndTime = MutableLiveData<LocalTime>()
    val selectedEndTime: LiveData<LocalTime> = _selectedEndTime
    fun setSelectedEndTime(time: LocalTime) {
        _selectedEndTime.value = time
    }
    var timeText: LiveData<String> = Transformations.map(_selectedTime) {
        it.format(DateTimeFormatter.ofPattern("hh:mm a"))
    }
    var timeStartText: LiveData<String> = Transformations.map(_selectedStartTime) {
        it.format(DateTimeFormatter.ofPattern("hh:mm a"))
    }
    var timeEndText: LiveData<String> = Transformations.map(_selectedEndTime) {
        it.format(DateTimeFormatter.ofPattern("hh:mm a"))
    }
    private var _nameEvent = MutableLiveData<String>()
    val nameEvent: LiveData<String>
        get() = _nameEvent
    fun update1(result: String){ _nameEvent.value = result }
    ////////////////////////////////////////////////////////    для изменения видимости
    private val _additionaltime = MutableLiveData<Int>()
    val additionaltime: LiveData<Int>
        get() = _additionaltime
    private val _mainTime = MutableLiveData<Int>()
    val mainTime: LiveData<Int>
        get() = _mainTime
    private val _editTime = MutableLiveData<Boolean>()         // меняет состояние кнопки
    val editTime: LiveData<Boolean>
        get() = _editTime
    init {
        _mainTime.value = View.VISIBLE
        _additionaltime.value = View.INVISIBLE
        _nameEvent.value=""
        initializePlans()
    }
    fun monitor(): Boolean? {
        if (counter) {
            Timber.i("-----------------------------------------")
            _editTime.value = true
            _additionaltime.value = View.VISIBLE
            _mainTime.value = View.INVISIBLE
            counter = false
            setSelectedTime(LocalTime.of(0,0))
            setSelectedStartTime((LocalTime.of(0,0)))
            setSelectedEndTime(LocalTime.of(0,0))
            return _editTime.value!!
        } else {
            Timber.i("||||||||||||||||||||||||||||||||||||||||||||||")
            _additionaltime.value = View.INVISIBLE
            _mainTime.value = View.VISIBLE
            counter = true
            setSelectedTime(LocalTime.of(0,0))
            setSelectedStartTime((LocalTime.of(0,0)))
            setSelectedEndTime(LocalTime.of(0,0))
            _editTime.value = false
            return _editTime.value
        }
    }

    private fun initializePlans()
    {
        viewModelScope.launch {
            plan.value = getPlanFromDb()
        }
    }
    private suspend fun getPlanFromDb():Plans?
    {
        var planning = plansDAO.getAll()
        if (planning?.EventName != "") {
            planning=null
        }
        return planning
    }
    private suspend fun insert(plan:Plans)
    {
            plansDAO.insert(plan)
    }
    private suspend fun update(plan:Plans)
    {
            plansDAO.update(plan)

    }
    fun onStartTracking()
    {
        val newPlan = Plans()
        viewModelScope.launch{
            newPlan.EventName = nameEvent.value.toString()
            if(selectedTime.value.toString() == "00:00")
            {
                newPlan.Time="Інтервал"
                newPlan.StartTime = selectedStartTime.value.toString()
                newPlan.EndTime = selectedEndTime.value.toString()
            }
            else
            {
                newPlan.Time=selectedTime.value.toString()
            }
            insert(newPlan)
            plan.value = getPlanFromDb()
        }
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
}