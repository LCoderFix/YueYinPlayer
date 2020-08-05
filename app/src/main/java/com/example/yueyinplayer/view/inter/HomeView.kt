package com.example.yueyinplayer.view.inter

import com.example.yueyinplayer.bean.ArticlesInfo

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/5
 */
interface HomeView {

    fun loadData(response: ArticlesInfo)

    fun loadMore(response:ArticlesInfo)

    fun onError(msg: String)
}