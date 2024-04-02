package com.example.mvvminfo.ShowData.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.mvvminfo.ShowData.adapter.LoginAdapter
import com.example.mvvminfo.ShowData.model.ShowResponse
import com.example.mvvminfo.ShowData.viewmodel.ShowViewModel
import com.example.mvvminfo.constant.BaseResponse
import com.example.mvvminfo.databinding.ActivityLogoutBinding
import com.example.mvvminfo.singleton.MySingleton

class LogoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogoutBinding
    private val viewModel by viewModels<ShowViewModel>()
    lateinit var myInstance : MySingleton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        myInstance = MySingleton.getInstance(this@LogoutActivity)
        viewModel.loginUser(myInstance.getData("email").toString())

        viewModel.loginResult.observe(this) { result ->
            when (result) {
                is  BaseResponse.Loading -> showLoading()
                is  BaseResponse.Success ->
                    {
                        stopLoading()
                        processLogin(result.data)
                    }
                is  BaseResponse.Error -> processError(result.msg)
                else -> {


                }
            }
        }


    }

    private fun processLogin(data: ShowResponse?) {
        if (data != null && data.isNotEmpty()) {
            showToast("Age: " + data[0].Age)
            var adapter= LoginAdapter(this@LogoutActivity,data)
           binding.rvJsondata.adapter=adapter
            // Process other data properties as needed
        } else {
            showToast("No data received")
        }
    }

    private fun processError(msg: String?) {
        showToast("Error: $msg")
    }

    private fun showLoading() {
        binding.prgbar.visibility = View.VISIBLE
    }

    private fun stopLoading() {
        binding.prgbar.visibility = View.GONE
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
