package com.example.otherapplication.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

class EventButton : androidx.appcompat.widget.AppCompatButton {
    private val TAG: String = EventButton::class.java.simpleName

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)

    init {

    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {}
            MotionEvent.ACTION_MOVE -> {}
            MotionEvent.ACTION_UP -> {}
            MotionEvent.ACTION_CANCEL -> {}
        }
        if(event?.action == MotionEvent.ACTION_DOWN){
            Log.e(TAG, "-----DOWN-----")
        } else if(event?.action == MotionEvent.ACTION_UP){
            Log.e(TAG, "-----UP-----")
            Log.e(TAG, "---isPressed--$isPressed-----")
        } else if(event?.action == MotionEvent.ACTION_CANCEL){
            Log.e(TAG, "-----CANCEL-----")
        } else {
            Log.e(TAG, "-----MOVE-----")
            Log.e(TAG, "---isPressed--$isPressed-----")
        }
        var consume = super.dispatchTouchEvent(event)
        Log.e(TAG, "-----$consume-----")
        return consume
    }
}