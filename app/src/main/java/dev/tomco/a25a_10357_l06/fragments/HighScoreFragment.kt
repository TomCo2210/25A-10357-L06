package dev.tomco.a25a_10357_l06.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import dev.tomco.a25a_10357_l06.R
import dev.tomco.a25a_10357_l06.interfaces.Callback_HighScoreItemClicked

class HighScoreFragment : Fragment() {

    private lateinit var highScore_ET_location: TextInputEditText

    private lateinit var highScore_BTN_send: MaterialButton

    var highScoreItemClicked: Callback_HighScoreItemClicked? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_high_score, container, false)
        findViews(v)
        initViews(v)
        return v
    }


    private fun initViews(v: View) {
        highScore_BTN_send.setOnClickListener { v: View ->
            var coordinates = highScore_ET_location.text?.split(",")
            var lat: Double = coordinates?.get(0)?.toDouble() ?: 0.0
            var lon: Double = coordinates?.get(1)?.toDouble() ?: 0.0

            itemClicked(lat, lon)
        }
    }

    private fun itemClicked(lat: Double, lon: Double) {
        highScoreItemClicked?.highScoreItemClicked(lat,lon)
    }

    private fun findViews(v: View) {
        highScore_ET_location = v.findViewById(R.id.highScore_ET_location)
        highScore_BTN_send = v.findViewById(R.id.highScore_BTN_send)
    }
}