package viktor.braus.kplanner.plans

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PlansFactory(private val context: Context) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlansViewModel::class.java)) {
            return PlansViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}