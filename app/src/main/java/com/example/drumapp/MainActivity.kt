package com.example.drumapp

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Script
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var  mSoundPool : SoundPool
    private lateinit var  mSoundID: Array<Int?>
    private val mSoundResource = arrayOf(
        R.raw.symbal,
        R.raw.drum_sound,
        R.raw.guitar_sound,
        R.raw.piano_sound
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val audioAttributes= AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_MEDIA).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build()

        mSoundPool=SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(mSoundResource.size).build()

        mSoundID=arrayOfNulls(mSoundResource.size)

        for(i in 0..(mSoundResource.size - 1)){
            mSoundID[i]=mSoundPool.load(applicationContext,mSoundResource[i],0)
        }
    }

    override  fun onDestroy(){
        super.onDestroy()

        mSoundPool.release()
    }

    fun cymbal1(view: View){
        if(mSoundID[0] != null){
            mSoundPool.play(mSoundID[0] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }
    fun cymbal2(view: View){
        if(mSoundID[1] != null) {
            mSoundPool.play(mSoundID[1] as Int, 1.0F, 1.0F, 0, 0, 1.0F)
        }
    }

    fun drum1(view: View) {
        if (mSoundID[2] != null) {
            mSoundPool.play(mSoundID[2] as Int, 1.0F, 1.0F, 0, 0, 1.0F)
        }
    }

    fun drum2(view: View) {
        if (mSoundID[3] != null) {
            mSoundPool.play(mSoundID[3] as Int, 1.0F, 1.0F, 0, 0, 1.0F)
        }
    }

    fun guitra1(view: View) {
        if (mSoundID[4] != null) {
            mSoundPool.play(mSoundID[4] as Int, 1.0F, 1.0F, 0, 0, 1.0F)
        }
    }

    fun guitar2(view: View) {
        if (mSoundID[5] != null) {
            mSoundPool.play(mSoundID[5] as Int, 1.0F, 1.0F, 0, 0, 1.0F)
        }
    }

    fun piano1(view: View) {
        if (mSoundID[6] != null) {
            mSoundPool.play(mSoundID[6] as Int, 1.0F, 1.0F, 0, 0, 1.0F)
        }
    }

    fun piano2(view: View) {
        if (mSoundID[7] != null) {
            mSoundPool.play(mSoundID[7] as Int, 1.0F, 1.0F, 0, 0, 1.0F)
        }
    }
}