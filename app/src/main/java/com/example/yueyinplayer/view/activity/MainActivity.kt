package com.example.yueyinplayer.view.activity

import com.example.yueyinplayer.R
import com.example.yueyinplayer.base.BaseActivity
import com.example.yueyinplayer.view.fragment.HomeFragment


/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/4
 */
class MainActivity : BaseActivity()  {
//    override var toolBar: Toolbar = toolbar
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        supportFragmentManager.beginTransaction().add(R.id.frame_layout,HomeFragment()).commit()
    }
}