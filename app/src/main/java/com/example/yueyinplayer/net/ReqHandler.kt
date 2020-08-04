package com.example.yueyinplayer.net

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/4
 */
interface ReqHandler<REQUEST> {
    /**
     * 请求数据失败时回调
     */
    fun onError(msg:String)

    /**
     * 请求数据成功时回调
     */
    fun onSuccess(list:List<REQUEST>)
}