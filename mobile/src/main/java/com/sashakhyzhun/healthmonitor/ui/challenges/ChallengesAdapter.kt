package com.sashakhyzhun.healthmonitor.ui.challenges

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.model.Challenge

class ChallengesAdapter(
        private val ctx: Context,
        private val challenge: List<Challenge>,
        private val callback: Callback
) : RecyclerView.Adapter<ChallengesAdapter.ViewHolder>() {

    interface Callback {
        fun onItemLongPressed(item: Challenge)
    }

    override fun onCreateViewHolder(group: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
                .from(ctx)
                .inflate(R.layout.item_challenge_card, group, false))
    }

    override fun getItemCount(): Int = challenge.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        val item = challenge[position]

        vh.challengeImage.setImageResource(item.image)
        vh.challengeTitle.text = item.title

        if (item.doneForToday.not()) {
            vh.challengeDuration.textSize = 12F
            vh.challengeDuration.text = "Done\nfor\ntoday?"
        } else {
            vh.challengeDuration.textSize = 20F
            vh.challengeDuration.text = item.currentDay.toString() + " of 21"
        }

        if (item.enemy.isNotEmpty()) {
            vh.challengeWith.visibility = View.VISIBLE
            vh.challengeWith.text = item.enemy
        } else {
            vh.challengeWith.visibility = View.INVISIBLE
        }
        vh.parent.setOnLongClickListener {
            callback.onItemLongPressed(item)
            true
        }
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val parent: RelativeLayout = view.findViewById(R.id.parentPanel)
        val challengeImage: ImageView = view.findViewById(R.id.image_view_challenge_image)
        val challengeTitle: TextView = view.findViewById(R.id.text_view_challenge_title)
        val challengeDuration: TextView = view.findViewById(R.id.text_view_challenge_duration)
        val challengeWith: TextView = view.findViewById(R.id.text_view_challenge_with)
    }


}