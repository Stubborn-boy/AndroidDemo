package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityCBinding

class CActivity : AppCompatActivity () {

    private val TAG: String = CActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : ActivityCBinding = ActivityCBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e(TAG, "-----onCreate-----")
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

}