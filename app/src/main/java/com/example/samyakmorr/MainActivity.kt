package com.example.samyakmorr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var etxtCard:TextInputLayout
    lateinit var etcard:TextInputEditText
    lateinit var etdate:TextInputEditText
    lateinit var etcvv:TextInputEditText
    lateinit var etfirst:TextInputEditText
    lateinit var etlast:TextInputEditText
    lateinit var btnSubmit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title ="Credit Card Input Exercise"
        etcard=findViewById(R.id.etCard)
        etdate=findViewById(R.id.etdate)
        etcvv=findViewById(R.id.etcvv)
        etfirst=findViewById(R.id.etfirst)
        etlast=findViewById(R.id.etlast)
        btnSubmit=findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            if (isValidDetails()){
                val dialog=AlertDialog.Builder(this@MainActivity)
                dialog.setTitle("Payment Successfull")
                dialog.setPositiveButton("OK"){text,listener->

                }
                dialog.create()
                dialog.show()

            }
        }

    }
    fun showToast(message:String){
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
    fun isValidDetails():Boolean{
        if(etcard.text!!.isBlank() == true){
            showToast("enter the valid card number")
            return false
        }
        else if(validateDate(etdate.text.toString())==false){
            showToast("enter valid date")
            return false
        }
        else if(etcvv.length()<3){
            showToast("enter valid cvv")
            return false
        }
        else if(etfirst.text?.isBlank() == true){
            showToast("enter first name")
            return false
        }
        else if (etlast.text?.isBlank() == true){
            showToast("enter last name")
            return false
        }
        else{
            return true
        }
    }
    fun validateDate(date:String):Boolean{
        if(date.get(0)!='0'&&date.get(0)=='1'){
            if(date.get(1)!='1'&&date.get(1)!='2'&&date.get(1)!='0'){
                return false
            }
            else{
                return true
            }
        }
        else if(date.get(0)=='0'){
            return true
        }
        else{
            return false
        }
    }




}