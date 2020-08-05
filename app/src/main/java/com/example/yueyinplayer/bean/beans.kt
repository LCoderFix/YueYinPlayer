package com.example.yueyinplayer.bean

import java.io.Serializable

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/5
 */
data class ArticlesInfo(
    val code: Int,
    val data: Data,
    val msg: String
):Serializable

data class Data(
    val articles: List<Article>,
    val page_num: Int
):Serializable

data class Article(
    val article_content: String,
    val article_ctime: Int,
    val article_id: Int,
    val article_title: String,
    val user_nickname: String
):Serializable