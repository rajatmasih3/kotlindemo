package com.ipe.demoapp.utils

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

interface DemoTwo{
    fun demoTwo()
}

class DemoTwoImplementation @Inject constructor() : DemoTwo{
    override fun demoTwo() {
        Log.i("DemoTwo ","running..")
    }
}

class MainTwo @Inject constructor(val demoTwo: DemoTwo){

    fun  demoTwoFunc(){
        Log.i("DemoTwo "," demoTwoFunction running..")
    }
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun providerMainTwo() : DemoTwo = DemoTwoImplementation()
}