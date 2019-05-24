package com.example.buslive.view.shared


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.buslive.R

class PendingScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({
            context?.let {
                findNavController().navigate(R.id.action_pendingScreenFragment_to_mainFragment)
            }
        }, 2500)
        return inflater.inflate(R.layout.fragment_pending_screen, container, false)
    }


}
