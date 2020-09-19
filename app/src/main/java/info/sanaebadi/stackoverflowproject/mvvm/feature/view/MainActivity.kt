package info.sanaebadi.stackoverflowproject.mvvm.feature.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import info.sanaebadi.stackoverflowproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}