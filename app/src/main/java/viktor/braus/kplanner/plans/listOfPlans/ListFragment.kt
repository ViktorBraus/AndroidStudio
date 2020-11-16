package viktor.braus.kplanner.plans.listOfPlans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.databinding.ListFragmentBinding
import viktor.braus.kplanner.entity.PlansDatabase

class ListFragment : Fragment()
{

    override fun onStart() {
        super.onStart()
        Timber.i("----------onStart Called.----------")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("----------onStart Called.----------")
    }
    override fun onPause() {
        super.onPause()
        Timber.i("----------onPause Called.----------")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("----------onResume Called.----------")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("----------onStop Called.----------")
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?
    {
        val binding: ListFragmentBinding =  DataBindingUtil.inflate(
                inflater,
                R.layout.list_fragment,
                container,
                false
        )
        val application = requireNotNull(this.activity).application
        val dataSource = PlansDatabase.getInstance(application).plansDAO
        val listFactory = ListFactory(application,dataSource)
        val viewModel = ViewModelProvider(this, listFactory).get(ListViewModel::class.java)

        binding.listViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.showUser()
        return binding.root
    }

}