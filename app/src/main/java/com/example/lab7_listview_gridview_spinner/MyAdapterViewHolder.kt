package com.example.lab7_listview_gridview_spinner

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapterViewHolder constructor(
        private val layout : Int, private val data: ArrayList<ItemData>) : BaseAdapter() {
    //ViewHolder類別，用來緩存畫面中的元件
    private class ViewHolder(v: View){
        val image_photo: ImageView = v.findViewById(R.id.img_photo)
        val tv_name : TextView = v.findViewById(R.id.tv_name)
    }
    //回傳項目筆數
    override fun getCount(): Int = data.size
    //回傳某筆項目
    override fun getItem(position: Int) = data[position]
    //回傳某筆項目Id
    override fun getItemId(position: Int) = 0L

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //由於convertView無法賦值，必須額外建立一個View物件
        val view : View
        //採用自訂的ViewHolder類別，用來緩存畫面中的元件
        val holder : ViewHolder

        if (convertView == null){
            //建立畫面
            view = View.inflate(parent?.context, layout, null)
            //建立viewHolder
            holder = ViewHolder(view)
            //將ViewHolder作為View的 Tag
            view.tag = holder
        } else{
            //從Tag取得ViewHolder畫面
            holder = convertView.tag as ViewHolder
            //取得畫面
            view = convertView
        }
        //根據position顯示圖片和名稱
        holder.image_photo.setImageResource(data[position].photo)
        holder.tv_name.text = data[position].name

        return view
    }


}