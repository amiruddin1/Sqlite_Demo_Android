package com.example.sqlitedemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.recycleitem.view.*

class MyAdapter(var arrStudent:ArrayList<student>)
    : RecyclerView.Adapter<MyAdapter.ViewHolder> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
        var layoutInflater= LayoutInflater.from(parent.context)
        var view=layoutInflater.inflate(R.layout.recycleitem,
            parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder
                (holder: ViewHolder, position:Int) {
        holder.bind(arrStudent[position])
    }

    override fun getItemCount(): Int {
        return arrStudent.size
    }

    class ViewHolder(var viewItem: View):
        RecyclerView.ViewHolder(viewItem)
    {
        init {
            viewItem.setOnClickListener {
                var msg="Item Clicked on position" +
                        " $adapterPosition"
                Snackbar.make(viewItem,msg, Snackbar.LENGTH_LONG).show()
            }
        }
        fun bind(std:student)
        {
            viewItem.txtID.text=std.id.toString()
            viewItem.txtName.text=std.name
            viewItem.txtCourse.text = std.course
        }

    }

}