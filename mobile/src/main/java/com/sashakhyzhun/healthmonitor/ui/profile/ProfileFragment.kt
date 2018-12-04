package com.sashakhyzhun.healthmonitor.ui.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.sashakhyzhun.healthmonitor.R
import com.sashakhyzhun.healthmonitor.data.prefs.PreferencesHelper
import com.sashakhyzhun.healthmonitor.ui.base.BaseFragment
import com.sashakhyzhun.healthmonitor.ui.profile.settings.SettingsActivity
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity
import javax.inject.Inject

class ProfileFragment : BaseFragment(), ProfileView {

    /**
     * Items:
     *
     * Name
     * Email
     * Photo
     * Gender
     * Date of birth
     * Height
     * Weight
     *
     * Blood
     * Allergy
     * Lifestyle
     *
     * Personal Goals:
     *
     */



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

    private lateinit var sp: PreferencesHelper

    @Inject
    lateinit var presenter: ProfilePresenter<ProfileView>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val component = getActivityComponent()
        component?.let {
            it.inject(this)
            presenter.onAttach(this)
        }

        sp = PreferencesHelper(context)



    }

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, group, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI(sp)
    }


    override fun setUpView(view: View) {
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
    private fun setupUI(sp: PreferencesHelper) {
        Glide.with(context!!)
                .load(sp.getProfileImage())
                .apply(RequestOptions().circleCrop())
                .into(ivUserPhoto)

        tvUserName.text = sp.getUserName()
        tvUserEmail.text = sp.getUserEmail()
        tvUserWeight.text = sp.getWidth().toString() + " kg"
        tvUserHeight.text = sp.getHeight().toString() + " cm"
        tvUserBirthday.text = sp.getBirthday()
        tvUserGender.text = sp.getGender()

        //tvUserBlood.text = sp.getBlood()
        //tvUserAllergy.text = sp.getAllergy()
        //tvUserLifestyle.text = sp.getLifestyle()

    }


}