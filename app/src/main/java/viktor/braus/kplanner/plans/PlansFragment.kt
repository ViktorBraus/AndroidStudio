package viktor.braus.kplanner.plans

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.databinding.PlansFragmentBinding

class PlansFragment : Fragment(){

    private lateinit var viewModel : PlansViewModel
    private lateinit var plansFactory: PlansFactory
    private lateinit var binding:  PlansFragmentBinding
    var ccontext: Context = PlansCreating.ccontext
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(
                inflater,
                R.layout.plans_fragment,
                container,
                false
        )
        val button1: Button = binding.timeButton
        val button2: Button = binding.timeStartButton
        val button3: Button = binding.timeEndButton
        button1.setOnClickListener{
            Timber.i("aazz")
            viewModel.setCount(2)
        }
        button2.setOnClickListener{
            Timber.i("aazz")
            viewModel.setCount(2)
        }
        button3.setOnClickListener{
            Timber.i("vvff")
            viewModel.setCount(3)
        }
        plansFactory = PlansFactory(ccontext)
        viewModel = ViewModelProvider(this,plansFactory).get(PlansViewModel::class.java)
        binding.plansviewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}