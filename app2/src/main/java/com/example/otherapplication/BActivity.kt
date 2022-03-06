package com.example.otherapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.otherapplication.databinding.ActivityBBinding

class BActivity : AppCompatActivity () {

    private val TAG: String = BActivity::class.java.simpleName
    lateinit var binding: ActivityBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var intent = Intent(this, CActivity::class.java)
            startActivity(intent)
        }
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