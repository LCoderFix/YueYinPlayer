package com.example.yueyinplayer.util

import android.content.Context
import android.util.Log

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/5
 */
class MasterLog() {
    companion object{
        val instance:MasterLog by lazy { MasterLog() }
    }
    fun e(msg: String){
        e(null,msg)
    }
    fun e(tag:String?,msg:String){
        Log.e(tag,msg)
    }

}