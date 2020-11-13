package viktor.braus.kplanner.mainPage

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.menu.factoryMethod.About_activity
import viktor.braus.kplanner.menu.viewModel.main_Information_about_program
import viktor.braus.kplanner.plans.ListOfPlans
import viktor.braus.kplanner.timer.TTimer
import java.util.*


//"Перейшов на мову Kotlin, 5 Лабораторна робота"
class MainActivity : AppCompatActivity() {
    var TTimer: TTimer = TTimer()
    var currentDateTime: TextView? = null
    var dateAndTime = Calendar.getInstance()
    companion object {

        var EXTR: String? = null
        var K_REV: String? = null
        var S: String? = null
    }
        var revenue = 0
    init
    {
        EXTR = "EXTRA_MESSAGE"
    }
    init
    {
        K_REV = "k_rev"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)
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
                val intent = Intent(this, ListOfPlans::class.java)
                Timber.i("---------------------------Активирован пункт меню открытия распорядка дня------------------------")
                startActivity(intent)
                return true
            }
            R.id.about -> {
                intent = Intent(this, About_activity::class.java)
                Timber.i("---------------------------Активирован пункт меню про разработчика------------------------")
                startActivity(intent)
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
                intent = Intent(this, main_Information_about_program::class.java)
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

        // действия, совершаемые после нажатия на кнопку
        // Создаем объект Intent для вызова новой Activity

        val intent = Intent(this, ListOfPlans::class.java)
        // Получаем текстовое поле в текущей Activity
        val editText = findViewById<View>(R.id.edit_message) as EditText
        // Получае текст данного текстового поля
        var message = editText.text.toString()
        startActivity(intent)
        Timber.plant()
        Timber.i("------------------sendmessage method used--------------------")
        S = message
        Timber.i("Имя пользователя, которое было отправлено: $message")

    }
    fun Exit(view: View)
    {
        finishAffinity()
    }

}