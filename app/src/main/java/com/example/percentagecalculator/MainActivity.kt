package com.example.percentagecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.example.percentagecalculator.databinding.ActivityMainBinding
import com.example.percentagecalculator.viewmodel.PercentageCalViewModel
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel : PercentageCalViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val percentageTextView : TextView = binding.percentage

        val btn : Button = binding.calBtn

        btn.setOnClickListener {

            val marks_obtained = binding.marksObtained.text.toString().toDoubleOrNull()
            val out_of = binding.totalMarks.text.toString().toDoubleOrNull()

            if(marks_obtained == null || out_of == null  || marks_obtained > out_of ){
                percentageTextView.text = "0.0%"
                return@setOnClickListener
            }

            val percentage = calPercentage(marks_obtained,out_of)
            percentageTextView.text = "$percentage %"

        }


    }

    private fun calPercentage(marksObt : Double, outOff : Double): Double{
        val percentage = (marksObt / outOff) * 100
        return percentage
    }
}