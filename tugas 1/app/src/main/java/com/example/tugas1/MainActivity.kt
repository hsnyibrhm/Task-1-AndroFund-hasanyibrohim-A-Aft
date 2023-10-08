package com.example.tugas1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.tugas1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var t: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        t = findViewById(R.id.Tmain)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.p.setOnClickListener {
            replacefragment(Fragment())
        }

        val username: String? = intent.getParcelableExtra<User>("User")?.username
        val password: String? = intent.getParcelableExtra<User>("User")?.password
        t.text = "username: $username dan password: $password"

    }

    private fun replacefragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frag, fragment)
        fragmentTransaction.commit()

    }
}