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

class CreateChallengeAdapter (
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

        if (type == ChallengeType.DUEL) {
            holder.ivIcon.visibility = View.VISIBLE
            holder.tvAddFriend.visibility = View.VISIBLE
            holder.tvAddFriend.setOnClickListener {
                callback.addFriendClicked(challenge)
            }
        }

        holder.tvChallengeTitle.text = challenge.title
        holder.ibCreate.setOnClickListener {

            callback.create(challenge)
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
        fun addFriendClicked(challenge: Challenge)
        fun create(challenge: Challenge)
    }


}