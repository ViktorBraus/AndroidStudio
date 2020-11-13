package viktor.braus.kplanner.plans

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.mainPage.MainActivity
import viktor.braus.kplanner.menu.factoryMethod.About_activity
import viktor.braus.kplanner.menu.viewModel.main_Information_about_program

class ListOfPlans : AppCompatActivity(){

    lateinit var viewModel : ListViewModel
    companion object{
    lateinit var ccontext : Context
    }
    init {
        ccontext =this
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_of_plans)

        Timber.i("Имя пользователя: $")
    }

    public override fun onStart() {
        super.onStart()
        Timber.i("----------onStart Called.----------")
    }

    public override fun onDestroy() {
        super.onDestroy()
        Timber.i("----------onStart Called.----------")
    }
    public override fun onPause() {
        super.onPause()
        Timber.i("----------onPause Called.----------")
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
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    /*fun planning(view: View?) {
        val intent = Intent(this, PlansCreating::class.java)
        Timber.i("---------------------------Активировано действие перехода на создание плана------------------------")
        startActivity(intent)
    }
    */
    fun BackWard(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        Timber.i("---------------------------Возвращение на главный экран------------------------")
        startActivity(intent)
        finish()
    }
}