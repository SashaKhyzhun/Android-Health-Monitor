package com.sashakhyzhun.healthmonitor.ui.challenges

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nikhilpanju.recyclerviewenhanced.RecyclerTouchListener
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.model.ChallengeSelf
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus
import com.sashakhyzhun.healthmonitor.data.model.ChallengeStatus.*
import com.sashakhyzhun.healthmonitor.data.model.ChallengeType
import com.sashakhyzhun.healthmonitor.data.repository.ChallengeRepo
import com.sashakhyzhun.healthmonitor.ui.base.BaseFragment
import com.sashakhyzhun.healthmonitor.ui.challenges.create.CreateChallengeActivity
import kotlinx.android.synthetic.main.fragment_challenges.*
import org.jetbrains.anko.support.v4.toast
import timber.log.Timber

class ChallengesFragment : BaseFragment() {

    companion object {
        const val REQUEST_NEW_CHALLENGE = 7425
    }

    private var challenges: MutableList<ChallengeSelf> = mutableListOf()

    // UI
    private lateinit var rvChallenges: RecyclerView
    private lateinit var fab: FloatingActionButton

    private lateinit var adapter: ChallengesAdapter
    private lateinit var onTouchIncomingListener: RecyclerTouchListener


    private lateinit var repo: ChallengeRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val component = getActivityComponent()
//        component?.let {
//            it.inject(this)
//            presenter.onAttach(this)
//        }

        repo = ChallengeRepo()
        val all = repo.getAllSelf(INPROGRESS)!!
        challenges.addAll(all)
        adapter = ChallengesAdapter(context!!, challenges)

    }

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, bundle: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_challenges, group, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (challenges.isEmpty()) {
            tvNoChallenges.visibility = View.VISIBLE
        }
    }

    override fun setUpView(view: View) {
        fab = view.findViewById(R.id.fab)
        fab.setOnClickListener { startActivityForResult(
                Intent(context, CreateChallengeActivity::class.java), REQUEST_NEW_CHALLENGE)
        }

        rvChallenges = view.findViewById(R.id.rv_challenges)
        rvChallenges.adapter = adapter
        rvChallenges.layoutManager = LinearLayoutManager(context)

        onTouchIncomingListener = RecyclerTouchListener(activity, rvChallenges)
        onTouchIncomingListener
                //.setIndependentViews(R.id.rowButton)
                .setSwipeOptionViews(R.id.layout_check_in, R.id.layout_give_up)
                .setSwipeable(R.id.rowFG, R.id.rowBG) { viewID, _ ->
                    when (viewID) {
                        R.id.layout_check_in -> {
                            toast("1")

                        }
                        R.id.layout_give_up -> {
                            toast("2")
                        }
                    }
                }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_NEW_CHALLENGE) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    Timber.d("RESULT_OK")
                }
                Activity.RESULT_CANCELED -> {
                    Timber.d("RESULT_CANCELED")
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        rvChallenges.addOnItemTouchListener(onTouchIncomingListener)
    }

    override fun onPause() {
        super.onPause()
        rvChallenges.removeOnItemTouchListener(onTouchIncomingListener)
    }

}


