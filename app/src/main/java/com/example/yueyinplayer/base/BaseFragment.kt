package com.example.yueyinplayer.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/4
 */
abstract class BaseFragment : Fragment() {
    abstract fun getLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        initListener()
        initData()
        return inflater.inflate(getLayoutId(),container)
    }

    private fun initListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}