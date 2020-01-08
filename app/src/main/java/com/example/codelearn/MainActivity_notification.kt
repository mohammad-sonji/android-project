package com.example.codelearn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.codelearn.R
import com.example.codelearn.NotificationUtils
import java.util.*
import android.view.View

class MainActivity_notification : AppCompatActivity() {

    private val mNotificationTime = Calendar.getInstance().timeInMillis + 5000 //Set after 1 seconds from the current time.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_correct);
            NotificationUtils().setNotification(mNotificationTime, this@MainActivity_notification)

    }

    fun backbtn(view: View){
        finish()
    }
}
