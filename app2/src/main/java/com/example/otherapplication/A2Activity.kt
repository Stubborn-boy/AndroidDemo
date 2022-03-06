package com.example.otherapplication

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.PersistableBundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.otherapplication.databinding.ActivityABinding
import com.example.otherapplication.service.A2Service


class A2Activity : AppCompatActivity () {
    private val TAG: String = A2Activity::class.java.simpleName
    private lateinit var binding : ActivityABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "-----onCreate-----")

        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, BActivity::class.java)
            startActivity(intent)
        }
        binding.textview.setOnClickListener {
            val intent = Intent(this, CActivity::class.java)
            startActivity(intent)
        }
        binding.viewGroup.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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