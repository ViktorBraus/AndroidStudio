package viktor.braus.kplanner.plans.plansCreating

import android.annotation.SuppressLint
import android.app.Application
import android.app.TimePickerDialog
import android.content.Intent
import android.view.View
import androidx.lifecycle.*
import timber.log.Timber
import viktor.braus.kplanner.entity.PlansDAO
import viktor.braus.kplanner.mainPage.MainActivity
import viktor.braus.kplanner.plans.listOfPlans.ListFragment
import viktor.braus.kplanner.plans.listOfPlans.ListViewModel
import java.text.SimpleDateFormat
import java.util.*

class PlansViewModel(application: Application,
                     val plansDAO: PlansDAO) : AndroidViewModel(application) {
    //private var viewModel: ListViewModel = ListViewModel(context)
    val cal = Calendar.getInstance()
    var con: Application=application
    private var _time = MutableLiveData<String>()
    val time: LiveData<String>
        get() = _time
    var counter: Boolean = true
    var _j = MutableLiveData<Int>()
    val j: LiveData<Int>
        get() = _j
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count
    /////////////////////////////////////////////////////       для записи значений имени и времени события

    private var _timeEvent = MutableLiveData<String>()
    val timeEvent: LiveData<String>
        get() = _timeEvent
    private var _timeStart = MutableLiveData<String>()
    val timeStart: LiveData<String>
        get() = _timeStart
    private var _timeEnd = MutableLiveData<String>()
    val timeEnd: LiveData<String>
        get() = _timeEnd

    ////////////////////////////////////////////////////////        для обнуления полей при нажатии на чекбокс
    private var _eventName = MutableLiveData<String>()
    val eventName: LiveData<String>
        get() = _eventName
    private var _textStartTime = MutableLiveData<String>()
    val textStartTime: LiveData<String>
        get() = _textStartTime
    private var _textStopTime = MutableLiveData<String>()
    val textStopTime: LiveData<String>
        get() = _textStopTime
    private var _nameEvent = MutableLiveData<String>()
    val nameEvent: LiveData<String>
        get() = _nameEvent
    var _textTime = MutableLiveData<String>()
    val textTime: LiveData<String>
        get() = _textTime
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
        _nameEvent.value="bbbb"
        _count.value = 0
        _timeEvent.value = ""
        _timeStart.value = ""
        _timeEnd.value = ""
        _textStartTime.value = ""
        _textStopTime.value = ""
        _mainTime.value = View.VISIBLE
        _additionaltime.value = View.INVISIBLE
    }


    fun monitor(): Boolean? {
        if (counter) {
            Timber.i("-----------------------------------------")
            _editTime.value = true
            _additionaltime.value = View.VISIBLE
            _mainTime.value = View.INVISIBLE
            counter = false
            _textTime.value = ""
            return _editTime.value!!
        } else {
            Timber.i("||||||||||||||||||||||||||||||||||||||||||||||")
            _additionaltime.value = View.INVISIBLE
            _mainTime.value = View.VISIBLE
            counter = true
            _textStartTime.value = ""
            _textStopTime.value = ""
            _textTime.value = ""
            changeAppearance()
            return _editTime.value
        }
    }

    fun update() :String
    {
        return _nameEvent.value.toString()
    }
    fun setCount(s: Int): Int {
        val i: Int = s
        _count.value = i
        return _count.value!!
    }

    fun changeAppearance() {
        _editTime.value = false
    }
    fun planning() {
        if (textTime.value != "") {
            when (ListViewModel.S) {
                1 -> {
                   // _nameEvent.value = _eventName.value
                    _timeEvent.value = "Час події: " + _textTime.value
                }
                2 -> {
                    _nameEvent.value = _eventName.value
                    _timeEvent.value = "Час події: " + _textTime.value
                }
                3 -> {
                    _nameEvent.value = _eventName.value
                    _timeEvent.value = "Час події: " + _textTime.value
                }
                4 -> {
                    _nameEvent.value = _eventName.value
                    _timeEvent.value = "Час події: " + _textTime.value
                }
                5 -> {
                    _nameEvent.value = _eventName.value
                    _timeEvent.value = "Час події: " + _textTime.value
                }
                6 -> {
                    _nameEvent.value = _eventName.value
                    _timeEvent.value = "Час події: " + _textTime.value
                }
                7 -> {
                    _nameEvent.value = _eventName.value
                    _timeEvent.value = "Час події: " + _textTime.value
                }
                else -> {
                    Timber.i("Wrong")
                }
            }
        }
            else
        {
            when (ListViewModel.S)
                {
                    1 ->
                    {
                        Timber.i("textTime eeeis: ${textTime.value}")
                        _nameEvent.value = _eventName.value
                        _timeEvent.value = "Початок: "+textStartTime.value+"\n"+"Кінець: "+textStopTime.value
                    }
                    2 ->
                    {
                        _nameEvent.value = _eventName.value
                        _timeEvent.value = "Початок: "+textStartTime.value+"\n"+"Кінець: "+textStopTime.value
                    }
                    3 ->
                    {
                        _nameEvent.value = _eventName.value
                        _timeEvent.value = "Початок: "+textStartTime.value+"\n"+"Кінець: "+textStopTime.value
                    }
                    4 ->
                    {
                        _nameEvent.value = _eventName.value
                        _timeEvent.value = "Початок: "+textStartTime.value+"\n"+"Кінець: "+textStopTime.value
                    }
                    5 ->
                    {
                        _nameEvent.value = _eventName.value
                        _timeEvent.value = "Початок: "+textStartTime.value+"\n"+"Кінець: "+textStopTime.value
                    }
                    6 ->
                    {
                        _nameEvent.value = _eventName.value
                        _timeEvent.value = "Початок: "+textStartTime.value+"\n"+"Кінець: "+textStopTime.value
                    }
                    7 ->
                    {
                        _nameEvent.value = _eventName.value
                        _timeEvent.value = "Початок: "+textStartTime.value+"\n"+"Кінець: "+textStopTime.value
                    }
                    else ->
                    {
                        Timber.i("Wrong")
                    }
                }
        }
        //goNext(view)
        Timber.i("Name of event is: ${nameEvent.value}")
        Timber.i("Time of event is: ${textTime.value}")
        update()

    }
    //@SuppressLint("SetTextI18n")
//    fun goNext(view: View?) {
//
//        _nameEvent.value = _nameEvent.value
//        if(textTime.value == "")
//        {
//            _nameEvent.value =_nameEvent.value
//            _textTime.value = _eventName.value
//
//        }
//        else
//        {
//            _nameEvent.value = _eventName.value
//            _timeEvent.value ="Початок: "+_textStartTime.value+"\n"+"Кінець: "+ _textStopTime.value
//        }
//
//    }
    @SuppressLint("SimpleDateFormat")
    fun time2(view: View?) {
        var timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            _textStartTime.value = SimpleDateFormat().format(cal.time)
        }
        TimePickerDialog(con, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()

    }
    @SuppressLint("SimpleDateFormat")
    fun time3(view: View?) {
        var timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            _textStopTime.value = SimpleDateFormat().format(cal.time)
        }
        TimePickerDialog(con, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    }

    /////////////////Coroutine//////////////////////////////
    /*private val viewModelJob = Job()
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    private val uiScope = CoroutineScope(Dispatchers.Main+viewModelJob)
    private var _nameEvent = MutableLiveData<String>()
    val nameEvent: LiveData<String>
        get() = _nameEvent
    private var _textTime = MutableLiveData<String>()
    val textTime: LiveData<String>
        get() = _textTime
    private var plan = MutableLiveData<Plans?>()
    private val plans = plansDAO.getAllPlans()
    init
    {
        _nameEvent.value="bbbb"
        _textTime.value=""
    initializePlans()
    }
    private fun initializePlans()
    {
        uiScope.launch {
            plan.value = getPlanFromDb()
        }
    }
    private suspend fun getPlanFromDb():Plans?
    {
        var planning = plansDAO.getAll()
        if (planning?.EventName == "") {
            planning.EventName = nameEvent.value.toString()
            planning.Time = textTime.value.toString()
        }
        return planning
    }
    fun onStartTracking()
    {
        uiScope.launch {
            val newPlan = Plans()
            insert(newPlan)
            plan.value = getPlanFromDb()
        }
        val login = Intent(con, ListOfPlans::class.java)
        update()
        Timber.i("Name of event is: ${nameEvent.value}")
        Timber.i("Time of event is: ${textTime.value}")
        con.startActivity(login)
    }

    private suspend fun insert(plan:Plans)
    {
        withContext(Dispatchers.IO)
        {
            plansDAO.insert(plan)
        }
    }
    private suspend fun update(plan:Plans)
    {
        withContext(Dispatchers.IO)
        {
            plansDAO.update(plan)
        }
    }
    suspend fun clear()
    {
        withContext(Dispatchers.IO)
        {
            plansDAO.clear()
        }
    }
    fun onClear()
    {
        uiScope.launch {
            clear()
            plan.value = null
        }
    }
    fun onStopTracking()
    {
        uiScope.launch {
            var oldPlan = plan.value ?: return@launch
            oldPlan.EventName = nameEvent.value.toString()
            oldPlan.EventName = textTime.value.toString()
            update(oldPlan)
        }
    }
    fun formatPlans()
    {

    }*/
}