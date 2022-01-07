package com.ipe.demoapp.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.ipe.demoapp.view.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

class Test @Inject constructor(@FName val fName : String, @LName val lName :  String, @ActivityContext val app : Context)
{
    fun getName(){
        Log.i("Test ","$fName $lName")
        Toast.makeText(app,"$fName $lName",Toast.LENGTH_LONG).show()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object TestModules{

    @Provides
    @FName
    fun provideFname() = MainActivity.F_NAME
    @Provides
    @LName
    fun provideLname() = MainActivity.L_NAME

}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LName
