package comsirojiddinovgaybullo.exam

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import comsirojiddinovgaybullo.core.di.module.Data.RecData.HomeData
import comsirojiddinovgaybullo.core.di.module.Data.UserData.NoteDao
import comsirojiddinovgaybullo.core.di.module.Data.UserData.NoteItem
import comsirojiddinovgaybullo.core.di.module.Data.UserData.RoomModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(var noteDao: NoteDao) : ViewModel() {


    val homeListLiveData = MutableLiveData<ArrayList<HomeData>>()
    val dictionaryListLiveData = MutableLiveData<List<NoteItem>>()
    val alldata = MutableLiveData<List<NoteItem>>()

    fun homeList(data: ArrayList<HomeData>) {
        CoroutineScope(Dispatchers.IO).launch {
            homeListLiveData.postValue(data)
        }
    }

    fun getAllData(){

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = noteDao.getAll()
                alldata.postValue(response)
            }catch (e:java.lang.Exception){
                print("###eror->${e.message}")
            }
        }
    }
    fun delete(data: NoteItem){
        noteDao.deleteNote(data)
    }

    fun dictionaryList(data:NoteItem) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                noteDao.addNote(data)
                val response = noteDao.getAll()
                dictionaryListLiveData.postValue(response)
            }catch (e:java.lang.Exception){
                print("###eror->${e.message}")
            }
        }
    }


    override fun onCleared() {
        Log.d("MainViewModelTAG", "onCleared: ")
        super.onCleared()
    }
}