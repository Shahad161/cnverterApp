package com.example.cnverterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import com.example.cnverterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var the_number: Double = 0.0
    var from = ""
    var to = ""
    var Result: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dropDownMenu()
    }
    fun dropDownMenu(){
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item,resources.getStringArray(R.array.units_converter))
        binding.autoCompleteTextView4.setAdapter(arrayAdapter)
        binding.autoCompleteTextView5.setAdapter(arrayAdapter)
        addCallbacks()
    }

    private fun addCallbacks() {
        binding.button.setOnClickListener{
            prepareOPeration(units.Button)
            binding.result.text = Result.toString()

        }
    }
    private fun prepareOPeration(operation: units) {
        the_number = binding.InputNumber.text.toString().toDouble()
        from = binding.autoCompleteTextView4.text.toString()
        to = binding.autoCompleteTextView5.text.toString()
        sameUnit()
    }

    fun sameUnit(){
        if (from == to) Result = the_number
        else MeterTokilometer()
    }
    fun MeterTokilometer(){
        if (from == "Meter"  && to == "kilometer")
            Div1000()
        else MeterToCentimeter()
    }
    fun MeterToCentimeter(){
        if (from == "Meter"  && to == "Centimeter")
            Mul100()
        else MeterToMillimeter()
    }
    fun MeterToMillimeter(){
        if (from == "Meter"  && to == "Millimeter")
            Mul1000()
        else kilometerToMeter()
    }
    ////////////////////////////////
    fun kilometerToMeter(){
        if (from == "kilometer"  && to == "Meter")
            Mul1000()
        else kilometerToCentimeter()
    }
    fun kilometerToCentimeter(){
        if (from == "kilometer"  && to == "Centimeter")
            Mul100000()
        else kilometerToMillimeter()
    }
    fun kilometerToMillimeter(){
        if (from == "kilometer"  && to == "Millimeter")
            Mul1000000()
        else CentimeterToMeter()
    }
    //////////////////////////
    fun CentimeterToMeter(){
        if (from == "Centimeter"  && to == "Meter")
            Div100()
        else CentimeterTokilometer()
    }
    fun CentimeterTokilometer(){
        if (from == "Centimeter"  && to == "kilometer")
            Div100000()
        else CentimeterToMillimeter()
    }
    fun CentimeterToMillimeter(){
        if (from == "Centimeter"  && to == "Millimeter")
            Mul10()
        else MillimeterToMeter()
    }
    //////////////////////
    fun MillimeterToMeter(){
        if (from == "Millimeter"  && to == "Meter")
            Div1000()
        else MillimeterTokilometer()
    }
    fun MillimeterTokilometer(){
        if (from == "Millimeter"  && to == "kilometer")
            Div1000000()
        else MillimeterToCentimeter()
    }
    fun MillimeterToCentimeter(){
        if (from == "Millimeter"  && to == "Centimeter")
            Div10()
    }
    //Mul
    fun Mul10(){
        Result = the_number * 10
    }
    fun Mul100(){
        Result = the_number * 100
    }
    fun Mul1000(){
        Result = the_number * 1000
    }
    fun Mul100000(){
        Result = the_number * 100000
    }
    fun Mul1000000(){
        Result = the_number * 1000000
    }
    
    //Div
    fun Div10(){
        Result = the_number / 10
    }
    fun Div100(){
        Result = the_number / 100
    }
    fun Div1000(){
        Result = the_number / 1000
    }
    fun Div100000(){
        Result = the_number / 100000
    }
    fun Div1000000(){
        Result = the_number / 1000000
    }

}