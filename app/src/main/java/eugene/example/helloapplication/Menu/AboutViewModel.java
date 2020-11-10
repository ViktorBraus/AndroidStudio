package eugene.example.helloapplication.Menu;

import android.util.Log;
import androidx.lifecycle.ViewModel;

public class AboutViewModel extends ViewModel
{
    public AboutViewModel()
    {
        Log.i("AboutViewModel","AboutViewModel created!");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("AboutViewModel","AboutViewModel destroyed!");
    }
}
