package com.example.a1lesson5

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val hideTextViewSampleTransition by lazy {
            val transitionSet = TransitionSet()
             transitionSet.duration = 50000 // duration for test, i know it should be less then 300
             transitionSet.ordering = TransitionSet.ORDERING_TOGETHER

             transitionSet.addTransition(Fade(Fade.OUT))
             transitionSet.addTransition(ChangeBounds())
             transitionSet

        }

        val showTextViewSampleTransition by lazy {

            TransitionSet().duration = 50000 // duration for test, i know it should be less then 300
            TransitionSet().ordering = TransitionSet.ORDERING_TOGETHER
            TransitionSet().addTransition(Fade(Fade.IN))
            TransitionSet().addTransition(ChangeBounds())

        }

        button_transition_animation.setOnClickListener{
            val constraintSetSampleTextViewIsVisible = linerLayout.isVisible

            val transitionSet = if (constraintSetSampleTextViewIsVisible){
                hideTextViewSampleTransition
            } else{
                showTextViewSampleTransition
            }

            textView.setText("Hello button_transiniom_animation ")
            TransitionManager.beginDelayedTransition(linerLayout)
            linerLayout.isVisible = !linerLayout.isVisible
        }

        imageButton.setOnClickListener {
            if (editTextPersonName.text.isEmpty()){
                textView.setText("Hello no name Cat")
            }
            else{
                textView.setText("Hello "+editTextPersonName.text)


        }


        }

        button_object_animation.setOnClickListener {
            val animator = ObjectAnimator.ofFloat(linerLayout, View.ALPHA,0f,1f)

            animator.duration = 300
            animator.repeatMode = ValueAnimator.REVERSE
            animator.repeatCount = 5

            animator.start()
        }



    }
}