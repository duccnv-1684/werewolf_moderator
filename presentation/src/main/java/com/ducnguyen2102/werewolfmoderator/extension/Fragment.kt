package com.ducnguyen2102.werewolfmoderator.extension

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.ducnguyen2102.werewolfmoderator.R

fun Fragment.showLoadingDialog(): AlertDialog =
        AlertDialog.Builder(activity!!).run {
            setView(R.layout.progress_dialog)
            setCancelable(false)
        }.create().apply {
            setCanceledOnTouchOutside(false)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

fun Fragment.hideKeyBoard() {
    val imm = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = activity?.currentFocus
    if (view == null) {
        view = View(activity)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}