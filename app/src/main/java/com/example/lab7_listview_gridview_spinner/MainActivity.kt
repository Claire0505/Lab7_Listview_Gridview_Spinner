package com.example.lab7_listview_gridview_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.lab7_listview_gridview_spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //在Activity中使用View Binding
    private lateinit var binding: ActivityMainBinding
    private val itemsData = ArrayList<ItemData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //從R圖取圖片資源檔
        val imgArray = resources.obtainTypedArray(R.array.imgArray)
        val nameArray = resources.getStringArray(R.array.nameArray)
        //建立項目物件，放入圖片資源與名稱
        for (i in 0 until imgArray.length()){
            itemsData.add(ItemData(imgArray.getResourceId(i, 0), nameArray[i]))
        }
        //回收TypeArray
        imgArray.recycle()
        //連結Adapter，設定layout為adapter_horizontal
        binding.spinner.adapter = MyAdapter(R.layout.custom_adapter_horizintal, itemsData)

        //設定橫向顯示的項目筆數
        binding.gridView.numColumns = 3
        //連結Adapter，設定layout為adapter_vertical
        binding.gridView.adapter = MyAdapter(R.layout.custom_adapter_vertical, itemsData)

        //連結Adapter，設定layout為simple_list_item_1與字串陣列
        binding.listView.adapter =
            //ArrayAdapter(this, android.R.layout.simple_list_item_1, nameArray)
            MyAdapter(R.layout.custom_adapter_horizintal, itemsData)
    }
}

