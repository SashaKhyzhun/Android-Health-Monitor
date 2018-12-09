package com.sashakhyzhun.healthmonitor.ui.challenges.friends

import android.annotation.SuppressLint
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.model.Friend
import org.jetbrains.anko.image

class FriendsAdapter(
        private val ctx: Context,
        private val friends: List<Friend>,
        private val callback: FriendsCallback
) : RecyclerView.Adapter<FriendsAdapter.ViewHolder>() {

    interface FriendsCallback {
        fun onFriendSelected(name: String)
    }

    override fun onCreateViewHolder(group: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(ctx)
                .inflate(R.layout.item_friend, group, false))
    }

    override fun getItemCount(): Int = friends.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        val item = friends[position]

        Glide.with(ctx)
                .load(item.image)
                .apply(RequestOptions().circleCrop())
                .into(vh.ava)

        vh.ava.image = ctx.getDrawable(item.image)
        vh.name.text = "${item.firstName} ${item.lastName}"
        vh.desc.text = item.description
        vh.parent.setOnLongClickListener {
            callback.onFriendSelected("${item.firstName} ${item.lastName}")
            true
        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val parent: ConstraintLayout = view.findViewById(R.id.parentPanel)
        val ava: ImageView = view.findViewById(R.id.ivAvatar)
        val name: TextView = view.findViewById(R.id.tv_name)
        val desc: TextView = view.findViewById(R.id.tv_desc)
    }


}