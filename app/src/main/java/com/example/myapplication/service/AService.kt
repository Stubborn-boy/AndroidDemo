package com.example.myapplication.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.example.otherapplication.aidl.IRemoteService

class AService : Service(){

    private val TAG: String = AService::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "-----onCreate-----")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        Log.e(TAG, "-----onStartCommand-----")

        return START_STICKY
    }

    var binder = MyBinder()
    inner class MyBinder : Binder() {
        fun getAService(): AService {
            Log.e(TAG, "-----MyBinder-getAService-----")
            return this@AService
        }
    }

    private var romoteBinder = object : IRemoteService.Stub(){
        override fun basicTypes(
            anInt: Int,
            aLong: Long,
            aBoolean: Boolean,
            aFloat: Float,
            aDouble: Double,
            aString: String?
        ) {

        }

        override fun getText(): String {
            return "-----from AService-----"
        }

    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.e(TAG, "-----onBind-----")
        //return binder
        return romoteBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(TAG, "-----onUnbind-----")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.e(TAG, "-----onDestroy-----")
        super.onDestroy()
    }

}