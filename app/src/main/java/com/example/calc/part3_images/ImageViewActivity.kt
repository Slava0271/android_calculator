package com.example.calc.part3_images

import android.annotation.SuppressLint
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.calc.R
import com.example.calc.part8_change_color.ChangeActivityColors
import com.example.calc.part8_change_color.SwitchStatus
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.GrayscaleTransformation
import jp.wasabeef.glide.transformations.MaskTransformation
import kotlinx.android.synthetic.main.activity_image_view.*
import java.lang.NullPointerException

class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        supportActionBar?.hide()
        addSpinner()
        ifItemSelected()
        drawFirstImage()
        buttonListeners()

        val changeActivityColors: ChangeActivityColors = ChangeActivityColors()
        if (SwitchStatus.isSwitchButton())
            changeActivityColors.changeToLightTheme(animals_images)
        else changeActivityColors.changeToDarkTheme(animals_images)

    }

    private fun drawFirstImage() {
        imageViewChangeColor.setImageResource(R.drawable.cat)
    }

    private fun buttonListeners() {
        var count = 0;
        buttonNext.setOnClickListener {
            if (count < 5)
                count++
            setImages(count)
        }

        buttonPrev.setOnClickListener {
            if (count > 0)
                count--
            setImages(count)
        }
    }

    private fun setImages(count: Int) {
        when (count) {
            0 -> {
                imageViewChangeColor.setImageResource(R.drawable.cat)
                imageViewChangeColor.tag = "cat"
            }
            1 -> {
                imageViewChangeColor.setImageResource(R.drawable.shark)
                imageViewChangeColor.tag = "shark"
            }
            2 -> {
                loadImageFromURL(getString(R.string.mouse_img), imageViewChangeColor)
                imageViewChangeColor.tag = "mouse"
            }
            3 -> {
                loadImageFromURL(getString(R.string.goat_img), imageViewChangeColor)
                imageViewChangeColor.tag = "goat"
            }
            4 -> {
                imageViewChangeColor.setImageResource(R.drawable.horse)
                imageViewChangeColor.tag = "horse"
            }
        }
    }


    private fun loadImageFromURL(url: String, imageView: ImageView): Any {
        return Glide.with(this).load(url).into(imageView)
    }

    private fun ifItemSelected() {
        var selectedItem:Int =0
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                if(selectedItem==1)
                    blurTransformation()
                if(selectedItem==2)
                    grayscaleTransformation()

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem=position
                //  2 -> grayscaleTransformation()
                if (position == 1)
                    blurTransformation()
                else if (position == 2)
                    grayscaleTransformation()
            }

        }
    }

    private fun getTag(): Any {
        var any: Any = ""

        when (imageViewChangeColor.tag) {
            "cat" -> any = R.drawable.cat
            "mouse" -> any = getString(R.string.mouse_img)
            "goat" -> any = getString(R.string.goat_img)
            "shark" -> any = R.drawable.shark
            "horse" -> any = R.drawable.horse
        }
        return any
    }

    private fun blurTransformation() {
        Glide.with(this).load(getTag())
                .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3)))
                .into(imageViewChangeColor)
    }

    private fun grayscaleTransformation() {
        Glide.with(this).load(getTag())
                .apply(RequestOptions.bitmapTransform(GrayscaleTransformation()))
                .into(imageViewChangeColor)
    }

    private fun addSpinner() {
        val arrayAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
                this, R.array.transformation, android.R.layout.simple_spinner_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
    }

}