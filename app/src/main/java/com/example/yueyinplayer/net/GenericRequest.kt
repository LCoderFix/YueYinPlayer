package com.example.yueyinplayer.net


/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/4
 */
class GenericRequest<REQUEST>(val url:String,val reqHandler:ReqHandler<REQUEST>) {
    fun execute(){
        NetWorkManger(this).execute()
    }
}