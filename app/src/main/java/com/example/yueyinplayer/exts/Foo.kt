package com.example.yueyinplayer.exts

import java.lang.reflect.ParameterizedType

/**
 * @Description:
 * @author liujundong
 * @Date: 2020/8/5
 */
open class Foo <T>{

}
class Cat: Foo<String>() {
    fun printName(){
        var myType=this.javaClass.genericSuperclass as ParameterizedType
        val type = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        println(type)
    }
}