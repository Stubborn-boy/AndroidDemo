package com.example.myapplication

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.PersistableBundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityABinding
import com.example.myapplication.service.AService
import com.example.otherapplication.aidl.IRemoteService


class AActivity : AppCompatActivity () {
    private val TAG: String = AActivity::class.java.simpleName
    private lateinit var binding : ActivityABinding


    var mRemoteService : IRemoteService? = null
    var mRemoteServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            mRemoteService = IRemoteService.Stub.asInterface(p1)
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            mRemoteService = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "-----onCreate-----")

        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent = Intent(this, AService::class.java)
        var myBinder: AService.MyBinder? = null
        var serviceConnection = object : ServiceConnection {
            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                myBinder = p1 as AService.MyBinder
            }

            override fun onServiceDisconnected(p0: ComponentName?) {
                myBinder = null
            }
        }

        var mRemoteIntent = Intent()
        //mRemoteIntent.setAction("com.example.otherapplication.service.A2Service")
        //mRemoteIntent.setPackage("com.example.otherapplication")
//        mRemoteIntent.setClassName("com.example.otherapplication",
//            "com.example.otherapplication.service.A2Service")
//        mRemoteIntent.setComponent(ComponentName("com.example.otherapplication",
//            "com.example.otherapplication.service.A2Service"))

        binding.button.setOnClickListener {
//            val intent = Intent(this, BActivity::class.java)
//            startActivity(intent)
//            startService(intent)
//            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
//                startForegroundService(serviceIntent)
//            }else {
//                startService(serviceIntent)
//            }
            //bindService(intent, serviceConnection, BIND_AUTO_CREATE)
            bindService(mRemoteIntent, mRemoteServiceConnection, BIND_AUTO_CREATE)
        }
        binding.textview.setOnClickListener {
//            val intent = Intent(this, CActivity::class.java)
//            startActivity(intent)
            //stopService(intent)
            //stopService(serviceIntent)
            //unbindService(serviceConnection)
            unbindService(mRemoteServiceConnection)
        }
        binding.viewGroup.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            //myBinder?.getAService()
            mRemoteService?.let {
                Log.e(TAG, it.text)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.e(TAG, "-----onCreate-State-----")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "-----onStart-----")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "-----onRestart-----")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "-----onResume-----")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "-----onPause-----")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "-----onStop-----")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "-----onDestroy-----")
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                Log.e(TAG, "-----DOWN-----")
            }
            MotionEvent.ACTION_MOVE -> {
                Log.e(TAG, "-----MOVE-----")
            }
            MotionEvent.ACTION_UP -> {
                Log.e(TAG, "-----UP-----")
            }
            MotionEvent.ACTION_CANCEL -> {
                Log.e(TAG, "-----CANCEL-----")
            }
        }
        var consume = super.dispatchTouchEvent(event)
        Log.e(TAG, "-----$consume-----")
        return consume
    }

}