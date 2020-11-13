package viktor.braus.kplanner.plans

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.menu.factoryMethod.About_activity
import viktor.braus.kplanner.menu.viewModel.main_Information_about_program
import java.text.SimpleDateFormat
import java.util.*

class PlansCreating : AppCompatActivity() {
    lateinit var viewModel : PlansViewModel
    companion object{
        lateinit var ccontext : Context
    }
    init {
        ccontext =this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plans_creating)
    }
    lateinit var listViewModel: ListViewModel
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

    fun returning(view: View?) {
        val intent = Intent(this, ListOfPlans::class.java)
        Timber.i("---------------------------Возвращение на страницу распорядка------------------------")
        startActivity(intent)
        finish()
    }

    @SuppressLint("SetTextI18n")
    fun goNext(view: View?) {
        val eventText: TextView = findViewById(R.id.nameEvent)
        val time: TextView = findViewById(R.id.timeEvent)
        val sTime: TextView = findViewById(R.id.startTimeEvent)
        val eTime: TextView = findViewById(R.id.endTimeEvent)
        val tname: TextView
        val ttime: TextView
        if(time.text != "")
        {
            val i:Int = listViewModel.count.value!!
            when (i) {
                1->{
                    tname = findViewById(R.id.mondayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.mondayTime)
                    ttime.text ="Початок: "+sTime.text.toString()+"\n"+"Кінець: "+ eTime.text.toString()
                }
                2->{tname = findViewById(R.id.mondayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.mondayTime)
                    ttime.text = "Час події: "+time.text.toString()
                }
                3->{tname = findViewById(R.id.mondayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.mondayTime)
                    ttime.text = "Час події: "+time.text.toString()
                }
                4->{tname = findViewById(R.id.mondayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.mondayTime)
                    ttime.text = "Час події: "+time.text.toString()
                }
                5->{tname = findViewById(R.id.mondayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.mondayTime)
                    ttime.text = "Час події: "+time.text.toString()
                }
                6->{tname = findViewById(R.id.mondayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.mondayTime)
                    ttime.text = "Час події: "+time.text.toString()
                }
                7->{tname = findViewById(R.id.mondayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.mondayTime)
                    ttime.text = "Час події: "+time.text.toString()
                }
            }
        }
        else
        {
            val i:Int = listViewModel.count.value!!
            when (i) {
                1->{
                    tname = findViewById(R.id.mondayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.mondayTime)
                    ttime.text ="Початок: "+sTime.text.toString()+"\n"+"Кінець: "+ eTime.text.toString()
                }
                2->{tname = findViewById(R.id.tuesdayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.tuesdayTime)
                    ttime.text ="Початок: "+sTime.text.toString()+"\n"+"Кінець: "+ eTime.text.toString()
                }
                3->{tname = findViewById(R.id.wednesdayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.wednesdayTime)
                    ttime.text ="Початок: "+sTime.text.toString()+"\n"+"Кінець: "+ eTime.text.toString()
                }
                4->{tname = findViewById(R.id.thursdayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.thursdayTime)
                    ttime.text ="Початок: "+sTime.text.toString()+"\n"+"Кінець: "+ eTime.text.toString()
                }
                5->{tname = findViewById(R.id.fridayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.fridayTime)
                    ttime.text ="Початок: "+sTime.text.toString()+"\n"+"Кінець: "+ eTime.text.toString()
                }
                6->{tname = findViewById(R.id.saturdayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.saturdayTime)
                    ttime.text ="Початок: "+sTime.text.toString()+"\n"+"Кінець: "+ eTime.text.toString()
                }
                7->{tname = findViewById(R.id.sundayText)
                    tname.text = eventText.text
                    ttime = findViewById(R.id.sundayTime)
                    ttime.text ="Початок: "+sTime.text.toString()+"\n"+"Кінець: "+ eTime.text.toString()
                }
            }
        }
        val intent = Intent(this, ListOfPlans::class.java)
        Timber.i("---------------------------Добавление пункта в распорядок------------------------")
        startActivity(intent)
        finish()
    }

    }