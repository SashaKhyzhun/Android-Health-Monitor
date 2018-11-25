package com.sashakhyzhun.healthmonitor.ui.challenges.create

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.sashakhyzhun.healthmonitor.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sashakhyzhun.healthmonitor.data.model.*
import com.sashakhyzhun.healthmonitor.data.model.ChallengeType.*
import com.sashakhyzhun.healthmonitor.data.repository.ChallengeRepo
import com.sashakhyzhun.healthmonitor.ui.base.BaseActivity
import com.sashakhyzhun.healthmonitor.utils.fillDuelChallenges
import com.sashakhyzhun.healthmonitor.utils.fillFitChallenges
import com.sashakhyzhun.healthmonitor.utils.fillSelfChallenges
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import timber.log.Timber


class CreateChallengeActivity : BaseActivity(), CreateChallengeAdapter.Callback {

    companion object {
        const val REQUEST_SELECT_FRIEND = 8812
    }

    private lateinit var rvSelf: RecyclerView
    private lateinit var rvDuel: RecyclerView
    private lateinit var rvFit: RecyclerView

    private lateinit var adapter: CreateChallengeAdapter
    private lateinit var adapterDuel: CreateChallengeAdapter
    private lateinit var adapterFit: CreateChallengeAdapter

    private lateinit var repository: ChallengeRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_challenge)

        getActivityComponent().inject(this)

        repository = ChallengeRepo()

        adapter = CreateChallengeAdapter(this, fillSelfChallenges(), SELF)
        adapterDuel = CreateChallengeAdapter(this, fillDuelChallenges(), DUEL)
        adapterFit = CreateChallengeAdapter(this, fillFitChallenges(), FIT)


        rvSelf = findViewById(R.id.rv_self_challenges)
        rvSelf.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvSelf.adapter = adapter

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

    override fun create(challenge: Challenge) {
        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle("Alert")
        alertDialog.setMessage("Alert message to be shown")
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Create") { dialog, _ ->
            val all = repository.getAllInProgress()
            val isSelf = all.map { it.title }.contains(challenge.title)

            if (isSelf.not()) {
                all.add(challenge)
                repository.saveAllInProgress(all)


                setResult(Activity.RESULT_OK)
                finish()
            } else {
                toast("This challenge is already exists")
                setResult(Activity.RESULT_OK)
                finish()
            }
            dialog.dismiss()
        }
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        //alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK") { dialog, _ -> dialog.dismiss() }
        alertDialog.show()


    }

    override fun addFriendClicked(challenge: Challenge) {

    }
}