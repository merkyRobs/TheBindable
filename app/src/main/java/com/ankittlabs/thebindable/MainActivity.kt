package com.ankittlabs.thebindable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.ankittlabs.thebindable.databinding.ActivityMainBinding
import com.ankittlabs.thebindable.model.User

const val EXTRA_MESSAGE: String = "com.ankittlabs.thebindable.MAININTENT"

class MainActivity : AppCompatActivity() {

    private var user_name: String? = null
    private var user_number: Int? = null
    private var actionBar: ActionBar? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbar)
        actionBar?.title = getString(R.string.app_name)

        //onClick
        binding.buttonSubmit.setOnClickListener {
            user_name = binding.editName.text.toString()
            user_number = binding.editNumber.text.toString().toInt()

            val user = User(user_name!!, user_number!!)
            val intent = Intent(this, DisplayActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, user)
            }
            startActivity(intent)
        }
    }
}
