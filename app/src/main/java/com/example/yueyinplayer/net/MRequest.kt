package com.example.yueyinplayer.net

import com.example.yueyinplayer.exts.MyTag
import com.example.yueyinplayer.util.MasterLog
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.ParameterizedType


/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/4
 */
open class MRequest<REQUEST>(val type:Int,val url: String, val reqHandler: ReqHandler<REQUEST>) {
    fun execute() {
        NetManger(this).execute()
    }

    fun parseResult(result: String): REQUEST {
        val gson = Gson()
        val type = (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return gson.fromJson<REQUEST>(result, type)
    }
}