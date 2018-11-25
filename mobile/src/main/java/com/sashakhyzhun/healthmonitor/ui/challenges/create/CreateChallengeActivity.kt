package com.sashakhyzhun.healthmonitor.ui.challenges.create

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.sashakhyzhun.healthmonitor.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sashakhyzhun.healthmonitor.data.model.ChallengeEntity
import com.sashakhyzhun.healthmonitor.ui.base.BaseActivity
import timber.log.Timber


class CreateChallengeActivity : BaseActivity(), CreateChallengeAdapter.Callback {

    companion object {
        const val REQUEST_SELECT_FRIEND = 8812
    }

    private lateinit var rv: RecyclerView
    private lateinit var adapter: CreateChallengeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_challenge)

        getActivityComponent().inject(this)


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

    override fun <T : ChallengeEntity> addFriendClicked(challengeSelf: T) {
        // 1. start activity for result.
        // 2. receive result in onActivityResult
        // 3. change type to 'duel'
        // 4. save to db as active challengeSelf.
    }

    override fun <T : ChallengeEntity> createClicked(challengeSelf: T) {
        // 1. save to db as active challengeSelf.
    }



}