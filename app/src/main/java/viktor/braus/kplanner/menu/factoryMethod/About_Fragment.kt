package viktor.braus.kplanner.menu.factoryMethod

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.databinding.AboutFragmentBinding

class About_Fragment : Fragment() {

    private lateinit var viewModel: AboutViewModel
    private lateinit var viewModelFactory: AboutViewModelFactory
    private lateinit var binding: AboutFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        binding= DataBindingUtil.inflate(
            inflater,
            R.layout.about_fragment,
            container,
            false
        )
        viewModelFactory = AboutViewModelFactory("First","Second","Third","Fourth")
        viewModel = ViewModelProvider(this, viewModelFactory)
                .get(AboutViewModel::class.java)
        binding.aboutViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.nameOfPhotos.observe(viewLifecycleOwner, Observer { p ->
                binding.First.text = viewModel.nameOfPhotos.value?.get(0) ?: ""
                binding.Second.text = viewModel.nameOfPhotos.value?.get(1) ?: ""
                binding.Third.text = viewModel.nameOfPhotos.value?.get(2) ?: ""
                binding.Fourth.text = viewModel.nameOfPhotos.value?.get(3) ?: ""
            })
        viewModel.eventAbout.observe(viewLifecycleOwner, Observer { playAgain ->
            if (playAgain)
            {
                TimerDzz()
                viewModel.run { count_of_click_Total() }
            }
        })
        return binding.root
    }
    fun TimerDzz()//event для таймера, когда он посчитает больше 20 сек
    {
        Toast.makeText(this.activity,"Кнопка была нажата ${viewModel.counter} раз!", Toast.LENGTH_SHORT).show()
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
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
}

