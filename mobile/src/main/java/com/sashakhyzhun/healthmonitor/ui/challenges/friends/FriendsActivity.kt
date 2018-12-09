package com.sashakhyzhun.healthmonitor.ui.challenges.friends

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.model.Friend

class FriendsActivity : AppCompatActivity(), FriendsAdapter.FriendsCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        val allFriends = mutableListOf<Friend>(
                Friend("Oleg", "Schwartz", R.drawable.ic_oleg, "Successfully finished 11 challenges"),
                Friend("Dmitriy", "Dudnyk", R.drawable.ic_dima, "Usually burn 2k calories per day"),
                Friend("Krisz", "Molnar", R.drawable.ic_kris, "Lost 8 kg during last two months"),
                Friend("Ihor", "Yanovchik", R.drawable.ic_ihor, "Didn't smoke last 90 days"),
                Friend("Vladimir", "Shatsky", R.drawable.barber_2, "Getting healthy with WeightLoss diet"),
                Friend("Yury", "Drobitko", R.drawable.barber_3, "Ready for new challenges")
        )

        val adapter = FriendsAdapter(this, allFriends, this)
        val rv = findViewById<RecyclerView>(R.id.rv_friends)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onFriendSelected(name: String) {
        val extra = Intent().putExtra("friend_name", name)
        setResult(Activity.RESULT_OK, extra)
        finish()
    }
}