package com.ipe.demoapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BindingAdapterViewModel : ViewModel() {
     val imageUrl : MutableLiveData<String> by lazy {
        MutableLiveData<String>("https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg")
    }
   // fun getImageUrl() : LiveData<String> = imageUrl
}