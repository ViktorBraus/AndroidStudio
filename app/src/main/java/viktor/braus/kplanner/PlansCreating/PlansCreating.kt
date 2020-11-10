package viktor.braus.kplanner.PlansCreating

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import viktor.braus.kplanner.menu.factoryMethod.About_activity
import viktor.braus.kplanner.menu.viewModel.main_Information_about_program
import viktor.braus.kplanner.Plans.Plans
import viktor.braus.kplanner.R
import timber.log.Timber

class PlansCreating : AppCompatActivity() {
    companion object {
        var EXTRA: String? = null
        var EXTRA_MESSAGE: String? = null
        var EXTRA_MESSAGE1: String? = null

        init {
            EXTRA = "EXTRA_MESSAGE"
        }

        init {
            EXTRA_MESSAGE = "EXTRA_MESSAGE1"
        }

        init {
            EXTRA_MESSAGE1 = "EXTRA_MESSAGE2"
        }
    }

    private var chipAction: CheckBox? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        val intent = intent
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule)
        chipAction = findViewById<View>(R.id.checkBox) as CheckBox
        val message = intent.getStringExtra(Plans.EXTRA)
        val User = findViewById<TextView>(R.id.textView17)
        User.textSize = 14f
        User.text = message
        intent.putExtra(EXTRA, message)
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

    fun onClick(v: View?) {
        Timber.i("---------------------------Изменение видимости времени события------------------------")
        val name = findViewById<TextView>(R.id.textView15)
        val name1 = findViewById<TextView>(R.id.textView16)
        val start = findViewById<EditText>(R.id.editTextTime2)
        val end = findViewById<EditText>(R.id.editTextTime3)
        if (chipAction!!.isChecked == true) {
            name.visibility = View.VISIBLE
            name1.visibility = View.VISIBLE
            start.visibility = View.VISIBLE
            end.visibility = View.VISIBLE
        } else {
            name.visibility = View.INVISIBLE
            name1.visibility = View.INVISIBLE
            start.visibility = View.INVISIBLE
            end.visibility = View.INVISIBLE
        }
    }

    fun returning(view: View?) {
        val intent = Intent(this, Plans::class.java)
        Timber.i("---------------------------Возвращение на страницу распорядка------------------------")
        startActivity(intent)
    }

    fun GoNext(view: View?) {
        val intent = Intent(this, Plans::class.java)
        val editText = findViewById<EditText>(R.id.NameOfAction)
        val message_name = editText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message_name)
        val time = findViewById<EditText>(R.id.editTextTime)
        val message_time = time.text.toString()
        intent.putExtra(EXTRA_MESSAGE1, message_time)
        val editText1 = findViewById<TextView>(R.id.textView17)
        // Получае текст данного текстового поля
        val message = editText1.text.toString()
        // Добавляем с помощью свойства putExtra объект - первый параметр - ключ,
        // второй параметр - значение этого объекта
        intent.putExtra(EXTRA, message)
        Timber.i("---------------------------Добавление пункта в распорядок------------------------")
        startActivity(intent)
    }
}