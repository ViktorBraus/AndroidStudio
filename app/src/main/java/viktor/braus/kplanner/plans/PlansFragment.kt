package viktor.braus.kplanner.plans

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.mainPage.MainActivity

class PlansFragment : Fragment() {

    private lateinit var viewModel: PlansViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.plans_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlansViewModel::class.java)
        // TODO: Use the ViewModel
    }
}