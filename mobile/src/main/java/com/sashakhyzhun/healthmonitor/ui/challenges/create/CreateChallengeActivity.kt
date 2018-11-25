package com.sashakhyzhun.healthmonitor.ui.challenges.create

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.sashakhyzhun.healthmonitor.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sashakhyzhun.healthmonitor.data.model.*
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus.*
import com.sashakhyzhun.healthmonitor.data.model.ChallengeType.*
import com.sashakhyzhun.healthmonitor.data.repository.ChallengeRepo
import com.sashakhyzhun.healthmonitor.ui.base.BaseActivity
import com.sashakhyzhun.healthmonitor.utils.fillDuelChallenges
import com.sashakhyzhun.healthmonitor.utils.fillFitChallenges
import com.sashakhyzhun.healthmonitor.utils.fillSelfChallenges
import org.jetbrains.anko.toast
import timber.log.Timber


class CreateChallengeActivity : BaseActivity(), CreateChallengeAdapter.Callback {

    companion object {
        const val REQUEST_SELECT_FRIEND = 8812
    }

    private lateinit var rvSelf: RecyclerView
    private lateinit var rvDuel: RecyclerView
    private lateinit var rvFit: RecyclerView

    private lateinit var adapterSelf: CreateChallengeAdapter<ChallengeSelf>
    private lateinit var adapterDuel: CreateChallengeAdapter<ChallengeDuel>
    private lateinit var adapterFit: CreateChallengeAdapter<ChallengeFit>

    private lateinit var repository: ChallengeRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_challenge)

        getActivityComponent().inject(this)

        repository = ChallengeRepo()

        adapterSelf = CreateChallengeAdapter(this, fillSelfChallenges(), SELF)
        adapterDuel = CreateChallengeAdapter(this, fillDuelChallenges(), DUEL)
        adapterFit = CreateChallengeAdapter(this, fillFitChallenges(), FIT)


        rvSelf = findViewById(R.id.rv_self_challenges)
        rvSelf.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvSelf.adapter = adapterSelf

        rvDuel = findViewById(R.id.rv_duel_challenges)
        rvDuel.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvDuel.adapter = adapterDuel

        rvFit = findViewById(R.id.rv_fit_challenges)
        rvFit.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvFit.adapter = adapterFit
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

    override fun addFriendClicked(challenge: ChallengeDuel) {
    }

    override fun createSelf(challenge: ChallengeSelf) {
        val all = repository.getAllSelf(INPROGRESS)!!

        if (all.contains(challenge).not()) {
            all.add(challenge)
            repository.storeSelf(all)
        } else {
            toast("This challenge is already exists")
        }
    }

    override fun createDuel(challenge: ChallengeDuel) {
    }

    override fun createFit(challenge: ChallengeFit) {
    }


}