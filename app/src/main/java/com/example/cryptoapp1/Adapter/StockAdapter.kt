package com.example.cryptoapp1.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cryptoapp1.Model.Model
import com.example.cryptoapp1.databinding.ViewholderCryptoBinding
import com.example.cryptoapp1.databinding.ViewholderStockBinding
import java.text.DecimalFormat

class StockAdapter(private val dataList: ArrayList<Model>):
RecyclerView.Adapter<StockAdapter.ViewHolder>()

{
    private val formatter = DecimalFormat("###,###,###,##")
    class ViewHolder(val binding:ViewholderStockBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockAdapter.ViewHolder {
    val binding = ViewholderStockBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StockAdapter.ViewHolder, position: Int) {
   val item = dataList[position]
        holder.binding.apply {
            cryptoNameTxt.text = item.name
            cryptoPriceTxt.text = "${formatter.format(item.price)}"
            percentageTxt.text = "${item.changePercent}%"
            spirtlayout.setData(item.lineData)

            val changeColor =when{
             item.changePercent>0-> Color.parseColor("#12c737")
                item.changePercent<0-> Color.parseColor("#ff0000")
                else ->Color.WHITE
            }
            percentageTxt.setTextColor(changeColor)
            spirtlayout.sparkLineColor = changeColor

            val pickName = when(item.name){
                "NASDAQ100"->"stock_1"
                "S&P 500"->"stock_2"
                "DOW JONES"->"stock_1"

                else -> ""
            }
            val drawableResId = holder.itemView.context.resources.getIdentifier(
                pickName,"drawable", holder.itemView.context.packageName
            )
            Glide.with(holder.itemView.context)
                .load(drawableResId)
                .into(cryptoLogo)
        }
    }

    override fun getItemCount(): Int = dataList.size
}