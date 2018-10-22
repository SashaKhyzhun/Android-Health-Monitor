package com.sashakhyzhun.healthmonitor.ui.challenges

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nikhilpanju.recyclerviewenhanced.RecyclerTouchListener
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.ui.challenges.create.CreateChallengeActivity
import com.sashakhyzhun.healthmonitor.utils.fillWithMockChallenges
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import timber.log.Timber

class ChallengesFragment : Fragment() {

    companion object {
        const val REQUEST_NEW_CHALLENGE = 7425
    }

    private var challenges: MutableList<Challenge> = mutableListOf()

    // UI
    private lateinit var rvChallenges: RecyclerView
    private lateinit var fab: FloatingActionButton

    private lateinit var adapter: ChallengesAdapter
    private lateinit var onTouchIncomingListener: RecyclerTouchListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        challenges.fillWithMockChallenges()
        adapter = ChallengesAdapter(context!!, challenges)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.challenges_fragment, container, false)

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


        return view
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


