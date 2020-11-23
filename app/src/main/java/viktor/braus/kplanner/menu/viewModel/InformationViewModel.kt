package viktor.braus.kplanner.menu.viewModel
import android.util.Log
import androidx.lifecycle.ViewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import viktor.braus.kplanner.mainPage.MainActivity
import viktor.braus.kplanner.timer.TTimer

private val CORRECT_BUZZ_PATTERN = longArrayOf(100, 100, 100, 100, 100, 100)
private val PANIC_BUZZ_PATTERN = longArrayOf(0, 200)
private val GAME_OVER_BUZZ_PATTERN = longArrayOf(0, 2000)
private val NO_BUZZ_PATTERN = longArrayOf(0)

class InformationViewModel() : ViewModel() {
    //var username: String? = null
        enum class BuzzType(val pattern: LongArray) {
        CORRECT(CORRECT_BUZZ_PATTERN),
        GAME_OVER(GAME_OVER_BUZZ_PATTERN),
        COUNTDOWN_PANIC(PANIC_BUZZ_PATTERN),
        NO_BUZZ(NO_BUZZ_PATTERN)
    }
    companion object {
        // These represent different important times in the game, such as game length.
        // This is when the game is over
        private const val DONE = 0L
        // This is the time when the phone will start buzzing each second
        private const val COUNTDOWN_PANIC_SECONDS = 10L
        // This is the number of milliseconds in a second
        private const val ONE_SECOND = 1000L
        // This is the total time of the game
        private const val COUNTDOWN_TIME = 60000L

    }
    private var _getT = MutableLiveData<String>()
    private var _username = MutableLiveData<String>()
    private val _eventTimerdzz = MutableLiveData<Boolean>()

    val eventTimedzz: LiveData<Boolean>
        get() = _eventTimerdzz
    val getT: LiveData<String>
        get() = _getT
    val username: LiveData<String>
        get() = _username
    private val _eventBuzz = MutableLiveData<BuzzType>()
    val eventBuzz: LiveData<BuzzType>
        get() = _eventBuzz
    override fun onCleared() {
        super.onCleared()
        Log.i("InformationiewModel", "InformationiewModel destroyed!")
    }
//
    init {
        _eventTimerdzz.value = false
        _getT.value = ""
        _username.value = ""
        Log.i("InformationiewModel", "InformationiewModel created!")
    }
    private val _property = MutableLiveData<String>()
    // The external LiveData interface to the property is immutable, so only this class can modify
    val property: LiveData<String>
        get() = _property
    fun getT(): String
    {
        _property.value="https://thumbs.dreamstime.com/b/%D0%B7%D0%BD%D0%B0%D1%87%D0%BE%D0%BA-%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80-%D0%BF%D0%BB%D0%B0%D0%BD%D0%B0-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%8B-%D1%83%D1%82%D1%80%D0%BE%D0%BC-%D1%82%D0%BE%D0%BD%D0%BA%D0%B0%D1%8F-%D0%B3%D1%80%D0%B0%D0%BD%D1%8C-%D1%87%D0%B5%D1%80%D0%BD%D0%BE%D0%B3%D0%BE-%D0%B8%D0%BB%D0%BB%D1%8E%D1%81%D1%82%D1%80%D0%B0%D1%86%D0%B8%D1%8F-167219112.jpg"
        val df: DateFormat = SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss")
        val date: String = df.format(Calendar.getInstance().getTime())
        if(TTimer.secondsCountTotal<20)
        {
            _username.value = MainActivity.S
            _getT.value = "Текущее имя пользователя: ${_username.value}\n$date"
            return _getT.value.toString()
        }
        else
        {
            _getT.value = "Текущее имя пользователя: ${_username.value}\n$date"
            _eventTimerdzz.value=true
            _eventBuzz.value = BuzzType.CORRECT
            return _getT.value.toString()
        }
    }
    fun onBuzzComplete() {
        _eventBuzz.value = BuzzType.NO_BUZZ
    }
    fun timerCounted()
    {
        _eventTimerdzz.value = false
    }

}
