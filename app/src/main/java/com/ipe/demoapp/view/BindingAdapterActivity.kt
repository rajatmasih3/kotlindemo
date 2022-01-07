package com.ipe.demoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ipe.demoapp.R
import com.ipe.demoapp.databinding.ActivityBindingAdapterBinding
import com.ipe.demoapp.viewModel.BindingAdapterViewModel

class BindingAdapterActivity : AppCompatActivity() {
    lateinit var binding   : ActivityBindingAdapterBinding
    lateinit var viewModel : BindingAdapterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_binding_adapter)
        viewModel = ViewModelProvider(this).get(BindingAdapterViewModel::class.java)
        binding.viewModel = viewModel


    }
}