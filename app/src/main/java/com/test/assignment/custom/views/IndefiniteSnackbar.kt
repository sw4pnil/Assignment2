package com.test.assignment.custom.views

import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.test.assignment.R

object IndefiniteSnackbar {

    private var snackbar: Snackbar? = null

    fun show(view: View, text: String, action: () -> Unit) {
        snackbar = Snackbar.make(view, text, Snackbar.LENGTH_INDEFINITE).apply {
            setAction(view.context.getString(R.string.retry)) { action() }
            show()
        }
    }

    fun hide() {
        snackbar?.dismiss()
    }

}