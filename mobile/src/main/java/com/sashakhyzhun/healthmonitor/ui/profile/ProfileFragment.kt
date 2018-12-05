package com.sashakhyzhun.healthmonitor.ui.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.prefs.SessionManager
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity

class ProfileFragment : Fragment() {


    private lateinit var ivSettings: ImageView
    private lateinit var ivUserPhoto: ImageView
    private lateinit var tvUserName: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var tvUserWeight: TextView
    private lateinit var tvUserHeight: TextView
    private lateinit var tvUserBirthday: TextView
    private lateinit var tvUserGender: TextView
    private lateinit var tvUserBlood: TextView
    private lateinit var tvUserAllergy: TextView
    private lateinit var tvUserLifestyle: TextView

    private lateinit var layoutBlood: LinearLayout
    private lateinit var layoutAllergy: LinearLayout
    private lateinit var layoutLifestyle: LinearLayout

    private lateinit var sp: SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sp = SessionManager(context)
    }

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, group, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        setupUI(sp)
    }


    private fun initView(view: View) {
        ivSettings = view.findViewById(R.id.ivSettings)
        ivSettings.onClick { startActivity<SettingsActivity>() }

        ivUserPhoto = view.findViewById<ImageView>(R.id.ivUserPhoto)
        tvUserName = view.findViewById<TextView>(R.id.tvUserName)
        tvUserEmail = view.findViewById<TextView>(R.id.tvUserEmail)

        tvUserWeight = view.findViewById<TextView>(R.id.tvUserWeight)
        tvUserHeight = view.findViewById<TextView>(R.id.tvUserHeight)

        tvUserBirthday = view.findViewById<TextView>(R.id.tvUserBirthday)

        tvUserGender = view.findViewById<TextView>(R.id.tvUserGender)

        tvUserBlood = view.findViewById<TextView>(R.id.tvUserBlood)
        tvUserAllergy = view.findViewById<TextView>(R.id.tvUserAllergy)
        tvUserLifestyle = view.findViewById<TextView>(R.id.tvUserLifestyle)

        layoutBlood = view.findViewById<LinearLayout>(R.id.layout_blood)
        layoutAllergy = view.findViewById<LinearLayout>(R.id.layout_allergy)
        layoutLifestyle = view.findViewById<LinearLayout>(R.id.layout_lifestyle)
    }




    @SuppressLint("SetTextI18n")
    private fun setupUI(sp: SessionManager) {
        Glide.with(context!!)
                .load(sp.profileImage)
                .apply(RequestOptions().circleCrop())
                .into(ivUserPhoto)

        tvUserName.text = sp.userName
        tvUserEmail.text = sp.userEmail
        tvUserWeight.text = sp.width.toString() + " kg"
        tvUserHeight.text = sp.height.toString() + " cm"
        tvUserBirthday.text = sp.birthday
        tvUserGender.text = sp.gender

        //tvUserBlood.text = sp.getBlood()
        //tvUserAllergy.text = sp.getAllergy()
        //tvUserLifestyle.text = sp.getLifestyle()

    }


}