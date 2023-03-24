package com.ipe.demoapp.view


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.ipe.demoapp.R
import com.ipe.demoapp.databinding.ActivityRetrofitBinding
import com.ipe.demoapp.viewModel.RetrofitViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class RetrofitActivity : AppCompatActivity() {
    lateinit var binding : ActivityRetrofitBinding
    lateinit var viewModel : RetrofitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


         binding = DataBindingUtil.setContentView(this,R.layout.activity_retrofit)
        viewModel = ViewModelProvider(this).get(RetrofitViewModel::class.java)
        viewModel.getData()

        binding.btn.text = viewModel.count.toString()
        binding.btn.setOnClickListener {
           /* viewModel.increaseValue()
            binding.btn.text = viewModel.count.toString()*/

            MaterialAlertDialogBuilder(this)
                .setMessage(resources.getString(R.string.app_name))
                .setNegativeButton("OKAY") { dialog, which ->
                    // Respond to negative button press
                    dialog.dismiss()
                }
                .setPositiveButton("CANCEL") { dialog, which ->
                    // Respond to positive button press
                    dialog.dismiss()
                }
                .show()
        }

         viewModel._posts().observe(this)
         {
             viewModel.viewModelScope.launch {
                 it.forEach {
                     delay(500)
                     binding.text.text = "Id ${it.id} \n Title ${it.title}"
                 }
             }

         }
        Log.i("Retrofit ","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Retrofit ","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Retrofit ","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Retrofit ","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Retrofit ","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Retrofit ","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Retrofit ","onRestart")
    }
}