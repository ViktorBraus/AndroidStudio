package eugene.example.helloapplication.Menu;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class InformationViewModelFactory implements ViewModelProvider.Factory {
    String UserName;
    InformationViewModelFactory(String name)
    {
        UserName = name;
    }
    @Override
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass)
    {
        if(modelClass.isAssignableFrom(Information_ViewModel.class))
        {
            return (T) new Information_ViewModel(UserName);
        }
            throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
