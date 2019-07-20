package com.techvista.assignment.base.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId,this, attachToRoot)
}

inline fun <reified T: Any> Activity.launchActivity(finishActivity: Boolean = true) {
    startActivity(Intent(this, T::class.java))
    if (finishActivity) { finish() }
}

inline fun <reified T: Any> Activity.launchActivityAddFlag() {
    val intent = Intent(this, T::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
    finish()
}

fun Context.toast(message: Any?) {
    Toast.makeText(this, "${message}", Toast.LENGTH_SHORT).show()
}

inline fun <reified T> SharedPreferences.put(key: String, value: T) {
    val editor = this.edit()

    when (T::class) {
        String::class -> editor.putString(key, value as String)
        Boolean::class -> editor.putBoolean(key, value as Boolean)
        Int::class -> editor.putInt(key, value as Int)
        Float::class -> editor.putFloat(key, value as Float)
        Long::class -> editor.putLong(key, value as Long)
        else -> "Not able to perform operation"
    }
    editor.apply()
}

inline fun <reified T> SharedPreferences.get(key: String, defaultValue: T): T {
    when(T::class) {
        String::class -> return this.getString(key, defaultValue as String) as T
        Boolean::class -> return this.getBoolean(key, defaultValue as Boolean) as T
        Int::class -> return this.getInt(key, defaultValue as Int) as T
        Float::class -> return this.getFloat(key, defaultValue as Float) as T
        Long::class -> return this.getLong(key, defaultValue as Long) as T
    }
    return defaultValue
}