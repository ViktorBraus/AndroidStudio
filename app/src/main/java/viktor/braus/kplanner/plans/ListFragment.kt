package viktor.braus.kplanner.plans

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.databinding.ListFragmentBinding


class ListFragment : Fragment()
{

    private lateinit var viewModel: ListViewModel
    private lateinit var listFactory: ListFactory
    private lateinit var binding: ListFragmentBinding
    var ccontext: Context = ListOfPlans.ccontext
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?
    {
        binding= DataBindingUtil.inflate(
                inflater,
                R.layout.list_fragment,
                container,
                false
        )
        var button1: Button = binding.mondayButton
        var button2: Button = binding.tuesdayButton
        var button3: Button = binding.wednesdayButton
        var button4: Button = binding.thursdayButton
        var button5: Button = binding.fridayButton
        var button6: Button = binding.saturdayButton
        var button7: Button = binding.sundayButton

        button1.setOnClickListener{
            viewModel.setCount(1)
            Timber.i("kfhjkfkjfhkjfjhkf${viewModel.count}")
            viewModel.planning(view)
        }
        button2.setOnClickListener{
            viewModel.setCount(2)
        }
        button3.setOnClickListener{
            viewModel.setCount(3)
        }
        button4.setOnClickListener{
            viewModel.setCount(4)
        }
        button5.setOnClickListener{
            viewModel.setCount(5)
        }
        button6.setOnClickListener{
            viewModel.setCount(6)
        }
        button7.setOnClickListener{
            viewModel.setCount(7)
        }
        listFactory = ListFactory(ccontext)
        viewModel = ViewModelProvider(this, listFactory).get(ListViewModel::class.java)
        binding.listViewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.showUser()
        return binding.root
    }

}