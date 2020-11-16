package viktor.braus.kplanner.plans.listOfPlans

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import viktor.braus.kplanner.entity.PlansDAO

class ListFactory(private val application: Application,
                  private val plansDAO: PlansDAO
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(application,plansDAO) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}