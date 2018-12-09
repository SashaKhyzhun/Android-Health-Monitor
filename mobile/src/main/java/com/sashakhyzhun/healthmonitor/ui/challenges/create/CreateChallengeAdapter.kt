package com.sashakhyzhun.healthmonitor.ui.challenges.create

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.model.ChallengeType

class CreateChallengeAdapter(
        private val callback: Callback,
        private val challenge: List<Challenge>,
        private val type: ChallengeType
) : RecyclerView.Adapter<CreateChallengeAdapter.MyView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_create_challenge, parent, false))
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val challenge = challenge[position]

        holder.ivIcon.setImageResource(challenge.image)
        holder.tvDuration.text = challenge.duration.toString()

        if (type == ChallengeType.DUEL) {
            holder.tvAddFriend.visibility = View.VISIBLE
            holder.tvAddFriend.setOnClickListener {
                callback.addFriendClicked(challenge)
            }
        }

        holder.tvChallengeTitle.text = challenge.title

        holder.tvCreate.setOnClickListener {
            callback.create(challenge)
        }

    }

    override fun getItemCount(): Int = challenge.size


    inner class MyView(view: View) : RecyclerView.ViewHolder(view) {
        val ivIcon: ImageView = view.findViewById(R.id.iv_challenge_icon)
        val tvChallengeTitle: TextView = view.findViewById(R.id.tv_challenge_title)
        val tvAddFriend: TextView = view.findViewById(R.id.tv_add_friend)
        val tvDuration: TextView = view.findViewById(R.id.tv_challenge_duration)
        val tvCreate: TextView = view.findViewById(R.id.tv_button_create)
    }


    interface Callback {
        fun addFriendClicked(challenge: Challenge)
        fun create(challenge: Challenge)
    }


}