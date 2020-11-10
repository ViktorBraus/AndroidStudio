package viktor.braus.kplanner.Plans

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import viktor.braus.kplanner.mainPage.MainActivity
import viktor.braus.kplanner.menu.factoryMethod.About_activity
import viktor.braus.kplanner.menu.viewModel.main_Information_about_program
import viktor.braus.kplanner.PlansCreating.PlansCreating
import viktor.braus.kplanner.R
import timber.log.Timber

class Plans : AppCompatActivity() {
    companion object {
        val EXTRA: String? = "EXTRA_MESSAGE"
        //public String message1 = intent.getStringExtra(Schedule.EXTRA_MESSAGE);
    }

    var abc: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plans)
        // Получаем сообщение из объекта intent
        val intent = this.intent
        val message = intent.getStringExtra(MainActivity.EXTR)
        val message1 = intent.getStringExtra(PlansCreating.EXTRA_MESSAGE)
        val message2 = intent.getStringExtra(PlansCreating.EXTRA_MESSAGE1)
        val message3 = intent.getStringExtra(PlansCreating.EXTRA)
        // Создаем текстовое поле
        val User = findViewById<TextView>(R.id.name)
        User.textSize = 14f
        User.text = message
        val NameOfAction = findViewById<TextView>(R.id.textView7)
        NameOfAction!!.textSize = 14f
        NameOfAction.text = message1
        val TimeOfAction = findViewById<TextView>(R.id.textView11)
        TimeOfAction.textSize = 14f
        TimeOfAction.text = message2
        if (NameOfAction != null) User.text = message3
        abc=message3
        Timber.i("Имя пользователя: $message")
    }

    public override fun onStart() {
        super.onStart()
        Timber.i("----------onStart Called.----------")
    }

    public override fun onPause() {
        super.onPause()
        Timber.i("----------onPause Called.----------")
    }

    public override fun onDestroy() {
        super.onDestroy()
        Timber.i("----------onDestroy Called.----------")
    }

    public override fun onResume() {
        super.onResume()
        Timber.i("----------onResume Called.----------")
    }

    public override fun onStop() {
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
                val intent = Intent(this, Plans::class.java)
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
                    Intent.EXTRA_TEXT, """
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

    fun planning(view: View?) {
        val intent = Intent(this, PlansCreating::class.java)
        val editText = findViewById<TextView>(R.id.name)
        val message_name = editText.text.toString()
        intent.putExtra(EXTRA, message_name)
        Timber.i("---------------------------Активировано действие перехода на создание плана------------------------")
        startActivity(intent)
    }

    fun BackWard(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        Timber.i("---------------------------Возвращение на главный экран------------------------")
        startActivity(intent)
    }
}