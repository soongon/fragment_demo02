package com.example.fragmentdemo02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class TextFragment : Fragment() {

    lateinit var viewContext: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewContext = view
    }

    fun changeTextProperties(fontSize: Int, text: String) {
        val resultText = viewContext.findViewById<TextView>(R.id.textDisplay)
        resultText.textSize = fontSize.toFloat()
        resultText.text = text
    }

}