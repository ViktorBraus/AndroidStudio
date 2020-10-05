package eugene.example.helloapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


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