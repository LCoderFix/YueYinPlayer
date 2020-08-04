package com.example.yueyinplayer.net

import com.example.yueyinplayer.util.ThreadUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException
import java.lang.reflect.ParameterizedType

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/4
 */
class NetWorkManger<REQUEST>(private val req: GenericRequest<REQUEST>) {
     fun execute() {
        val client = OkHttpClient()
        val request = Request.Builder().url(req.url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.instance.onMainThread(Runnable { req.reqHandler.onError(e.toString()) })
                req.reqHandler.onError(e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val gson = Gson()
                val superClass = NetWorkManger::class.java.genericSuperclass as ParameterizedType
                val type = superClass.actualTypeArguments[0]
                val list = gson.fromJson<List<REQUEST>>(response.body().toString(), type)
                ThreadUtil.instance.onMainThread(Runnable { req.reqHandler.onSuccess(list) })
            }
        })
    }
}