package viktor.braus.kplanner.menu.factoryMethod

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class AboutViewModel(a:String,b:String,c:String,d:String) : ViewModel()
{
    var counter: Int = 0
    private var cd: Array<String> = arrayOf(a,b,c,d)
    private var cdq = MutableLiveData<String>()
            val _cdq : LiveData<String>
            get()=cdq
    private var _eventAbout = MutableLiveData<Boolean>()
    val eventAbout: LiveData<Boolean>
        get()=_eventAbout
    private var _nameOfPhotos = MutableLiveData<Array<String>>()
    val nameOfPhotos: LiveData<Array<String>>
        get()=_nameOfPhotos
    init {
        _nameOfPhotos.value=cd
    }
    fun Count_of_Click() : String
    {
        counter++
        if(counter<10)
        {
            _nameOfPhotos.value = arrayOf("First", "Second", "Third", "Fourth")
            return _nameOfPhotos.value.toString()
        }
        else
        {
            _nameOfPhotos.value = arrayOf("Fourth", "Third", "Second", "First")
            _eventAbout.value = true
            counter = 0
            return _nameOfPhotos.value.toString()
        }

    }

    fun count_of_click_Total()
    {
        _eventAbout.value = false
    }
}