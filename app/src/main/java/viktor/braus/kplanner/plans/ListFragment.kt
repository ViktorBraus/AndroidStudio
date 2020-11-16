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
import viktor.braus.kplanner.generated.callback.OnClickListener


class ListFragment : Fragment()
{

    private lateinit var viewModel: ListViewModel
    private lateinit var listFactory: ListFactory
    private lateinit var binding: ListFragmentBinding
    var i: Int = 0
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

        listFactory = ListFactory(ccontext)
        viewModel = ViewModelProvider(this, listFactory).get(ListViewModel::class.java)
        binding.listViewModel = viewModel
        i=viewModel.i
        binding.lifecycleOwner = this

        viewModel.showUser()
        return binding.root
    }
}