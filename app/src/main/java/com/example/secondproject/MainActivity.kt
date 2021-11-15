package com.example.secondproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var checkBox:CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.yourname)
        val regno = findViewById<EditText>(R.id.regno)
        val email = findViewById<EditText>(R.id.youremail)
        val radio = findViewById<RadioGroup>(R.id.radio)
        val not = findViewById<RadioButton>(R.id.not)
        val one = findViewById<RadioButton>(R.id.one)
        val fully = findViewById<RadioButton>(R.id.fully)
        checkBox =findViewById(R.id.checkbox)
        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener{

            Toast.makeText(this , "Your response is submitted" , Toast.LENGTH_SHORT).show()

            radio.clearCheck()
            name.setText("")
            email.setText("")
            regno.setText("")

            if(checkBox.isChecked)
                checkBox.toggle()

        }

        checkBox.setOnClickListener(this)

        radio.setOnCheckedChangeListener{ _, id ->
            val rb = findViewById<RadioButton>(id)
            when(rb){
                not->
                    Toast.makeText(this , "Not vaccinated" , Toast.LENGTH_SHORT).show()
                one->
                    Toast.makeText(this , "Only first dose taken" , Toast.LENGTH_SHORT).show()
                fully->
                    Toast.makeText(this , "Fully vaccinated" , Toast.LENGTH_SHORT).show()
            }
        }

    }
    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.checkbox->
                {
                    if(checkBox.isChecked)
                        Toast.makeText(this , "Thank you" , Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this , "Please check the box" , Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

}