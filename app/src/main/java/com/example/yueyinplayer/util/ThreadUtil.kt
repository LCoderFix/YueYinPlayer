package com.example.yueyinplayer.util

import android.os.Handler
import android.os.Looper

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/4
 */
class ThreadUtil private constructor(){
   companion object{
       val instance:ThreadUtil by lazy{ ThreadUtil() }
   }
    private val handler:Handler= Handler(Looper.getMainLooper())

    fun onMainThread(runnable: Runnable){
        handler.post(runnable)
    }
}