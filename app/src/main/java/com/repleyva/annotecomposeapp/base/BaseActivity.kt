package com.repleyva.annotecomposeapp.base

import android.content.Intent
import androidx.activity.ComponentActivity
import com.repleyva.annotecomposeapp.model.StartActivityEvent

abstract class BaseActivity : ComponentActivity() {

    fun startActivity(startActivityEvent: StartActivityEvent) {
        with(startActivityEvent) {
            val intent = Intent(this@BaseActivity, startActivityEvent.activity)
            bundle?.let { intent.putExtras(it) }
            intent.flags = flag
            if (code == 0) startActivity(intent)
            else startActivityForResult(intent, code)
        }
    }

}