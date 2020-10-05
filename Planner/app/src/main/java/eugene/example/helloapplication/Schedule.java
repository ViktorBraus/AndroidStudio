package eugene.example.helloapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class Schedule extends AppCompatActivity
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
    private CheckBox chipChoice;
    private CheckBox chipEntry;
    private CheckBox chipFilter;
    private CheckBox chipCustom;
    private EditText editTextLog;
    private Button buttonClear;
    private View.OnClickListener clickListener;
    private View.OnClickListener closeIconClickListener;
    private CompoundButton.OnCheckedChangeListener checkedChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        this.chipAction = (CheckBox) this.findViewById(R.id.checkBox);
        String message = intent.getStringExtra(DisplayMessageActivity.EXTRA);
        TextView User = findViewById(R.id.textView17);
        User.setTextSize(14);
        User.setText(message);
        intent.putExtra(EXTRA, message);
    }

        public void onClick(View v)
        {
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

            } else
            {
                name.setVisibility(View.INVISIBLE);
                name1.setVisibility(View.INVISIBLE);
                start.setVisibility(View.INVISIBLE);
                end.setVisibility(View.INVISIBLE);
            }
        }
    public void returning(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
    public void GoNext(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
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
        startActivity(intent);
    }
}