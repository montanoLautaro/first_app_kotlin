package com.example.firstapp.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityImcCalculatorBinding
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcCalculatorBinding
    private var isMaleSelected = false
    private var isFemaleSelected = false
    private var currentWeight = 60
    private var currentAge = 25
    private var currentHeight = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setGenderColor()
        initListeners()
    }

    private fun initListeners() {
        binding.viewMale.setOnClickListener {
            selectMale()
            setGenderColor()
        }
        binding.viewFemale.setOnClickListener {
            selectFemale()
            setGenderColor()
        }

        binding.rsHeight.addOnChangeListener { _, value, _ ->
            //1 entero y dos decimales
            val decimalFormat = DecimalFormat("#.##")
            val result = decimalFormat.format(value)
            currentHeight = value.toInt()
            binding.tvHeight.text = result.toString() + "cm"
        }

        binding.btnPlusWeight.setOnClickListener {
            currentWeight++
            binding.tvWeight.text = currentWeight.toString()
        }
        binding.btnSubstractWeight.setOnClickListener {
            currentWeight--
            binding.tvWeight.text = currentWeight.toString()
        }

        binding.btnPlusAge.setOnClickListener {
            currentAge++
            binding.tvAge.text = currentAge.toString()
        }
        binding.btnSubstractAge.setOnClickListener {
            currentAge--
            binding.tvAge.text = currentAge.toString()
        }

        binding.btnCalculate.setOnClickListener {
            calculateImc()
        }

    }

    private fun calculateImc() {
        val imc = currentWeight / (currentHeight)
    }

    private fun selectMale() {
        isMaleSelected = !isMaleSelected
    }

    private fun selectFemale() {
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        binding.viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        binding.viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }


}