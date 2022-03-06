package com.example.otherapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.otherapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG: String = MainActivity::class.java.simpleName
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var intent = Intent(this, A2Activity::class.java)
            startActivity(intent)
        }
        Log.e(TAG, "-----onCreate-----")
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

}