package viktor.braus.kplanner.menu.factoryMethod

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AboutViewModelFactory(private val a: String,private val b: String,private val c: String,private val d: String, ) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AboutViewModel::class.java)) {
            return AboutViewModel(a,b,c,d) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}