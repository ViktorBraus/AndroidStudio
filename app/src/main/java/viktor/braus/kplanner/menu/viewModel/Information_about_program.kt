package viktor.braus.kplanner.menu.viewModel

import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.databinding.AboutProgramFragmentBinding

class Information_about_program() : Fragment(){
    private lateinit var viewModel: InformationViewModel
    private lateinit var binding: AboutProgramFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }
    override fun onStart() {
        super.onStart()
        Timber.i("----------(fragment) onStart Called.----------")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("----------(fragment) onPause Called.----------")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("----------(fragment) onDestroy Called.----------")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("----------(fragment) onResume Called.----------")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("----------(fragment) onStop Called.----------")
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(
                inflater,
                R.layout.about_program_fragment,
                container,
                false
        )
        //val rootView = inflater.inflate(R.layout.about_program_fragment, container, false)
        viewModel = ViewModelProvider(this).get(InformationViewModel::class.java)
        binding.informationViewModel = viewModel
        binding.setLifecycleOwner(this)
        viewModel.eventTimedzz.observe(viewLifecycleOwner, Observer { hasCounted->
            if(hasCounted)
                TimerDzz()
                })
        viewModel.eventBuzz.observe(viewLifecycleOwner, Observer { buzzType ->
            if (buzzType != InformationViewModel.BuzzType.NO_BUZZ) {
                buzz(buzzType.pattern)
                viewModel.onBuzzComplete()
            }
        })
        return binding.root
    }
    fun TimerDzz()//event для таймера, когда он посчитает больше 20 сек
    {
        Toast.makeText(this.activity,"Таймер посчитал 20!", Toast.LENGTH_SHORT).show()
        viewModel.timerCounted()
    }
    private fun buzz(pattern: LongArray) {
        val buzzer = activity?.getSystemService<Vibrator>()
        buzzer?.let {
            // Vibrate for 500 milliseconds
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                buzzer.vibrate(VibrationEffect.createWaveform(pattern, -1))
            } else {
                //deprecated in API 26
                buzzer.vibrate(pattern, -1)
            }
        }
    }
}