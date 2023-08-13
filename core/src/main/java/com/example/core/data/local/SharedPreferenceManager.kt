package com.example.core.data.local

import android.content.Context

class SharedPreferenceManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("playversePref", Context.MODE_PRIVATE)

    fun saveOnboardingState(){
        sharedPreferences.edit()
            .putString("done", "done")
            .apply()
    }

    fun getState(): String?{
        return sharedPreferences.getString("done", null)
    }
}