package com.aixue.titlebar

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleBar.setRightTextListener("gaga", object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("rendy", "hahaha=")
            }

        })
        titleBar.setTitleListener("title",object :View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("rendy", "title=")
            }

        })
        titleBar.setTitleColor(Color.BLACK)
        titleBar.setLeftClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("rendy", "" + System.currentTimeMillis())
                var intent = Intent()
                intent.setClass(this@MainActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }
}
