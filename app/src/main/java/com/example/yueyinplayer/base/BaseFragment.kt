package com.example.yueyinplayer.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.yueyinplayer.exts.MyTag
import com.example.yueyinplayer.util.MasterLog

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/4
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return View.inflate(activity,getLayoutId(),null)
    }

    abstract fun getLayoutId(): Int


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        MasterLog.instance.e(MyTag,"onActivityCreated")
        initListener()
        initData()
    }

    open fun initListener() {

    }

    open fun initData() {

    }

    fun myToast(msg:String){
        Toast.makeText(activity,msg,Toast.LENGTH_LONG).show()
    }



}