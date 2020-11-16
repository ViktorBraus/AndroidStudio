package viktor.braus.kplanner.plans.plansCreating

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.databinding.PlansFragmentBinding
import viktor.braus.kplanner.entity.PlansDatabase
import java.util.*

class PlansFragment : Fragment(){
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding: PlansFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.plans_fragment,
                container,
                false
        )
        val application = requireNotNull(this.activity).application
        val dataSource = PlansDatabase.getInstance(application).plansDAO
        val plansFactory = PlansFactory(application,dataSource)
        val viewModel = ViewModelProvider(this,plansFactory).get(PlansViewModel::class.java)

        binding.plansviewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }
    public override fun onStart() {
        super.onStart()
        Timber.i("----------onStart Called.----------")
    }

    public override fun onPause() {
        super.onPause()
        Timber.i("----------onPause Called.----------")
    }

    /*public override fun onDestroy() {
        super.onDestroy()
        Timber.i("----------onDestroy Called.----------")
    }*/

    public override fun onResume() {
        super.onResume()
        Timber.i("----------onResume Called.----------")
    }

    public override fun onStop() {
        super.onStop()
        Timber.i("----------onStop Called.----------")
    }
}