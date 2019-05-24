package com.example.buslive.view.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import butterknife.BindView
import butterknife.ButterKnife
import com.example.buslive.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    private lateinit var navHostFragment: Fragment
    private lateinit var navController: NavController

    @BindView(R.id.main_toolbar)
    lateinit var mToolbar: Toolbar

    @BindView(R.id.main_bottom_navigation)
    lateinit var mBottomNavigationView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_main, container, false)
        navHostFragment = childFragmentManager.findFragmentById(R.id.main_nav_host)!!
        navController  = NavHostFragment.findNavController(navHostFragment)
        ButterKnife.bind(this, v)
        init()
        return v
    }

    private fun init() {
        initToolbar()
        initBottomNavigation()
    }

    private fun initToolbar() {
        mToolbar.setupWithNavController(navController)
    }

    private fun initBottomNavigation() {
        mBottomNavigationView.setupWithNavController(navController)
    }


}
