package viktor.braus.kplanner.mainPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import viktor.braus.kplanner.R
import viktor.braus.kplanner.databinding.MainFragmentBinding

class MainFragment : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val binding: MainFragmentBinding =  DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )

        binding.lifecycleOwner = this
        return binding.root
    }
}