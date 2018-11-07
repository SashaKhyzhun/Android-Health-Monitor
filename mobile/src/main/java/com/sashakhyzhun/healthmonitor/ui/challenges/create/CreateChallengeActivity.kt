package com.sashakhyzhun.healthmonitor.ui.challenges.create

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import com.sashakhyzhun.healthmonitor.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.ui.base.BaseActivity
import com.sashakhyzhun.healthmonitor.ui.challenges.ChallengesViewModel
import timber.log.Timber
import javax.inject.Inject


class CreateChallengeActivity : BaseActivity(), CreateChallengeAdapter.Callback {

    companion object {
        const val REQUEST_SELECT_FRIEND = 8812
    }

    private lateinit var rv: RecyclerView
    private lateinit var adapter: CreateChallengeAdapter

    //@Inject lateinit var presenter: CreatePresenter<CreateView>
    //@Inject lateinit var linearLayout: LinearLayoutManager

    private lateinit var mChallengesVM: CreateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_challenge)

        getActivityComponent().inject(this)



        mChallengesVM = ViewModelProviders.of(this).get(CreateViewModel::class.java)

        adapter = CreateChallengeAdapter(this)

        //linearLayout.orientation = LinearLayoutManager.HORIZONTAL

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
        mChallengesVM.create(challenge)
    }



}