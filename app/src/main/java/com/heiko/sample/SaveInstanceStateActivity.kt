package com.heiko.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.heiko.sample.databinding.ActivityMainBinding


class SaveInstanceStateActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "Z-MainActivity"
        private const val KEY_NAME = "KEY_NAME"
    }

    private lateinit var binding: ActivityMainBinding
    private var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        name = savedInstanceState?.getString(KEY_NAME) ?: ""
        Log.i(TAG, "onCreate:$savedInstanceState")
        Log.i(TAG, "onCreate name:$name")

        binding.btnSave.setOnClickListener {
            name = "Hahaha"
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState:$savedInstanceState")
        name = savedInstanceState?.getString(KEY_NAME) ?: ""
        Log.i(TAG, "onRestoreInstanceState name:$name")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (!TextUtils.isEmpty(name)) {
            outState.putString(KEY_NAME, name)
        }
        Log.i(TAG, "onSaveInstanceState:$outState")
        Log.i(TAG, "onSaveInstanceState name:$name")
    }
}