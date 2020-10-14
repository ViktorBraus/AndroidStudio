package eugene.example.helloapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class main_Information_about_program extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__information_about_program);
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
}