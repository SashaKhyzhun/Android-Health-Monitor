package com.sashakhyzhun.healthmonitor.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.sashakhyzhun.healthmonitor.*
import com.sashakhyzhun.healthmonitor.ui.challenges.ChallengesFragment
import com.sashakhyzhun.healthmonitor.ui.analytics.*
import com.sashakhyzhun.healthmonitor.ui.healthrate.HeartRateFragment
import com.sashakhyzhun.healthmonitor.ui.profile.ProfileFragment
import org.jetbrains.anko.toast
import timber.log.Timber

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var doubleBackToExitPressedOnce = false

    lateinit var gso: GoogleSignInOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation_view)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        bottomNavigationView.selectedItemId = R.id.action_profile

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_profile -> {
                loadFragment(ProfileFragment())
                return true
            }
            R.id.action_challenges -> {
                loadFragment(ChallengesFragment())
                return true
            }
            R.id.action_analytics -> {
                loadFragment(AnalyticsFragment())
                return true
            }
            R.id.action_heart_rate -> {
                loadFragment(HeartRateFragment())
                return true
            }
        }
        return false
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        toast("Please click BACK again to exit")
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }


}
