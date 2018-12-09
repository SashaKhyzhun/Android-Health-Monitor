package com.sashakhyzhun.healthmonitor.ui.challenges

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.repository.ChallengeRepo
import com.sashakhyzhun.healthmonitor.ui.challenges.create.CreateChallengeActivity
import kotlinx.android.synthetic.main.fragment_challenges.*
import org.jetbrains.anko.support.v4.toast
import timber.log.Timber


class ChallengesFragment : Fragment(), ChallengesAdapter.Callback {

    companion object {
        const val REQUEST_NEW_CHALLENGE = 7425
    }

    private var challenges: MutableList<Challenge> = mutableListOf()

    // UI
    private lateinit var rvChallenges: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var adapter: ChallengesAdapter

    private lateinit var repo: ChallengeRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repo = ChallengeRepo()
        adapter = ChallengesAdapter(context!!, challenges, this)

    }

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, bundle: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_challenges, group, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
        updateUI()
    }


    private fun setUpView(view: View) {
        fab = view.findViewById(R.id.fab)
        fab.setOnClickListener {
            startActivityForResult(
                    Intent(context, CreateChallengeActivity::class.java), REQUEST_NEW_CHALLENGE
            )
        }

        rvChallenges = view.findViewById(R.id.rv_challenges)
        rvChallenges.adapter = adapter
        rvChallenges.layoutManager = LinearLayoutManager(context)
    }

    override fun onItemLongPressed(item: Challenge) {
        val alertDialog = AlertDialog.Builder(context).create()
        alertDialog.setTitle("How is it going?")
        alertDialog.setMessage("Are you done for today?")
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes") { dialog, _ ->

            item.doneForToday = true
            item.lastCheckIn = System.currentTimeMillis()
            
            challenges.remove(item)
            challenges.add(item)
            repo.saveAllInProgress(challenges)

            updateUI()
            toast("check")
            dialog.dismiss()
        }
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Give Up") { dialog, _ ->
            challenges.remove(item)
            repo.saveAllInProgress(challenges)

            updateUI()
            toast("give up")
            dialog.dismiss()
        }
        alertDialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_NEW_CHALLENGE) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    Timber.d("RESULT_OK")
                    updateUI()
                }
                Activity.RESULT_CANCELED -> {
                    Timber.d("RESULT_CANCELED")
                    updateUI()
                }
            }
        }
    }

    private fun updateUI() {
        challenges.clear()
        val all = repo.getAllInProgress()
        println("all=$all")
        challenges.addAll(all)

        rvChallenges.adapter = adapter
        rvChallenges.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()

        if (challenges.isEmpty()) {
            tvNoChallenges.visibility = View.VISIBLE
        } else {
            tvNoChallenges.visibility = View.GONE
        }
    }

}


