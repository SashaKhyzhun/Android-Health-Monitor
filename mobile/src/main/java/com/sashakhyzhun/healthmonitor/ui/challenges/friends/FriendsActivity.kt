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
                Friend("Krisz", "Molnar", R.drawable.barber_1),
                Friend("Oleg", "Schwartz", R.drawable.barber_2),
                Friend("Dmitriy", "Dudnyk", R.drawable.barber_3),
                Friend("Ihor", "Yanovchik", R.drawable.barber_4)
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