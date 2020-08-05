package com.example.yueyinplayer.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.yueyinplayer.ui.HomeItemView
import com.example.yueyinplayer.ui.LoadMoreItemView

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/5
 */
class HomeAdapter (private val context:Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val list:ArrayList<String> =ArrayList<String>()

    //更新数据
    fun updateList(list: MutableList<String>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun loadMore(list: MutableList<String>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType==1) HomeViewHolder(HomeItemView(context)) else LoadMoreViewHolder(LoadMoreItemView(context))
    }

    override fun getItemCount(): Int {
        return list.size+1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return if(position==list.size) 2 else 1
    }

}

class HomeViewHolder(private val itemView:HomeItemView): RecyclerView.ViewHolder(itemView) {

}

class LoadMoreViewHolder(private var itemView: LoadMoreItemView):RecyclerView.ViewHolder(itemView){

}