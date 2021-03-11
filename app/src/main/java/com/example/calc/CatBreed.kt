package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cat_breed.*

class CatBreed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_breed)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        tagsRV.layoutManager = linearLayoutManager
        val tags = ArrayList<String>()
        val images = ArrayList<Int>()
        addCats(tags,images)
        val adapter = TagsAdapter(tags, images)
        tagsRV.adapter = adapter
    }
    fun addCats(tags:ArrayList<String>,images:ArrayList<Int>){
        tags.add("Персидская кошка (перс. گربهٔ ایرانی \u200E / Gorbe-ye irāni, «иранский кот») — порода длинношёрстных кошек, одна из старейших и самых популярных в мире.\n" +
                "\n")
        images.add(R.drawable.pers_cat)
        tags.add("Американская короткошерстная (ASH) — порода домашней кошек, которые, предположительно, произошли от европейских кошек, привезенных в Северную Америку ранними поселенцами для защиты ценного груза от мышей и крыс[1]. По данным Ассоциации любителей кошек, в 2012 году это была седьмая по популярности породистая кошка в Соединенных Штатах[2].\n" +
                "\n")
        images.add(R.drawable.amer_cat)
    }
}