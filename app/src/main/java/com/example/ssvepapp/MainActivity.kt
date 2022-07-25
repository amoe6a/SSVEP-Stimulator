package com.example.ssvepapp

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val freqL: Long = 8
        val freqR: Long = 16
        val freqB: Long = 12
        val freqF: Long = 20

        blink(findViewById(R.id.textForward), freqF)
        blink(findViewById(R.id.textBack), freqB)
        blink(findViewById(R.id.textRight), freqR)
        blink(findViewById(R.id.textLeft), freqL)
    }

    private fun blink(textv: TextView, freq: Long) {
        val initColor = "#070707"  // Strong dark grey
        val blinkColor = "#FFFFFF" // White

//        textv.setBackgroundColor(Color.parseColor(blinkColor));
        val anim: ObjectAnimator = ObjectAnimator.ofInt(textv, "backgroundColor",
            Color.parseColor(initColor), Color.parseColor(blinkColor), Color.parseColor(initColor))
        val duration = 1000/freq
        anim.duration = duration
        anim.setEvaluator(ArgbEvaluator())
//        anim.repeatMode = ValueAnimator.REVERSE
        anim.repeatCount = ValueAnimator.INFINITE
        anim.start()
    }
}