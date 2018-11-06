package com.sashakhyzhun.healthmonitor.ui.challenges.create

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.model.ChallengeType

class CreateChallengeAdapter(
        private val callback: Callback
) : RecyclerView.Adapter<CreateChallengeAdapter.MyView>() {

    private val challenges: List<Challenge> = fillChallenges()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_create_challenge, parent, false))
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val challenge = challenges[position]
        holder.tvChallengeTitle.text = challenge.title

        holder.tvAddFriend.setOnClickListener {
            // 1. should return friend name.
            // 2. create friend activity and get it from fb.
            // 3. change challengeType for duel.
            callback.addFriendClicked(challenge)
        }
        holder.ibCreate.setOnClickListener {
            callback.createClicked(challenge)
        }

    }

    override fun getItemCount(): Int = challenges.size


    inner class MyView(view: View) : RecyclerView.ViewHolder(view) {
        val ivIcon: ImageView = view.findViewById(R.id.iv_challenge_icon)
        val tvChallengeTitle: TextView = view.findViewById(R.id.tv_challenge_title)
        val tvAddFriend: TextView = view.findViewById(R.id.tv_add_friend)
        val tvRules: TextView = view.findViewById(R.id.tv_challenge_rules)
        val tvDuration: TextView = view.findViewById(R.id.tv_challenge_duration)
        val ibCreate: ImageButton = view.findViewById(R.id.image_button_create)
    }

    private fun fillChallenges(): List<Challenge> {
        return listOf(
                Challenge("Smoking free live", 21, ChallengeType.SELF, null, 0L, false),
                Challenge("No TV", 21, ChallengeType.SELF, null, 0L, false),
                Challenge("Taking stairs", 21, ChallengeType.SELF, null, 0L, false),
                Challenge("Sugar free live", 21, ChallengeType.SELF, null, 0L, false),
                Challenge("10K steps per day", 21, ChallengeType.FITNESS, null, 0L, false),
                Challenge("Drink more water", 21, ChallengeType.SELF, null, 0L, false),
                Challenge("Sleep before midnight", 21, ChallengeType.SELF, null, 0L, false)
        )
    }


    interface Callback {
        fun addFriendClicked(challenge: Challenge)
        fun createClicked(challenge: Challenge)
    }


}