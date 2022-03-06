package com.example.otherapplication.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.example.otherapplication.aidl.IRemoteService

class A2Service : Service(){

    private val TAG: String = A2Service::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "-----onCreate2-----")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        Log.e(TAG, "-----onStartCommand2-----")

        return START_STICKY
    }

    var binder = MyBinder()
    inner class MyBinder : Binder() {
        fun getAService(): A2Service {
            Log.e(TAG, "-----MyBinder-getAService2-----")
            return this@A2Service
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
            return "-----from A2Service-----"
        }

    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.e(TAG, "-----onBind2-----")
        //return binder
        return romoteBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(TAG, "-----onUnbind2-----")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.e(TAG, "-----onDestroy2-----")
        super.onDestroy()
    }

}