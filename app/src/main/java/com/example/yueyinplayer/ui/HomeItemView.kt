package com.example.yueyinplayer.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.yueyinplayer.R

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/5
 */
class HomeItemView : RelativeLayout {
    constructor(context: Context?) : super(context){
        View.inflate(context, R.layout.home_item_view,this)
    }
    constructor(context: Context?,attributes: AttributeSet) : super(context,attributes){
        View.inflate(context, R.layout.home_item_view,this)
    }
    constructor(context: Context?,attributes: AttributeSet,defStyleAttr:Int):super(context,attributes,defStyleAttr){
        View.inflate(context, R.layout.home_item_view,this)
    }

}