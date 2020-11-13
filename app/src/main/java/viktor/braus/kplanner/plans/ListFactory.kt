package viktor.braus.kplanner.plans

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ListFactory(private val context: Context) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}