package sample.jeff.com.presentation.commons

import android.content.Context

import sample.jeff.com.presentation.dagger.dagger_modules.SharedPrefsHelper

/**
 * Created by jaffer on 23/10/17.
 */

class DataManager(private val context: Context,
                  private val sharedPrefsHelper: SharedPrefsHelper) : IPreferences {

    /*fun putValue(key: String, value: Any) {
        if (value is String) {
            mSharedPrefsHelper.put(key, value)
        } else if (value is Boolean) {
            mSharedPrefsHelper.put(key, value)
        } else if (value is Int) {
            mSharedPrefsHelper.put(key, value)
        } else if (value is Long) {
            mSharedPrefsHelper.put(key, value.toFloat())
        } else if (value is Float) {
            mSharedPrefsHelper.put(key, value)
        }
    }

    fun getString(key: String): String? {
        return mSharedPrefsHelper[key, ""]
    }

    fun getFloat(key: String): Float? {
        return mSharedPrefsHelper[key, 0f]
    }

    fun getBoolean(key: String): Boolean? {
        return mSharedPrefsHelper[key, false]
    }


    fun getInt(key: String): Int? {
        return mSharedPrefsHelper[key, 0]
    }

    fun clear() {
        mSharedPrefsHelper.deleteAllSavedData()
    }

    fun deleteData(key: String) {
        mSharedPrefsHelper.deleteSavedData(key)
    }*/

    override fun setString(key: String, value: String) {
        sharedPrefsHelper.put(key, value)
    }
}