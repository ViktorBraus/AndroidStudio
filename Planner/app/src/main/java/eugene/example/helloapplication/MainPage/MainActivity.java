package eugene.example.helloapplication.MainPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import eugene.example.helloapplication.Menu.About_activity;
import eugene.example.helloapplication.Plans.Plans;
import eugene.example.helloapplication.R;
import eugene.example.helloapplication.Timer.Timer;
import eugene.example.helloapplication.Menu.main_Information_about_program;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    public Timer timer = new Timer();
    public static String EXTR;
    public final static String K_REV = "k_rev";
    public int revenue=0;
    static {
        EXTR = "EXTRA_MESSAGE";
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        Timber.i("---------------------------onCreate Called.------------------------");
        timer.startTimerTotal();
        if (savedInstanceState!=null)
        {
            revenue = savedInstanceState.getInt(K_REV, 1);
        }
        MainActivity.EXTR = EXTR;
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(K_REV,timer.getSecondsCountFocused());
        Timber.i("onSaveInstanceState Called");
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Timber.i("----------onStart Called.----------");
    }
    @Override
    public void onPause()
    {
        super.onPause();
        timer.stopTimerFocused();
        Timber.i("----------onPause Called.----------");
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Timber.i("----------onDestroy Called.----------");
        timer.stopTimerTotal();
    }
    @Override
    public void onResume()
    {
        super.onResume();
        timer.startTimerFocused();
        Timber.i("----------onResume Called.----------");
    }
    @Override
    public void onStop()
    {
        super.onStop();
        Timber.i("----------onStop Called.----------");
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.header);
        switch(id){
            case R.id.open_activity :
                Intent intent = new Intent(this, Plans.class);
                Timber.i("---------------------------Активирован пункт меню открытия распорядка дня------------------------");
                startActivity(intent);
                return true;
            case R.id.about:
                intent = new Intent(this, About_activity.class);
                Timber.i("---------------------------Активирован пункт меню про разработчика------------------------");
                startActivity(intent);
                return true;
            case R.id.Rules:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "I`m 20 years old, living in Chernivtsi, Ukraine. For \n" +
                        "whole my life i was always interested in Computer \n" +
                        "Science and tried to understand how to use this \n" +
                        "passion in future. When i had to decide which \n" +
                        "profession would accomplish earning money and \n" +
                        "doing what i love most i found out that Department \n" +
                        "of Computer Science in Institute of Physical, \n" +
                        "Technical and Computer Sciences would be the best \n" +
                        "decision. I always trying to learn new information \n" +
                        "from everywhere: from university, from different \n" +
                        "internet sources etc. I would like to work in \n" +
                        "team because of my sociable skills and leader \n" +
                        "qualities. I can perceive a new information and use it \n" +
                        "as quick as it possible.\n" +
                        "VIKTOR\n" +
                        "KOROLENKO");
                sendIntent.setType("text/*");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                Timber.i("---------------------------Активирован пункт меню для отправки------------------------");
                startActivity(shareIntent);
                return true;
            case R.id.information:
                intent = new Intent(this, main_Information_about_program.class);
                Timber.i("---------------------------Активирован пункт меню про программу------------------------");
                startActivity(intent);
                return true;
            case R.id.exit:
                Timber.i("---------------------------выход из программы------------------------");
                onDestroy();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void sendMessage(View view)
    {
            // действия, совершаемые после нажатия на кнопку
            // Создаем объект Intent для вызова новой Activity
            Intent intent = new Intent(this, Plans.class);
            // Получаем текстовое поле в текущей Activity
            EditText editText = (EditText) findViewById(R.id.edit_message);
            // Получае текст данного текстового поля
            String message = editText.getText().toString();
            // Добавляем с помощью свойства putExtra объект - первый параметр - ключ,
            // второй параметр - значение этого объекта
            intent.putExtra(EXTR, message);
            // запуск activity
            startActivity(intent);
            Timber.plant();
            Timber.i("------------------sendmessage method used--------------------");
    }
    public void Exit(View view)
    {
        onDestroy();
    }

}
