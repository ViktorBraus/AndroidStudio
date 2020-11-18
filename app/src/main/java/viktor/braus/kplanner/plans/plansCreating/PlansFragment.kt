package viktor.braus.kplanner.plans.plansCreating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import org.threeten.bp.LocalTime
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.databinding.PlansFragmentBinding
import viktor.braus.kplanner.entity.PlansDatabase
import viktor.braus.kplanner.mainPage.MainActivity


class PlansFragment : Fragment() {
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
        Timber.i("DDay: ${MainActivity.dayText}")
        var text: TextView = binding.nameEvent
        val application = requireNotNull(this.activity).application
        val dataSource = PlansDatabase.getInstance(application).plansDAO
        val plansFactory = PlansFactory(application, dataSource)
        val viewModel = ViewModelProvider(this, plansFactory).get(PlansViewModel::class.java)
        binding.plansviewmodel = viewModel

        binding.timeButton.setOnClickListener {
            val field1 = binding.nameEvent.text.toString()
            viewModel.update1(field1)
            val startTime = viewModel.selectedTime.value ?: LocalTime.of(0, 0)
            val startTimePicker = TimePickerDialog.newInstance({ _, hour, minute, _ ->
                val time = LocalTime.of(hour, minute)
                viewModel.setSelectedTime(time)
            }, startTime.hour, startTime.minute, true)
            fragmentManager?.let { it1 -> startTimePicker.show(it1, "Main Time Picker") }
        }
        binding.timeStartButton.setOnClickListener {
                val field1 = binding.nameEvent.text.toString()
                viewModel.update1(field1)
                val startTime = viewModel.selectedStartTime.value ?: LocalTime.of(0, 0)
                val startTimePicker = TimePickerDialog.newInstance({ _, hour, minute, _ ->
                    val time = LocalTime.of(hour, minute)
                    viewModel.setSelectedStartTime(time)
                }, startTime.hour, startTime.minute, true)
                fragmentManager?.let { it1 -> startTimePicker.show(it1, "Start Time Picker") }
        }
        binding.timeEndButton.setOnClickListener {
            if(viewModel.selectedStartTime.value.toString() == "00:00" && viewModel.selectedEndTime.value.toString() == "00:00" && !viewModel.counter)
            {
                Toast.makeText(this.activity, "Введіть будь ласка спочатку час початку події", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val field1 = binding.nameEvent.text.toString()
                viewModel.update1(field1)
                val startTime = viewModel.selectedEndTime.value ?: LocalTime.of(0, 0)
                val startTimePicker = TimePickerDialog.newInstance({ _, hour, minute, _ ->
                    val time = LocalTime.of(hour, minute)
                    viewModel.setSelectedEndTime(time)
                    if(viewModel.selectedStartTime.value?.hour!! <= viewModel.selectedEndTime.value?.hour!!)
                    {
                        if (viewModel.selectedStartTime.value?.minute!! < viewModel.selectedEndTime.value?.minute!!)
                            viewModel.setSelectedEndTime(time)
                        else {
                            Toast.makeText(this.activity, "Введіть будь ласка хвилини, більші за час початку події", Toast.LENGTH_SHORT).show()
                            viewModel.setSelectedEndTime(LocalTime.of(0, 0))
                        }
                    }
                    else
                    {
                        Toast.makeText(this.activity, "Введіть будь ласка час, більший за час початку події", Toast.LENGTH_SHORT).show()
                        viewModel.setSelectedEndTime(LocalTime.of(0,0))
                    }
                }, startTime.hour, startTime.minute, true)
                fragmentManager?.let { it1 -> startTimePicker.show(it1, "End Time Picker") }
            }
        }
        binding.accept.setOnClickListener {
            viewModel.onStartTracking()
        }
        viewModel.showSnackbar.observe(viewLifecycleOwner, Observer {
            if (it == true) { // Observed state is true.
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    getString(R.string.added_message),
                    Snackbar.LENGTH_LONG // How long to display the message.
                ).show()
                viewModel.doneShowingSnackbar()
            }
        })
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