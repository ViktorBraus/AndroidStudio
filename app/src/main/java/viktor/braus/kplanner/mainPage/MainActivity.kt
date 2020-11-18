package viktor.braus.kplanner.mainPage

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.entity.PlansDAO
import viktor.braus.kplanner.entity.PlansDatabase
import viktor.braus.kplanner.menu.factoryMethod.About_Fragment
import viktor.braus.kplanner.menu.viewModel.Information_fragment
import viktor.braus.kplanner.plans.listOfPlans.ListFragment
import viktor.braus.kplanner.plans.plansCreating.PlansFactory
import viktor.braus.kplanner.plans.plansCreating.PlansFragment
import viktor.braus.kplanner.plans.plansCreating.PlansViewModel
import viktor.braus.kplanner.timer.TTimer
import java.text.SimpleDateFormat
import java.util.*


//"Перейшов на мову Kotlin, 5 Лабораторна робота"
class MainActivity : AppCompatActivity() {
    var d: String? = null
    var fragment = MainFragment()
    var TTimer: TTimer = TTimer()
    var time: String? = null
    companion object {
        var K_REV: String? = null
        var S: String? = null
    }
        var revenue = 0
    init
    {
        K_REV = "k_rev"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit()
        Timber.i("---------------------------onCreate Called.------------------------")
        TTimer.startTimerTotal()
        if (savedInstanceState != null) {
            revenue = savedInstanceState.getInt(K_REV, 1)
        }

    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(K_REV, TTimer.secondsCountFocused)
        Timber.i("onSaveInstanceState Called")
    }
    override fun onStart() {
        super.onStart()
        Timber.i("----------onStart Called.----------")
    }

    override fun onPause() {
        super.onPause()
        TTimer.stopTimerFocused()
        Timber.i("----------onPause Called.----------")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("----------onDestroy Called.----------")
        TTimer.stopTimerTotal()
    }
    override fun onResume() {
        super.onResume()
        TTimer.startTimerFocused()
        Timber.i("----------onResume Called.----------")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("----------onStop Called.----------")
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.open_activity -> {
                Timber.i("---------------------------Активирован пункт меню открытия распорядка дня------------------------")
                var fragment = ListFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .addToBackStack(null)
                    .commit()
                return true
            }
            R.id.about -> {
                var fragment = About_Fragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .addToBackStack(null)
                    .commit()
                Timber.i("---------------------------Активирован пункт меню про разработчика------------------------")
                return true
            }
            R.id.Rules -> {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    """
                I`m 20 years old, living in Chernivtsi, Ukraine. For 
                whole my life i was always interested in Computer 
                Science and tried to understand how to use this 
                passion in future. When i had to decide which 
                profession would accomplish earning money and 
                doing what i love most i found out that Department 
                of Computer Science in Institute of Physical, 
                Technical and Computer Sciences would be the best 
                decision. I always trying to learn new information 
                from everywhere: from university, from different 
                internet sources etc. I would like to work in 
                team because of my sociable skills and leader 
                qualities. I can perceive a new information and use it 
                as quick as it possible.
                VIKTOR
                KOROLENKO
                """.trimIndent()
                )
                sendIntent.type = "text/*"
                val shareIntent = Intent.createChooser(sendIntent, null)
                Timber.i("---------------------------Активирован пункт меню для отправки------------------------")
                startActivity(shareIntent)
                return true
            }
            R.id.information -> {
                var fragment = Information_fragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .addToBackStack(null)
                    .commit()
                Timber.i("---------------------------Активирован пункт меню про программу------------------------")
                startActivity(intent)
                return true
            }
            R.id.exit -> {
                Timber.i("---------------------------выход из программы------------------------")
                onDestroy()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun sendMessage(view: View) {
        val editText = findViewById<View>(R.id.edit_message) as EditText
        var message = editText.text.toString()
        Timber.plant()
        Timber.i("------------------sendmessage method used--------------------")
        S = message
        Timber.i("Имя пользователя, которое было отправлено: $message")
        var fragment = ListFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit()
    }
    fun Exit(view: View)
    {
        finishAffinity()
    }
    fun BackWard(view: View?)
    {
        Timber.i("---------------------------Возвращение на главный экран------------------------")
        var fragment : MainFragment  = MainFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit()
    }
    fun returning(v:View) {
        Timber.i("---------------------------Возвращение на страницу распорядка------------------------")
        var fragment = ListFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    @SuppressLint("SetTextI18n")
    fun goNext(view: View?) {

    }
    fun Planning(view: View?) {
        Timber.i("---------------------------Активировано действие перехода на создание плана------------------------")
        var fragment = PlansFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit()

    }
//    @SuppressLint("SimpleDateFormat")
//    fun time1(view: View?)
//    {
//        val cal = Calendar.getInstance()
//        var con = PlansFragment().activity
//        val dataSource = PlansDatabase.getInstance(application).plansDAO
//        TimePickerDialog(
//            con,
//            PlansViewModel(application, dataSource).timeSetListener, cal.get(Calendar.HOUR_OF_DAY
//            ), cal.get(Calendar.MINUTE), true
//        ).show()
//        PlansViewModel(application, dataSource).time1()
//    }
    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    fun setTime(v: View)
    {
        var t: TextView = findViewById(R.id.timeEvent)
        var t1: TextView = findViewById(R.id.startTimeEvent)
        var t2: TextView = findViewById(R.id.endTimeEvent)
        val id = v.id
        if(id == R.id.timeButton) {
            val cal = Calendar.getInstance()
            var timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                var t: TextView = findViewById(R.id.timeEvent)
                t.text = SimpleDateFormat().format(cal.time)
                d=t.text.toString()
                Timber.i("nnnnnnnnnnn${d}")
            }
            TimePickerDialog(
                this@MainActivity, timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), true
            ).show()
        }
        if(id==R.id.timeStartButton)
        {
            val cal = Calendar.getInstance()
            var timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                t1.text = SimpleDateFormat().format(cal.time)
                d=t1.text.toString()
            }
            TimePickerDialog(
                this@MainActivity, timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), true
            ).show()
        }
        if(id==R.id.timeEndButton)
        {
            val cal = Calendar.getInstance()
            var timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                t2.text = SimpleDateFormat().format(cal.time)
                d=t2.text.toString()
            }
            TimePickerDialog(
                this@MainActivity, timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), true
            ).show()
        }
    }
}