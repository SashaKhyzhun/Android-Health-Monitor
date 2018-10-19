package com.sashakhyzhun.healthmonitor.ui.challenges.create

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sashakhyzhun.healthmonitor.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.MotionEvent
import android.view.GestureDetector
import org.jetbrains.anko.toast


class CreateChallengeActivity : AppCompatActivity() {

    var number: MutableList<String> = mutableListOf()

    private lateinit var rv: RecyclerView
    private var adapter: CreateChallengeAdapter? = null

    var childView: View? = null
    var rvItemPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.challenges_create_new_activity)

        addItemsToRecyclerViewArrayList()
        adapter = CreateChallengeAdapter(number)


        rv = findViewById(R.id.rv_create_challenge)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv.adapter = adapter

        rv.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            var gestureDetector = GestureDetector(applicationContext, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(motionEvent: MotionEvent): Boolean = true
            })
            override fun onInterceptTouchEvent(Recyclerview: RecyclerView, motionEvent: MotionEvent): Boolean {
                childView = Recyclerview.findChildViewUnder(motionEvent.x, motionEvent.y)
                if (childView != null && gestureDetector.onTouchEvent(motionEvent)) {
                    rvItemPosition = Recyclerview.getChildAdapterPosition(childView!!)
                    toast(number[rvItemPosition])
                }
                return false
            }

            override fun onTouchEvent(Recyclerview: RecyclerView, motionEvent: MotionEvent) {}
            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
        })

    }

    private fun addItemsToRecyclerViewArrayList() {
        number.add("ONE")
        number.add("TWO")
        number.add("THREE")
        number.add("FOUR")
        number.add("FIVE")
        number.add("SIX")
        number.add("SEVEN")
        number.add("EIGHT")
        number.add("NINE")
        number.add("TEN")

    }

}