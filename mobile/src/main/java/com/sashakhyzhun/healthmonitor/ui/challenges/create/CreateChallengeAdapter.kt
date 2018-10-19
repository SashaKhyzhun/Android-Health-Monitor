package com.sashakhyzhun.healthmonitor.ui.challenges.create

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.sashakhyzhun.healthmonitor.R

class CreateChallengeAdapter(
        private val list: List<String>
) : RecyclerView.Adapter<CreateChallengeAdapter.MyView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(LayoutInflater.from(parent.context)
                .inflate(R.layout.challenges_create_new_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.textView.text = list[position]
    }

    override fun getItemCount(): Int = list.size


    inner class MyView(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView = view.findViewById(R.id.tv_challenge_title) as TextView
    }


}