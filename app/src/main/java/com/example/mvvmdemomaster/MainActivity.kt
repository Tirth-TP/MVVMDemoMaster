package com.example.mvvmdemomaster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmdemomaster.utils.addReplaceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addReplaceFragment(ShowDataFragment(),
            addFragment = true,
            backAllow = true,
            frameLayout = R.id.frameLayout
        )

    }
}