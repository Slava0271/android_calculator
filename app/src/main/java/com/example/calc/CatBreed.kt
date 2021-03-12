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
        addAllBreeds(tags,images)
        val adapter = TagsAdapter(tags, images)
        tagsRV.adapter = adapter
    }
    private fun addAllBreeds(tags:ArrayList<String>, images:ArrayList<Int>){
        val persCatStr:String = "Персидская кошка (перс. گربهٔ ایرانی \u200E / Gorbe-ye irāni, «иранский кот») — порода длинношёрстных кошек, одна из старейших и самых популярных в мире.\n"
        val amerCatStr:String=  "Американская короткошерстная (ASH) — порода домашней кошек, которые, предположительно, произошли от европейских кошек, привезенных в Северную Америку ранними поселенцами для защиты ценного груза от мышей и крыс[1]. По данным Ассоциации любителей кошек, в 2012 году это была седьмая по популярности породистая кошка в Соединенных Штатах[2].\n"
        val britishCatStr:String = "Британские короткошёрстные (рус. — британцы) — короткошёрстные кошки. Как правило, это сильные и крепкие кошки. Бывают от средних до крупных размеров. Согласно легенде, являются потомками Чеширского кота.\n"
        val savannaCatImg:String=  "Саванна (кошка) — порода кошек. Гибрид домашней кошки и африканского сервала.Саванна является крупной кошкой. Её рост в холке достигает 60 см, а вес доходит до 15 кг. Отличительные особенности саванны — продолговатое тело, вытянутая шея, длинные лапы, большие округлые уши и густая пятнистая шерсть. От других пород отличается более развитым интеллектом.\n"

        addBreed(tags,images,persCatStr,R.drawable.pers_cat)
        addBreed(tags,images,amerCatStr,R.drawable.amer_cat)
        addBreed(tags,images,britishCatStr,R.drawable.british_cat)
        addBreed(tags,images,savannaCatImg,R.drawable.savana_cat)

    }

    private fun addBreed(tags:ArrayList<String>,images:ArrayList<Int>,text: String,img:Int){
        tags.add(text)
        images.add(img)
    }
}