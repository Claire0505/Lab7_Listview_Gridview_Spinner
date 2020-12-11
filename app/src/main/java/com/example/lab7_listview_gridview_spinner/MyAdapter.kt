package com.example.lab7_listview_gridview_spinner

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter constructor(private val layout: Int,
                            private val data: ArrayList<ItemData>): BaseAdapter() {

    //回傳項目筆數
    override fun getCount(): Int {
        return data.size
    }
    //回傳某筆項目
    override fun getItem(position: Int): Any {
        return data[position]
    }
    //回傳某筆項目Id
    override fun getItemId(position: Int): Long {
        return 0L
    }

    //取得畫面
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //建立畫面
        val view = View.inflate(parent?.context, layout, null)

        //根據position顯示圖片與名稱
        val img = view.findViewById<ImageView>(R.id.img_photo)
        img.setImageResource(data[position].photo)

        val tv = view.findViewById<TextView>(R.id.tv_name)
        tv.text = data[position].name

        return view
    }
}
