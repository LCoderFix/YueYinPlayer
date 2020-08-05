package com.example.yueyinplayer.net

import com.example.yueyinplayer.bean.ArticlesInfo

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/5
 */
class HomeRequest(type:Int,url:String,req:ReqHandler<ArticlesInfo>): MRequest<ArticlesInfo>(type,url,req){

}