package com.example.sqlitedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd.setOnClickListener {
            var student = student(edtName.text.toString(),edtCourse.text.toString())
            var db :dbHelper = dbHelper(this)
            if (db.insertRecord(student))
            {
                Toast.makeText(this, "Records Inserted SuccessFully...", Toast.LENGTH_LONG).show()
                edtName.setText("")
                edtCourse.setText("")
            }
            else
            {
                Toast.makeText(this, "Kucch TO Garbad Hai Dayaaa...", Toast.LENGTH_LONG).show()
            }
        }
        btnview.setOnClickListener {
            var db = dbHelper(this)
            var arraylist =  db.viewRecords()
            var ad = MyAdapter(arraylist)
            var rv:RecyclerView = findViewById(R.id.recyclerview)
            rv.setAdapter(ad)
            rv.addItemDecoration(DividerItemDecoration(applicationContext,DividerItemDecoration.VERTICAL))
//            )

        }
    }
}