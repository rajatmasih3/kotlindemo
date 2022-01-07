package com.ipe.demoapp.view
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ipe.demoapp.R
import com.ipe.demoapp.databinding.ActivityMainBinding
import com.ipe.demoapp.utils.*
import dagger.Module
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var computer: Computer
    @Inject lateinit var demoTwo: DemoTwo
    @Inject lateinit var mainTwo: MainTwo
    @Inject lateinit var test: Test

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil. setContentView(this,R.layout.activity_main)
        //ViewModelProvider(this).get(MainViewModel::class.java)

        binding.retrofit.setOnClickListener {
            startActivity(Intent(this, RetrofitActivity::class.java))
        }

        binding.bindingAdapter.setOnClickListener {
            startActivity(Intent(this, BindingAdapterActivity::class.java))
        }
        binding.gps.setOnClickListener {
            startActivity(Intent(this,MapsActivity::class.java))
        }

        computer.getComputer()

        demoTwo.demoTwo()
        mainTwo.demoTwoFunc()
        test.getName()


    }

    companion object{
        val F_NAME = "RAJIV"
        val L_NAME = "KUMAR"
    }
}

