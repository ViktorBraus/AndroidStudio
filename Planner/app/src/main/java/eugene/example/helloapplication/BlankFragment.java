package eugene.example.helloapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import timber.log.Timber;

public class BlankFragment extends Fragment {


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_blank, container, false);
                return view;
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
}