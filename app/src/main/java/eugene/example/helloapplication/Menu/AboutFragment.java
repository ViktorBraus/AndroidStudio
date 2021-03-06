package eugene.example.helloapplication.Menu;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import eugene.example.helloapplication.R;
import timber.log.Timber;

public class AboutFragment extends Fragment {

        AboutViewModel viewModel;
        InformationViewModelFactory v;
        public AboutFragment()
        {

        }
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                setHasOptionsMenu(true);
                Timber.i("onCreate called");
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {
                View view = inflater.inflate(R.layout.about_fragment, container, false);
                Log.i("AboutFragment","Called ViewModelProviders.of");
                v = new InformationViewModelFactory("dd");
                //viewModel = ViewModelProviders.of(this,v).get(AboutFragment.class);
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