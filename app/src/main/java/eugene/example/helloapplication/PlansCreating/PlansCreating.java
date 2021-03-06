package eugene.example.helloapplication.PlansCreating;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import eugene.example.helloapplication.Menu.About_activity;
import eugene.example.helloapplication.Plans.Plans;
import eugene.example.helloapplication.R;
import eugene.example.helloapplication.Menu.main_Information_about_program;
import timber.log.Timber;

public class PlansCreating extends AppCompatActivity
{
    public final static String EXTRA;
    public final static String EXTRA_MESSAGE;
    public final static String EXTRA_MESSAGE1;
    static
    {
        EXTRA = "EXTRA_MESSAGE";
    }
    static
    {
    EXTRA_MESSAGE = "EXTRA_MESSAGE1";
    }
    static {
        EXTRA_MESSAGE1 = "EXTRA_MESSAGE2";
    }
    private CheckBox chipAction;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        this.chipAction = (CheckBox) this.findViewById(R.id.checkBox);
        String message = intent.getStringExtra(Plans.EXTRA);
        TextView User = findViewById(R.id.textView17);
        User.setTextSize(14);
        User.setText(message);
        intent.putExtra(EXTRA, message);
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
        Timber.i("----------onPause Called.----------");
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Timber.i("----------onDestroy Called.----------");
    }
    @Override
    public void onResume()
    {
        super.onResume();
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
        public void onClick(View v)
        {
            Timber.i("---------------------------Изменение видимости времени события------------------------");
            TextView name = findViewById(R.id.textView15);
            TextView name1 = findViewById(R.id.textView16);
            EditText start = findViewById(R.id.editTextTime2);
            EditText end = findViewById(R.id.editTextTime3);
            if(chipAction.isChecked() == true)
            {
                name.setVisibility(View.VISIBLE);
                name1.setVisibility(View.VISIBLE);
                start.setVisibility(View.VISIBLE);
                end.setVisibility(View.VISIBLE);

            }
            else
            {
                name.setVisibility(View.INVISIBLE);
                name1.setVisibility(View.INVISIBLE);
                start.setVisibility(View.INVISIBLE);
                end.setVisibility(View.INVISIBLE);
            }
        }
    public void returning(View view)
    {
        Intent intent = new Intent(this, Plans.class);
        Timber.i("---------------------------Возвращение на страницу распорядка------------------------");
        startActivity(intent);
    }
    public void GoNext(View view)
    {
        Intent intent = new Intent(this, Plans.class);
        EditText editText = findViewById(R.id.NameOfAction);
        String message_name = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message_name);
        EditText time = findViewById(R.id.editTextTime);
        String message_time = time.getText().toString();
        intent.putExtra(EXTRA_MESSAGE1,message_time);
        TextView editText1= findViewById(R.id.textView17);
        // Получае текст данного текстового поля
        String message = editText1.getText().toString();
        // Добавляем с помощью свойства putExtra объект - первый параметр - ключ,
        // второй параметр - значение этого объекта
        intent.putExtra(EXTRA, message);
        Timber.i("---------------------------Добавление пункта в распорядок------------------------");
        startActivity(intent);
    }
}