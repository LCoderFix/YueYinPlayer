package com.example.yueyinplayer.view.fragment

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yueyinplayer.R
import com.example.yueyinplayer.adapter.HomeAdapter
import com.example.yueyinplayer.base.BaseFragment
import com.example.yueyinplayer.bean.ArticlesInfo
import com.example.yueyinplayer.exts.MyTag
import com.example.yueyinplayer.presenter.imp.HomePresenter
import com.example.yueyinplayer.util.MasterLog
import com.example.yueyinplayer.view.inter.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/5
 */
class HomeFragment : BaseFragment(), HomeView {
    private val presenter = HomePresenter(this)
    private var adapter: HomeAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun loadData(response: ArticlesInfo) {
        myToast("请求成功" + response.msg)
        val list=ArrayList<String>()
        for(index in 1..10)
            list.add("hello")
        adapter?.updateList(list)
    }

    override fun loadMore(response: ArticlesInfo) {
        myToast("请求成功" + response.msg)
        val list=ArrayList<String>()
        list.add("world")
        adapter?.loadMore(list)
    }

    override fun onError(msg: String) {
        myToast(msg)
    }

    override fun initListener() {
        adapter = activity?.let { HomeAdapter(it) }
        recyclerview.layoutManager = LinearLayoutManager(activity)
        recyclerview.adapter = adapter
        recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val manager = recyclerView.layoutManager as LinearLayoutManager
                if (newState == RecyclerView.SCROLL_STATE_IDLE && manager.findLastCompletelyVisibleItemPosition()+1 == manager.itemCount){
                    presenter.loadMore()
                }
            }
        })
    }

    override fun initData() {
        presenter.loadData()
    }
}