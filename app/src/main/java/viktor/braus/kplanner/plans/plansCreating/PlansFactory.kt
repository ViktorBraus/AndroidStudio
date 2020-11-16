package viktor.braus.kplanner.plans.plansCreating

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import viktor.braus.kplanner.entity.PlansDAO

class PlansFactory(private val application: Application,
                   private val plansDAO: PlansDAO
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlansViewModel::class.java)) {
            return PlansViewModel(application,plansDAO) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}