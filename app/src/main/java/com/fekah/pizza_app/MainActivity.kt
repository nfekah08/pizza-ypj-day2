package com.fekah.pizza_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//import com.example.myapplication.databinding.ActivityMainBinding
import com.fekah.pizza_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button.setOnClickListener {

            var pizaSizeprice = 0.0
            var toppingsTotal = 0.0

            when{
                binding.smallRadioBtn.isChecked -> pizaSizeprice = 5.0
                binding.mediumRadioBtn.isChecked -> pizaSizeprice = 7.0
                binding.largeRadioBtn.isChecked -> pizaSizeprice = 9.0
            }

            if(binding.onionsBox.isChecked) {
                toppingsTotal +=1
            }
            if(binding.olivesBox.isChecked) {
                toppingsTotal +=2
            }
            if(binding.tomatoesBox.isChecked) {
                toppingsTotal +=3
            }

            binding.totalTextView.text = "Total order Price = RM ${pizaSizeprice + toppingsTotal}"

        }
    }
}