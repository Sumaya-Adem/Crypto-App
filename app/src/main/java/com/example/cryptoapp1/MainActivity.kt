package com.example.cryptoapp1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp1.Adapter.CryptoAdapter
import com.example.cryptoapp1.Adapter.StockAdapter
import com.example.cryptoapp1.Model.Model
import com.example.cryptoapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val lineData1 = arrayListOf(1000,1100,12000,1100)
    private val lineData2 = arrayListOf(2000,2100,1900,2100)
    private val lineData3 = arrayListOf(900,1100,8000,1500)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.WHITE
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE

        binding.fab.setOnClickListener {
            startActivity(Intent(this, SplashActivity::class.java))
        }

        cryptoList()
        stockList()
    }

    private fun stockList() {
        binding.stockView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        val domainArrayList = arrayListOf(
            Model("NASDAQ100","BTX",1234.12,2.24,lineData1,
                1234.12,1.30),
            Model("S&P 500","ETH",3334.12,-1.74,lineData2,
                1234.12,1.30),
            Model("DOW JONES","ROX",1454.12,0.34,lineData2,
                1234.12,1.50)


        )
        binding.stockView.adapter =StockAdapter(domainArrayList)
    }

    private fun cryptoList() {
        binding.CryptoView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val domainArrayList = arrayListOf(
         Model("bitcoin","BTX",1234.12,2.24,lineData1,
             1234.12,1.30),
                 Model("etherium","ETH",3334.12,-1.74,lineData2,
            1234.12,1.30),
            Model("trox","ROX",1454.12,0.34,lineData2,
                1234.12,1.50)


        )
        binding.CryptoView.adapter = CryptoAdapter(domainArrayList)
    }


}