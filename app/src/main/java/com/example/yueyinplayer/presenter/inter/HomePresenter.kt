package com.example.yueyinplayer.presenter.inter


/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/5
 */
interface HomePresenter {
    /**
     * 加载数据  初始化or刷新
     */
    fun loadData()

    /**
     * 加载更多
     */
    fun loadMore()
}