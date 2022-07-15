package com.example.messenger.presentation

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.messenger.R
import com.rm.rmswitch.RMTristateSwitch


class Settings : Fragment() {

    private val KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX"
    private lateinit var rmTristateSwitch: RMTristateSwitch
    lateinit var languagebtn: TextView
    private lateinit var signout: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewout = inflater.inflate(R.layout.settings_items, container, false)
//        signout = viewout.findViewById(R.id.logout)

        rmTristateSwitch = viewout.findViewById(R.id.rmtheme)
        rmTristateSwitch.setSwitchToggleLeftDrawableRes(R.drawable.theme_auto)
        rmTristateSwitch.setSwitchToggleMiddleDrawableRes(R.drawable.theme_day)
        rmTristateSwitch.setSwitchToggleRightDrawableRes(R.drawable.theme_night)

//        languagebtn = viewout.findViewById(R.id.language)


        rmTristateSwitch.addSwitchObserver { _, state ->
            when (state) {
                RMTristateSwitch.STATE_LEFT -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    savePreferences(KEY_RADIOBUTTON_INDEX, 0)
                }
                RMTristateSwitch.STATE_MIDDLE -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    savePreferences(KEY_RADIOBUTTON_INDEX, 1)
                }
                RMTristateSwitch.STATE_RIGHT -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    savePreferences(KEY_RADIOBUTTON_INDEX, 2)
                }
            }
        }

        return viewout
    }

    private fun savePreferences(key: String, value: Int) {
        val sharedPreferences = this.activity?.getSharedPreferences(
            APP_PREFERENCES, MODE_PRIVATE
        )
        val editor = sharedPreferences?.edit()
        editor?.putInt(key, value)
        editor?.apply()
    }

    private fun loadPreferences() {
        val sharedPreferences = this.activity?.getSharedPreferences(
            APP_PREFERENCES, MODE_PRIVATE
        )
        val savedRadioIndex = sharedPreferences?.getInt(
            KEY_RADIOBUTTON_INDEX, 0
        )
        when (savedRadioIndex) {
            0 -> rmTristateSwitch.state = RMTristateSwitch.STATE_LEFT
            1 -> rmTristateSwitch.state = RMTristateSwitch.STATE_MIDDLE
            2 -> rmTristateSwitch.state = RMTristateSwitch.STATE_RIGHT


        }
    }

    companion object {
        const val APP_PREFERENCES = "theme"

    }


}