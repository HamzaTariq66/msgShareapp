package com.testapplication.user.msgshareapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle : Bundle? = intent.extras
        val msg = bundle!!.getString("user_message")

        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()

        txtUserMsg.text = "Welcome! \n $msg"

        ShareBtn.setOnClickListener {

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT , msg)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent,"Share this message to :"))
        }

        Backbtn2.setOnClickListener {

            setResult(Activity.RESULT_OK)
            finish()
        }

        ThirdBtn.setOnClickListener {

            val intent = Intent(this,ThirdActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}

