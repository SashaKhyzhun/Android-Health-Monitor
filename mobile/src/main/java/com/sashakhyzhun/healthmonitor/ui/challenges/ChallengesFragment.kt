package com.sashakhyzhun.healthmonitor.ui.challenges

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
import com.sashakhyzhun.healthmonitor.data.model.ChallengeType
import com.sashakhyzhun.healthmonitor.utils.fillWithMockChallenges
import org.jetbrains.anko.support.v4.toast

class ChallengesFragment : Fragment() {

    private var challenges: MutableList<Challenge> = mutableListOf()

    // UI
    private lateinit var rvChallenges: RecyclerView
    private lateinit var fab: FloatingActionButton

    private lateinit var adapter: ChallengesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        challenges.fillWithMockChallenges()
        adapter = ChallengesAdapter(context!!, challenges)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.challenges_fragment, container, false)

        rvChallenges = view.findViewById(R.id.rv_challenges)
        rvChallenges.adapter = adapter
        rvChallenges.layoutManager = LinearLayoutManager(context)


        fab = view.findViewById(R.id.fab)
        fab.setOnClickListener { toast("Fab") }


        //todo: slider for rv items like in barber.

        return view

    }

}


