package com.example.movetoimageview


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.*
import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {

        when (p0!!.id) {
            R.id.MoveButton -> {
                rotate()
            }

        }
    }

    private var buttonA: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MoveButton.setOnClickListener(this)
    }


    private fun rotate() {

        val r1 = ObjectAnimator.ofFloat(android, View.ROTATION, 0f, 90f)
        r1.setDuration(1000)
        r1.interpolator = BounceInterpolator()

        val anims2 = AnimatorSet()

        val tx1 = ObjectAnimator.ofFloat(android, View.TRANSLATION_X, 0f, 1400f)
        tx1.setDuration(1000)
        tx1.interpolator = BounceInterpolator()

        anims2.play(r1).before(tx1)

        val final_anim = AnimatorSet();

        final_anim.play(anims2)

        final_anim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
//                Toast.makeText(applicationContext, "Animation Fininsed", Toast.LENGTH_SHORT).show();
                rotate_after()
            }

            override fun onAnimationStart(p0: Animator?) {
//                Toast.makeText(applicationContext, "Animation Started", Toast.LENGTH_SHORT).show();

            }

        });

        final_anim.start()

    }

    private fun rotate_after() {

        val tx3 = ObjectAnimator.ofFloat(android2, View.TRANSLATION_X, 0f, 1400f)
        tx3.setDuration(1000)
        tx3.interpolator = BounceInterpolator()

        val anims3 = AnimatorSet()

        anims3.play(tx3)

        val next_anim = AnimatorSet();
        next_anim.play(anims3)

        next_anim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                rotate_after2();
            }

            override fun onAnimationStart(p0: Animator?) {

            }

        });

        next_anim.start()
    }

    private fun rotate_after2() {

        android3.visibility = View.VISIBLE

        val tx4 = ObjectAnimator.ofFloat(android3, View.TRANSLATION_X, 0f, 1400f)
        tx4.setDuration(1000)
        tx4.interpolator = BounceInterpolator()


        val anims4 = AnimatorSet()

        anims4.play(tx4)

        val next2_anim = AnimatorSet();
        next2_anim.play(anims4)

        next2_anim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {

            }

        });

        next2_anim.start()

    }



}
