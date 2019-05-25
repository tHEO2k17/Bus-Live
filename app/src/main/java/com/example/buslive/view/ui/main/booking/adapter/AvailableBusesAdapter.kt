package com.example.buslive.view.ui.main.booking.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.buslive.R
import com.example.buslive.data.model.response.AvailableBusesResponse
import com.example.buslive.util.toCurrency
import com.example.buslive.util.toTime
import kotlinx.android.synthetic.main.layout_available_buses.view.*

class AvailableBusesAdapter(
    val context: Context,
    val availableBuses: MutableList<AvailableBusesResponse>
) : RecyclerView.Adapter<AvailableBusesAdapter.ViewHolder>() {

    private lateinit var mOnBusSelected: OnBusSelected

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvailableBusesAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_available_buses, parent, false))
    }

    override fun getItemCount(): Int = availableBuses.size

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.departureTime.text = availableBuses[position].departure.date.toTime()
        holder.arrivalTime.text = " - " + availableBuses[position].arrival.date.toTime()
        holder.busName.text = availableBuses[position].name
        holder.fare.text = availableBuses[position].fare.toCurrency()
        holder.duration.text = "4 hours"

        holder.itemView.setOnClickListener {
            mOnBusSelected.onBusSelected(
                availableBuses[holder.adapterPosition]
            )
        }
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val departureTime: TextView = v.tv_departure_time!!
        val arrivalTime: TextView = v.tv_arrival_time!!
        val busName: TextView = v.tv_bus_name!!
        val fare: TextView = v.tv_fare!!
        val duration: TextView = v.tv_duration!!
    }

    fun setOnBusSelectedListener(onBusSelected: OnBusSelected){
        mOnBusSelected = onBusSelected
    }
    interface OnBusSelected {
        fun onBusSelected(selectedBus: AvailableBusesResponse)
    }
}