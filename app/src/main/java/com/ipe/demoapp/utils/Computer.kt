package com.ipe.demoapp.utils

import android.util.Log
import javax.inject.Inject

class Computer @Inject constructor(val ram: Ram,val hardDisk: HardDisk){

    fun getComputer(){
        ram.getRam()
        hardDisk.getHardDisk()
        Log.i("Computer ","getComputer()")
    }
}
// when use inject then val computer = Computer()

class Ram @Inject constructor(){

    fun getRam(){
        Log.i("Computer ","getRam()")
    }
}

class HardDisk @Inject constructor(){

    fun getHardDisk(){
        Log.i("Computer ","getHardDisk()")
    }
}




