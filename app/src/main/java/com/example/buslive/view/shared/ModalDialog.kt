package com.example.buslive.view.shared

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.buslive.R
import com.example.buslive.data.model.response.AvailableBusesResponse
import com.example.buslive.util.toCurrency

class ModalDialog(val context: Context) {

    private val dialogBuilder: AlertDialog.Builder by lazy {
        AlertDialog.Builder(context)
    }
    private lateinit var dialog: AlertDialog
    private lateinit var dialogView: View

    fun showSummary(data: AvailableBusesResponse) {

        dialogView = LayoutInflater.from(context).inflate(R.layout.layout_summary_page, null, false)
        dialogView.apply {
            findViewById<TextView>(R.id.tv_bus_name).text = data.name
            findViewById<TextView>(R.id.tv_travel_date).text = data.departure.date
            findViewById<TextView>(R.id.tv_departure).text = data.departure.location
            findViewById<TextView>(R.id.tv_departure_time).text = data.departure.date
            findViewById<TextView>(R.id.tv_departure_terminal).text = data.terminal
            findViewById<TextView>(R.id.tv_arrival).text = data.arrival.location
            findViewById<TextView>(R.id.tv_arrival_time).text = data.arrival.date
            findViewById<TextView>(R.id.tv_arrival_location).text = data.arrival.location
            findViewById<TextView>(R.id.tv_fare).text = data.fare.toCurrency()
            findViewById<ImageButton>(R.id.img_close).setOnClickListener {
                dismiss()
            }
        }

        dialogBuilder
            .setView(dialogView)
            .setCancelable(false)

        dialog = dialogBuilder.create()
        dialog.show()
    }

    fun dismiss() {
        if (::dialog.isInitialized) dialog.dismiss()
    }
}