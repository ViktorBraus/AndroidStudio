package eugene.example.helloapplication.Menu;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class Information_ViewModel extends ViewModel
{
    String UserName;
    Information_ViewModel(String name)
    {
        UserName = name;
        Log.i("Informationa_ViewModel","Name of User is $Username");
    }
}
