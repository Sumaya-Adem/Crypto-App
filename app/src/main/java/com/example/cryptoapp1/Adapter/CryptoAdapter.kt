package com.example.cryptoapp1.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cryptoapp1.Model.Model
import com.example.cryptoapp1.databinding.ViewholderCryptoBinding
import java.text.DecimalFormat

class CryptoAdapter(private val dataList: ArrayList<Model>):
RecyclerView.Adapter<CryptoAdapter.ViewHolder>()

{
    private val formatter = DecimalFormat("###,###,###,##")
    class ViewHolder(val binding:ViewholderCryptoBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoAdapter.ViewHolder {
    val binding = ViewholderCryptoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoAdapter.ViewHolder, position: Int) {
   val item = dataList[position]
        holder.binding.apply {
            cryptoNameTxt.text = item.name
            cryptoPrice.text = "${formatter.format(item.price)}"
            percentageChange.text = "${item.changePercent}%"
            propertySize.text = "${item.propertySize}${item.symbol}"
            propertyamount.text = "${formatter.format(item.propertyAmount)}"
            spirtlayout.setData(item.lineData)

            val changeColor =when{
             item.changePercent>0-> Color.parseColor("#12c737")
                item.changePercent<0-> Color.parseColor("#ff0000")
                else ->Color.WHITE
            }
            percentageChange.setTextColor(changeColor)
            spirtlayout.sparkLineColor = changeColor

            val drawableResId = holder.itemView.context.resources.getIdentifier(
                item.name,"drawable", holder.itemView.context.packageName
            )
            Glide.with(holder.itemView.context)
                .load(drawableResId)
                .into(cryptoLogo)
        }
    }

    override fun getItemCount(): Int = dataList.size
}