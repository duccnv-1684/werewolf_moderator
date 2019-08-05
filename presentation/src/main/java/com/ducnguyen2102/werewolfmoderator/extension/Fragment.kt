package com.ducnguyen2102.werewolfmoderator.extension

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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