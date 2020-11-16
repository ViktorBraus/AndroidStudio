package viktor.braus.kplanner.plans.listOfPlans

import android.app.Application
import androidx.lifecycle.*
import timber.log.Timber
import viktor.braus.kplanner.entity.PlansDAO
//import viktor.braus.kplanner.entity.Plans
import viktor.braus.kplanner.mainPage.MainActivity

class ListViewModel(application: Application,
        plansDAO: PlansDAO): AndroidViewModel(application)
{
    companion object {

        var S: Int? = null
    }
    private var _eventName = MutableLiveData<String>()
    val eventName: LiveData<String>
        get() = _eventName
    var _j = MutableLiveData<Int>()
    val j: LiveData<Int>
        get() = _j
    var con: Application=application
    var _nameEvent = MutableLiveData<String>()
    val nameEvent: LiveData<String>
        get() = _nameEvent
    var _timeEvent = MutableLiveData<String>()
    val timeEvent: LiveData<String>
        get() = _timeEvent
    var _timeStart = MutableLiveData<String>()
    val timeStart: LiveData<String>
        get() = _timeStart
    var _timeEnd = MutableLiveData<String>()
    val timeEnd: LiveData<String>
        get() = _timeEnd
    private val _count = MutableLiveData<Int>()
    val count : LiveData<Int>
        get() = _count
    private val _username = MutableLiveData<String>()
    val username : LiveData<String>
        get() = _username
    private var _textStartTime = MutableLiveData<String>()
    val textStartTime: LiveData<String>
        get() = _textStartTime
    private var _textStopTime = MutableLiveData<String>()
    val textStopTime: LiveData<String>
        get() = _textStopTime
    private var _textTime = MutableLiveData<String>()
    val textTime: LiveData<String>
        get() = _textTime
    init {
        _count.value=0
        _username.value = " "
        _textStartTime.value = " "
        _textStopTime.value = " "
        _textTime.value = " "
        _nameEvent.value = " "
    }
    fun setValues(): String {
        _eventName.value = _eventName.value
        return _eventName.value.toString()
    }
    fun showUser():String
    {
        Timber.i("-------------------------------------")
        _username.value = "Вітаю, "+MainActivity.S
        return _username.value.toString()
    }
}