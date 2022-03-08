package com.example.sqlitedemo

class student constructor(var name:String, var course:String) {
    var id:Int?=null
    constructor(id:Int, name:String, course:String):this(name, course)
}
