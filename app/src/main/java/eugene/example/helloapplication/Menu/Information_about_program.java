package eugene.example.helloapplication.Menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import eugene.example.helloapplication.R;
import timber.log.Timber;


public class Information_about_program extends Fragment {
    public AboutViewModel viewModel;
    public String UserName;
    public Information_about_program(String name)
    {
        UserName = name;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onStart()
    {
        super.onStart();
        Timber.i("----------(fragment) onStart Called.----------");
    }
    @Override
    public void onPause()
    {
        super.onPause();
        Timber.i("----------(fragment) onPause Called.----------");
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Timber.i("----------(fragment) onDestroy Called.----------");
    }
    @Override
    public void onResume()
    {
        super.onResume();
        Timber.i("----------(fragment) onResume Called.----------");
    }
    @Override
    public void onStop()
    {
        super.onStop();
        Timber.i("----------(fragment) onStop Called.----------");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        @SuppressLint("InflateParams") View v = inflater.inflate(R.layout.about_program_fragment, null);
        Button button = v.findViewById(R.id.button13);
        final TextView t = v.findViewById(R.id.textView22);
        button.setOnClickListener(new View.OnClickListener()
                {
                    @SuppressLint("SetTextI18n")
                    public void onClick(View v) {
                        t.setText(UserName);
                   }
               });
                return v;
    }
}