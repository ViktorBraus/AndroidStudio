package viktor.braus.kplanner.plans

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import viktor.braus.kplanner.mainPage.MainActivity

class ListViewModel(context: Context): ViewModel()
{
    var con: Context=context
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
    fun showUser():String
    {
        Timber.i("-------------------------------------")
        _username.value = "Вітаю, "+MainActivity.S
        return _username.value.toString()
    }
    fun setCount(s:Int):Int {
        var i : Int
        i=s
        _count.value = i
        return _count.value!!
    }

    fun planning(view: View?) {
        val login = Intent(con, PlansCreating::class.java)
        Timber.i("---------------------------Активировано действие перехода на создание плана------------------------")
        con.startActivity(login)
    }
}