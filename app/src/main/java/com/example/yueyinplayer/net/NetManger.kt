package com.example.yueyinplayer.net

import com.example.yueyinplayer.exts.MyTag
import com.example.yueyinplayer.util.MasterLog
import com.example.yueyinplayer.util.ThreadUtil
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.ParameterizedType

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/4
 */
class NetManger<REQUEST>(private val req: MRequest<REQUEST>) {
    private val client:OkHttpClient by lazy { OkHttpClient() }
    fun execute() {
        val request = Request.Builder().url(req.url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.instance.onMainThread(Runnable { req.reqHandler.onError(e.toString()) })
            }

            override fun onResponse(call: Call, response: Response) {
                response.body()?.string()?.let {
                    MasterLog.instance.e(MyTag, it)
                    ThreadUtil.instance.onMainThread(Runnable { req.reqHandler.onSuccess(req.type,req.parseResult(it)) })
                }
            }
        })
    }
}