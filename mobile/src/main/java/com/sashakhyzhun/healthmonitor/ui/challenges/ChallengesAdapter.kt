package com.sashakhyzhun.healthmonitor.ui.challenges

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.model.Challenge
import com.sashakhyzhun.healthmonitor.data.model.ChallengeSelf

class ChallengesAdapter(
        private val ctx: Context
) : RecyclerView.Adapter<ChallengesAdapter.ViewHolder>() {

    private var challenge: List<Challenge<ChallengeSelf>>? = null

    override fun onCreateViewHolder(group: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
                .from(ctx)
                .inflate(R.layout.item_challenge_card, group, false))
    }

    override fun getItemCount(): Int = challenge?.size ?: 0

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        if (challenge != null) {
            val item = challenge!![position]

            vh.challengeTitle.text = item.title
            vh.challengeDuration.text = item.duration.toString() + " / 21"

            //item.enemy?.let { vh.challengeWith.text = "with $it" }
        }
    }

    fun setChallenges(items: List<Challenge<ChallengeSelf>>?) {
        challenge = items
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val challengeImage: ImageView = view.findViewById(R.id.image_view_challenge_image)
        val challengeTitle: TextView = view.findViewById(R.id.text_view_challenge_title)
        val challengeDuration: TextView = view.findViewById(R.id.text_view_challenge_duration)
        val challengeWith: TextView = view.findViewById(R.id.text_view_challenge_with)
    }


}