package com.example.fragmentdemo02

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar


class ToolbarFragment : Fragment(), SeekBar.OnSeekBarChangeListener {

    var seekVal = 10

    lateinit var activityCallback: ToolbarFragment.ToolbarListener

    interface ToolbarListener {
        fun onButtonClick(fontSize: Int, text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        activityCallback = context as ToolbarListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toolbar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.buttonChange)
        button.setOnClickListener {
            buttonClicked(view)
        }

        val seekBar = view.findViewById<SeekBar>(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(this)
    }

    private fun buttonClicked(view: View) {
        val inputText = view.findViewById<EditText>(R.id.editTextInput)
        activityCallback.onButtonClick(seekVal, inputText.text.toString())
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        seekVal = progress
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

}