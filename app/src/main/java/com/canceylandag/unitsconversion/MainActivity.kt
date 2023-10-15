package com.canceylandag.unitsconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.get
import com.canceylandag.unitsconversion.databinding.ActivityMainBinding

private lateinit var binding:ActivityMainBinding

    lateinit var  radioFrom:RadioGroup;
    lateinit var  radioTo:RadioGroup;
    private var FromOp:Int=1;
    private var ToOp:Int=2;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        radioFrom= binding.GroupFrom
        radioTo = binding.GroupTo



        binding.fromText.setOnKeyListener{ _,keyCode,keyEvent ->
            println(keyEvent.action)
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {

                FromOp=setOpValues(radioFrom.checkedRadioButtonId)
                ToOp=setOpValues(radioTo.checkedRadioButtonId)
                var res=0.0

                  if(binding.fromText.text.toString().isEmpty()){

                      binding.fromText.setText("");

                  }else if (FromOp== ToOp){

                      binding.toText.setText(binding.fromText.text);

                  }else if (FromOp< ToOp){
                       res= ((binding.fromText.text.toString().toDouble())*(9/5))+32;
                      println(res)
                  }else if(FromOp > ToOp){
                       res= ((binding.fromText.text.toString().toDouble())-32)*5/9
                      println(res)
                  }

                    binding.toText.setText(res.toString())


            }

            if (keyEvent.action == KeyEvent.KEYCODE_DEL){

                if (binding.fromText.text.length==1){
                    binding.fromText.setText("")
                }else{
                    binding.fromText.setText(binding.fromText.text.slice(0 until binding.fromText.text.length-1 ))

                }

            }

            return@setOnKeyListener true
        }

       /* binding.toText.setOnKeyListener{ _,keyCode,keyEvent ->

            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                if(binding.fromText.text.toString().isEmpty()){

                    binding.fromText.setText("");

                }else if (FromOp== ToOp){

                    binding.toText.setText(binding.fromText.text);

                }

            }

            return@setOnKeyListener true
        }*/
    }


    fun setOpValues(id:Int):Int{
        val radioButton= findViewById<RadioButton>(id)

        if (radioButton.text=="C"){
            return 1
        }else{
            return 2
        }
    }



}