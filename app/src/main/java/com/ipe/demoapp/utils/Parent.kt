package com.ipe.demoapp.utils

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class Parent @Inject constructor(val child: Child){

    fun getParentInfo(){
        Log.i("ParentInfo "," Parent")
        child.getChild()
        child.subChild.getSubChild()
    }
}

class Child @Inject constructor(val subChild: SubChild){
    fun getChild(){
        Log.i("ChildInfo "," Child")
    }
}

class SubChild @Inject constructor(){
    fun getSubChild(){
        Log.i("SubChild"," SubChild")
    }
}

