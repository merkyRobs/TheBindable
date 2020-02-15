package com.ankittlabs.thebindable

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ankittlabs.thebindable.databinding.ActivityDisplayBinding
import com.ankittlabs.thebindable.model.User

class DisplayActivity:AppCompatActivity(){

    private lateinit var displayBinding: ActivityDisplayBinding
    private var textNameDisplay:TextView?=null
    private var textNumberDisplay:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Binding Call
        displayBinding = ActivityDisplayBinding.inflate(layoutInflater)
        val view = displayBinding.root
        setContentView(view)
        setSupportActionBar(displayBinding.toolbarDisplay)
        actionBar?.title = getString(R.string.display_name)

        val message = intent.getParcelableExtra<User>(EXTRA_MESSAGE)

        //binding data
        displayBinding.textNameDisplay.text= message?.userName
        displayBinding.textNumber.text=message?.userId.toString()
    }
}