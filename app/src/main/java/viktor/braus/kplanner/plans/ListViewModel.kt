package viktor.braus.kplanner.plans

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import viktor.braus.kplanner.entity.Plans
import viktor.braus.kplanner.mainPage.MainActivity

class ListViewModel(context: Context): ViewModel()
{

    var i: Int = 0
    var con: Context=context
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
        _nameEvent.value = ""
    }
    fun showUser():String
    {
        Timber.i("-------------------------------------")
        _username.value = "Вітаю, "+MainActivity.S
        return _username.value.toString()
    }
    fun showTime() : String
    {
        _nameEvent.value = "asdgjhDS;L"
        return ""
    }
    fun Mondayplanning(view: View?) {
        i=1
        val login = Intent(con, PlansCreating::class.java)
        Timber.i("---------------------------Активировано действие перехода на создание плана------------------------")
        con.startActivity(login)
    }
    fun Tuesdayplanning(view: View?) {
        i=2
        val login = Intent(con, PlansCreating::class.java)
        Timber.i("---------------------------Активировано действие перехода на создание плана------------------------")
        con.startActivity(login)
    }
    fun Wednesdayplanning(view: View?) {
        i=3
        val login = Intent(con, PlansCreating::class.java)
        Timber.i("---------------------------Активировано действие перехода на создание плана------------------------")
        con.startActivity(login)
    }
    fun Thursdayplanning(view: View?) {
        i=4
        val login = Intent(con, PlansCreating::class.java)
        Timber.i("---------------------------Активировано действие перехода на создание плана------------------------")
        con.startActivity(login)
    }
    fun Fridayplanning(view: View?) {
        i=5
        val login = Intent(con, PlansCreating::class.java)
        Timber.i("---------------------------Активировано действие перехода на создание плана------------------------")
        con.startActivity(login)
    }
    fun Saturdayplanning(view: View?) {
        i=6
        val login = Intent(con, PlansCreating::class.java)
        Timber.i("---------------------------Активировано действие перехода на создание плана------------------------")
        con.startActivity(login)
    }
    fun Sundayplanning(view: View?) {
        i=7
        val login = Intent(con, PlansCreating::class.java)
        Timber.i("---------------------------Активировано действие перехода на создание плана------------------------")
        con.startActivity(login)
    }
}