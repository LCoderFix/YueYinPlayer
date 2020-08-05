package com.example.yueyinplayer.presenter.imp

import com.example.yueyinplayer.bean.ArticlesInfo
import com.example.yueyinplayer.const.IUrlProvider
import com.example.yueyinplayer.const.IUrlProvider.TYPE_REQUEST_INIT
import com.example.yueyinplayer.const.IUrlProvider.TYPE_REQUEST_LOAD_MORE
import com.example.yueyinplayer.exts.MyTag
import com.example.yueyinplayer.net.HomeRequest
import com.example.yueyinplayer.net.ReqHandler
import com.example.yueyinplayer.presenter.inter.HomePresenter
import com.example.yueyinplayer.util.MasterLog
import com.example.yueyinplayer.view.inter.HomeView

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/5
 */
class HomePresenter(private val view:HomeView):HomePresenter, ReqHandler<ArticlesInfo> {

    override fun onError(msg: String) {
        view.onError(msg)
    }

    override fun onSuccess(type:Int,response: ArticlesInfo) {
        when(type){
            TYPE_REQUEST_INIT->view.loadData(response)
            TYPE_REQUEST_LOAD_MORE->view.loadMore(response)
        }
    }

    override fun loadData(){
        HomeRequest(TYPE_REQUEST_INIT,IUrlProvider.ArticlesInfoUrl,this).execute()
    }

    override fun loadMore() {
        HomeRequest(TYPE_REQUEST_LOAD_MORE,IUrlProvider.ArticlesInfoUrl,this).execute()
    }
}