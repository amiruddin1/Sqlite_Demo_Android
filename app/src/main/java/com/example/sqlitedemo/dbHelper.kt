package com.example.sqlitedemo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class dbHelper(var context: Context) :SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {
    companion object {
        private const val DB_NAME = "MyDemoDB"
        private const val DB_VERSION = 1
        private const val TBL_NAME = "Students"
        private const val ID = "id"
        private const val NAME = "Name"
        private const val COURSE = "course"
    }
    override fun onCreate(p0: SQLiteDatabase?) {
        var query = "Create Table $TBL_NAME ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NAME TEXT, $COURSE TEXT)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun insertRecord(std: student) :Boolean
    {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(NAME, std.name.toString())
        cv.put(COURSE,std.course.toString())
        db.insert(TBL_NAME,null,cv)
        db.close()
        return true
    }
    fun viewRecords() : ArrayList<student>
    {
        var studentArraylist:ArrayList<student> = ArrayList()
        var db = this.readableDatabase
        var cursor: Cursor = db.query(TBL_NAME,null,null,null,null,null,null)
        while(cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var course = cursor.getString(2)

            var stud:student=student(id,name,course)
            studentArraylist.add(stud)
        }
        return studentArraylist
    }
}