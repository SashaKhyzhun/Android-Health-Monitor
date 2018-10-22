package com.sashakhyzhun.healthmonitor.ui.challenges.create

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sashakhyzhun.healthmonitor.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.MotionEvent
import android.view.GestureDetector
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import org.jetbrains.anko.toast
import timber.log.Timber


class CreateChallengeActivity : AppCompatActivity(), CreateChallengeAdapter.Callback {

    companion object {
        const val REQUEST_SELECT_FRIEND = 8812
    }

    private lateinit var rv: RecyclerView
    private lateinit var adapter: CreateChallengeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.challenges_create_new_activity)

        adapter = CreateChallengeAdapter(this)


        rv = findViewById(R.id.rv_create_challenge)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv.adapter = adapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_SELECT_FRIEND) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    Timber.d("RESULT_OK ")
                }
                Activity.RESULT_CANCELED -> {
                    Timber.d("RESULT_CANCELED")
                }
            }
        }
    }

    override fun addFriendClicked(challenge: Challenge) {
        // 1. start activity for result.
        // 2. receive result in onActivityResult
        // 3. change type to 'duel'
        // 4. save to db as active challenge.
    }

    override fun createClicked(challenge: Challenge) {
        // 1. save to db as active challenge.
    }



}