package com.example.buslive.view.ui.main.booking


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.buslive.R
import com.example.buslive.data.model.response.AvailableBusesResponse
import com.example.buslive.data.model.response.Info
import com.example.buslive.view.shared.ModalDialog
import com.example.buslive.view.ui.main.booking.adapter.AvailableBusesAdapter

class AvailableBusesFragment : Fragment() {

    @BindView(R.id.rv_bus_list)
    lateinit var mBusListRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_available_buses, container, false)
        ButterKnife.bind(this, v)
        init()
        return v
    }

    private fun init() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val mBuses = mutableListOf(
            AvailableBusesResponse(
                0,
                "Intercity Transport Services",
                "STC01",
                Info("Takoradi", "2019-05-26 9:30AM"),
                Info("Accra", "2019-05-26 1:30PM"),
                "Komfo Eku Bus Terminal",
                55.00
            ),
            AvailableBusesResponse(
                0,
                "Metro Mass Transit",
                "MMT01",
                Info("Takoradi", "2019-05-26 9:30AM"),
                Info("Accra", "2019-05-26 1:30PM"),
                "Dzinpa Bus Terminal",
                38.00
            )
        )

        mBusListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = AvailableBusesAdapter(context!!, mBuses).apply {
                notifyDataSetChanged()
                setOnBusSelectedListener(object : AvailableBusesAdapter.OnBusSelected {
                    override fun onBusSelected(selectedBus: AvailableBusesResponse) {
                        val dialog = ModalDialog(context)
                        dialog.showSummary(selectedBus)
//                        Toast.makeText(context, "$selectedBus", Toast.LENGTH_LONG).show()

                    }
                })
            }
        }
    }


}
