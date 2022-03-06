package com.example.otherapplication.customview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

class EventViewGroup : FrameLayout {
    private val TAG: String = EventViewGroup::class.java.simpleName

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)

    init {

    }

    override fun onInterceptTouchEvent(event: MotionEvent?): Boolean {
//        if(event?.action == MotionEvent.ACTION_DOWN) {
//            return super.onInterceptTouchEvent(event)
//        }else if(event?.action == MotionEvent.ACTION_UP){
//            return true
//        }
        return super.onInterceptTouchEvent(event)
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
        } else if(event?.action == MotionEvent.ACTION_CANCEL){
            Log.e(TAG, "-----CANCEL-----")
        } else {
            Log.e(TAG, "-----MOVE-----")
        }
        var consume = super.dispatchTouchEvent(event)
        Log.e(TAG, "-----$consume-----")
        return consume
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        //val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        //val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        //val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        //setMeasuredDimension(widthSize, heightSize)
        //measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0)
        //childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY)
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec)
        Log.e(TAG, "-----onMeasure-----")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.e(TAG, "-----onLayout-----")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.e(TAG, "-----onDraw-----")
    }
}