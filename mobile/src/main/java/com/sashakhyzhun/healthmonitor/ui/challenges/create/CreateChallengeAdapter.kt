package com.sashakhyzhun.healthmonitor.ui.challenges.create

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.model.*

class CreateChallengeAdapter <T : Challenge> (
        private val callback: Callback,
        private val challenge: List<T>,
        private val type: ChallengeType
) : RecyclerView.Adapter<CreateChallengeAdapter<T>.MyView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_create_challenge, parent, false))
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val challenge = challenge[position]

        when (type) {
            ChallengeType.DUEL -> {
                challenge as ChallengeDuel
                holder.ivIcon.visibility = View.VISIBLE
                holder.tvAddFriend.setOnClickListener {
                    // 1. should return friend name.
                    // 2. create friend activity and get it from fb.
                    // 3. change challengeType for duel.
                    callback.addFriendClicked(challenge)
                }
                holder.ibCreate.setOnClickListener {
                    callback.createDuel(challenge)
                }
            }
            ChallengeType.SELF -> {
                challenge as ChallengeSelf
                holder.tvChallengeTitle.text = challenge.title
                holder.ibCreate.setOnClickListener {
                    callback.createSelf(challenge)
                }
            }
            ChallengeType.FIT -> {
                challenge as ChallengeFit
                holder.tvChallengeTitle.text = challenge.title
                holder.ibCreate.setOnClickListener {
                    callback.createFit(challenge)
                }
            }
        }


    }

    override fun getItemCount(): Int = challenge.size


    inner class MyView(view: View) : RecyclerView.ViewHolder(view) {
        val ivIcon: ImageView = view.findViewById(R.id.iv_challenge_icon)
        val tvChallengeTitle: TextView = view.findViewById(R.id.tv_challenge_title)
        val tvAddFriend: TextView = view.findViewById(R.id.tv_add_friend)
        //val tvRules: TextView = view.findViewById(R.id.tv_challenge_rules)
        val tvDuration: TextView = view.findViewById(R.id.tv_challenge_duration)
        val ibCreate: ImageButton = view.findViewById(R.id.image_button_create)
    }




    interface Callback {
        fun addFriendClicked(challenge: ChallengeDuel)

        fun createDuel(challenge: ChallengeDuel)
        fun createSelf(challenge: ChallengeSelf)
        fun createFit(challenge: ChallengeFit)
    }


}