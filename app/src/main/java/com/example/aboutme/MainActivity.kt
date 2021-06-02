package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var edNickname: EditText? = null
    var tvNickname: TextView? = null
    var btnDone: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
    }

    //this is a comment
    private fun initComponents() {
        edNickname = findViewById<EditText>(R.id.nickname_edit)
        tvNickname = findViewById<TextView>(R.id.nickname_text)
        btnDone = findViewById(R.id.done_button)
        btnDone?.setOnClickListener { addNickname(it) }
        tvNickname?.setOnClickListener { updateNickname(it) }
    }

    private fun addNickname(view: View) {
        tvNickname?.text = edNickname?.text
        edNickname?.visibility = View.GONE
        view.visibility = View.GONE
        tvNickname?.visibility = View.VISIBLE
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        edNickname?.visibility = View.VISIBLE
        btnDone?.visibility = View.VISIBLE
        view.visibility = View.GONE
    }
}