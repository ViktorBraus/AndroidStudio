package viktor.braus.kplanner.plans



import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.*
import timber.log.Timber
import viktor.braus.kplanner.R
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*


class PlansViewModel(context: Context) : ViewModel() {

    val cal = Calendar.getInstance()
    var con: Context=context
    var counter: Boolean = true
    private val _count = MutableLiveData<Int>()
    val count : LiveData<Int>
        get() = _count
    /////////////////////////////////////////////////////       для записи значений имени и времени события
    private var _nameEvent = MutableLiveData<String>()
    val nameEvent: LiveData<String>
        get() = _nameEvent
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
    private var _textTime = MutableLiveData<String>()
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
        _count.value = 0
        _nameEvent.value="aaa"
        _eventName.value="qqq"
        _nameEvent.value=""
        _timeEvent.value=""
        _timeStart.value=""
        _timeEnd.value=""
        _textTime.value=""
        _textStartTime.value=""
        _textStopTime.value=""
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
            _textTime.value=""
            return _editTime.value!!
        } else {
            Timber.i("||||||||||||||||||||||||||||||||||||||||||||||")
            _additionaltime.value = View.INVISIBLE
            _mainTime.value = View.VISIBLE
            counter = true
            _textStartTime.value=""
            _textStopTime.value=""
            _textTime.value=""
            changeAppearance()
            return _editTime.value
        }
    }
    fun setCount(s:Int):Int {
        val i : Int = s
        _count.value = i
        return _count.value!!
    }
    fun changeAppearance() {
        _editTime.value = false
    }
    fun planning(view: View?) {
        goNext(view)
        val login = Intent(con, ListOfPlans::class.java)
        Timber.i("zzz${_nameEvent.value}")
        Timber.i("zzz${_timeEvent.value}")
        con.startActivity(login)
    }
    @SuppressLint("SetTextI18n")
    fun goNext(view: View?) {
        Timber.i("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv")
        if(textTime.value != "")
        {
            _nameEvent.value = _eventName.value
            _timeEvent.value =_textTime.value
        }
        else
        {
            _nameEvent.value = _eventName.value
            _timeEvent.value ="Початок: "+_textStartTime.value+"\n"+"Кінець: "+ _textStopTime.value
        }

    }
    @SuppressLint("SimpleDateFormat")
    fun time1() {
                var timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                    cal.set(Calendar.HOUR_OF_DAY, hour)
                    cal.set(Calendar.MINUTE, minute)
                    Log.i("ccccmcmcmcm", "${_timeEvent.value}")
                    _textTime.value = SimpleDateFormat().format(cal.time)
                }
                TimePickerDialog(con, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    }
    @SuppressLint("SimpleDateFormat")
    fun time2() {
        var timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            Log.i("vbvbvbvbvb", "${_timeStart.value}")
            _textStartTime.value = SimpleDateFormat().format(cal.time)
        }
        TimePickerDialog(con, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()

    }
    @SuppressLint("SimpleDateFormat")
    fun time3() {
        var timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            Log.i("nnnnn", "${_timeStart.value}")
            _textStopTime.value = SimpleDateFormat().format(cal.time)
        }
        TimePickerDialog(con, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    }
    /*fun time(view: View?)
    {
        val i: Int? = count.value
        Timber.i("$i")
        when (i) {
                1->{
                    var timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                    cal.set(Calendar.HOUR_OF_DAY, hour)
                    cal.set(Calendar.MINUTE, minute)
                    Log.i("fsdhgad", "bbbbbbb")
                    _timeEvent.value = SimpleDateFormat().format(cal.time)
                }
                    TimePickerDialog(con, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
                }
                2->{
                    var timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                        cal.set(Calendar.HOUR_OF_DAY, hour)
                        cal.set(Calendar.MINUTE, minute)
                        Log.i("fsdhgad", "fffffff")
                        _timeStart.value = SimpleDateFormat().format(cal.time)
                    }
                    TimePickerDialog(con, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
                }
                3->{var timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                    cal.set(Calendar.HOUR_OF_DAY, hour)
                    cal.set(Calendar.MINUTE, minute)
                    Log.i("fsdhgad", "dddddddd")
                    _timeEnd.value = SimpleDateFormat().format(cal.time)
                }
                    TimePickerDialog(con, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
                }

        }
    }*/
}