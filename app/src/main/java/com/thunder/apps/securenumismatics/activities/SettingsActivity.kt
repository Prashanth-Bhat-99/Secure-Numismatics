package com.thunder.apps.securenumismatics.activities


import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.thunder.apps.securenumismatics.R
import com.thunder.apps.securenumismatics.databinding.ActivitySettingsBinding
import com.thunder.apps.securenumismatics.firestore.FireStoreClass
import com.thunder.apps.securenumismatics.model.User
import com.thunder.apps.securenumismatics.utils.Constants
import com.thunder.apps.securenumismatics.utils.GlideLoader

class SettingsActivity : BaseActivity(), View.OnClickListener {
    private lateinit var mUserDetails : User
    private lateinit var binding : ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpActionBar()

        binding.btnLogout.setOnClickListener(this)
        binding.tvEdit.setOnClickListener(this)


    }

    @SuppressLint("SetTextI18n")
    fun userDetailSuccess(user : User){

        mUserDetails = user

        hideProgressDialog()

        binding.tvGender.text = user.gender
        binding.tvEmail.text = user.email
        binding.tvMobileNumber.text = user.mobile.toString()
        binding.tvName.text = "${user.firstName} ${user.lastName}"

       GlideLoader(this).loadUserProfile(user.image,binding.ivUserPhoto)
    }

    private fun setUpActionBar(){
        setSupportActionBar(binding.toolbarSettingActivity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back_button_white_24)

        binding.toolbarSettingActivity.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun getUserDetails(){
        showProgressDialog(getString(R.string.please_wait))
        FireStoreClass().getUserDetails(this)
    }

    override fun onResume() {
        getUserDetails()
        super.onResume()
    }
    private fun alertDialogLogout() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.app_name))
        builder.setMessage("Are you sure you want to Logout?")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("Yes") { dialogInterface, _ ->
            dialogInterface.dismiss()
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this@SettingsActivity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
        builder.setNegativeButton("No") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }

    override fun onClick(v: View?) {
        if (v != null){
            when(v.id){
                R.id.btn_logout-> alertDialogLogout()
                R.id.tv_edit->{
                    val intent = Intent(this@SettingsActivity,UserProfileActivity::class.java)
                    intent.putExtra(Constants.EXTRA_USER_DETAILS,mUserDetails)
                    startActivity(intent)
                }

                }
            }

        }
    }
