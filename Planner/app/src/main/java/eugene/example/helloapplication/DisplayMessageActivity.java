package eugene.example.helloapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DisplayMessageActivity extends AppCompatActivity {
    public final static String EXTR;
    public final static String EXTRA;
    public final static String EXTRA_MESSAGE;
    public final static String EXTRA_MESSAGE1;
    //public String message1 = intent.getStringExtra(Schedule.EXTRA_MESSAGE);
    static {
        EXTR = "EXTRA_MESSAGE";
    }
    static {
        EXTRA = "EXTRA_MESSAGE";
    }
    static {
        EXTRA_MESSAGE = "EXTRA_MESSAGE1";
    }
    static {
        EXTRA_MESSAGE1 = "EXTRA_MESSAGE2";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        // Получаем сообщение из объекта intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTR);
        String message1 = intent.getStringExtra(Schedule.EXTRA_MESSAGE);
        String message2 = intent.getStringExtra(Schedule.EXTRA_MESSAGE1);
        String message3 = intent.getStringExtra(Schedule.EXTRA);
        // Создаем текстовое поле
        TextView User = findViewById(R.id.name);
        User.setTextSize(14);
        User.setText(message);

        TextView NameOfAction = findViewById(R.id.textView7);
        NameOfAction.setTextSize(14);
        NameOfAction.setText(message1);
        TextView TimeOfAction = findViewById(R.id.textView11);
        TimeOfAction.setTextSize(14);
        TimeOfAction.setText(message2);
        if(NameOfAction != null)
            User.setText(message3);
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
                Intent intent = new Intent(this, DisplayMessageActivity.class);
                startActivity(intent);
                return true;
            case R.id.about:
                intent = new Intent(this, About_activity.class);
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
                return true;
            case R.id.information:
                intent = new Intent(this, main_Information_about_program.class);
                startActivity(intent);
                return true;
            case R.id.exit:
                MainActivity.exit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void planning(View view)
    {
        Intent intent = new Intent(this, Schedule.class);
        TextView editText = findViewById(R.id.name);
        String message_name = editText.getText().toString();
        intent.putExtra(EXTRA,message_name);
        startActivity(intent);
    }
    public void BackWard(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}