package com.example.practical2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            CalculateBMI()
        }
        buttonReset.setOnClickListener(){
            editTextHeigth.text = null
            editTextWeight.text = null
            imageViewProfilePicture.setImageResource(R.drawable.empty)
            TextViewBmi.text = null
        }
    }
    private fun CalculateBMI(){
        if(editTextWeight.text.isEmpty()){
            editTextWeight.setError(getString(R.string.input_error))
            return // stop the function
        }
        if(editTextHeigth.text.isEmpty()){
            editTextHeigth.setError(getString(R.string.input_error))
            return // stop the function
        }
        val weight = editTextWeight.text.toString().toFloat()
        val height = editTextHeigth.text.toString().toFloat()
        val bmi = weight / (height/100).pow(2)

        if(bmi<18.5){
            TextViewBmi.text = String.format("%s %.2f (%s)",getString(R.string.bmi), bmi, getString(R.string.under))
            imageViewProfilePicture.setImageResource(R.drawable.under)
        }
        else if (bmi in 18.5 .. 24.9){
            TextViewBmi.text = String.format("%s %.2f (%s)",getString(R.string.bmi), bmi, getString(R.string.normal))
            imageViewProfilePicture.setImageResource(R.drawable.normal)
        }
        else if (bmi>25){
            TextViewBmi.text = String.format("%s %.2f (%s)",getString(R.string.bmi), bmi, getString(R.string.over))
            imageViewProfilePicture.setImageResource(R.drawable.over)
        }
    }
}
