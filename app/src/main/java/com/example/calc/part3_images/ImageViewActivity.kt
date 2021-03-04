package com.example.calc.part3_images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.calc.R
import com.example.calc.part8_change_color.ChangeActivityColors
import com.example.calc.part8_change_color.SwitchStatus
import jp.wasabeef.glide.transformations.*
import kotlinx.android.synthetic.main.activity_image_view.*

class ImageViewActivity : AppCompatActivity() {
    var getPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        supportActionBar?.hide()
        buttonListeners()
        addSpinner()
        ifItemSelected()

        val changeActivityColors: ChangeActivityColors = ChangeActivityColors()
        if (SwitchStatus.isSwitchButton())
            changeActivityColors.changeToLightTheme(animals_images)
        else changeActivityColors.changeToDarkTheme(animals_images)

    }


    /**
     * The method in which the logic of
     * switching images is implemented
     */
    private fun buttonListeners() {
        var count = 0;
        buttonNext.setOnClickListener {
            if (count < 5)
                count++
            setImagesAndTransformation(count)
        }

        buttonPrev.setOnClickListener {
            if (count > 0)
                count--
            setImagesAndTransformation(count)
        }
    }

    /**
     *A method in which, depending on the count parameter,
     * the image changes, and the transformation is applied
     */
    private fun setImagesAndTransformation(count: Int) {
        when (count) {
            0 -> {
                imageViewChangeColor.setImageResource(R.drawable.cat)
                imageViewChangeColor.tag = "cat"
                transformation(getPosition)
            }
            1 -> {
                imageViewChangeColor.setImageResource(R.drawable.shark)
                imageViewChangeColor.tag = "shark"
                transformation(getPosition)
            }
            2 -> {
                loadImageFromURL(getString(R.string.mouse_img), imageViewChangeColor)
                imageViewChangeColor.tag = "mouse"
                transformation(getPosition)
            }
            3 -> {
                loadImageFromURL(getString(R.string.goat_img), imageViewChangeColor)
                imageViewChangeColor.tag = "goat"
                transformation(getPosition)
            }
            4 -> {
                imageViewChangeColor.setImageResource(R.drawable.horse)
                imageViewChangeColor.tag = "horse"
                transformation(getPosition)
            }
        }
    }


    private fun loadImageFromURL(url: String, imageView: ImageView): Any {
        return Glide.with(this).load(url).into(imageView)
    }

    private fun ifItemSelected() {
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                getPosition = position
                transformation(position)
            }

        }
    }

    /**
     * Depending on the position of the spinner,
     * a transformation is selected
     */
    private fun transformation(position: Int) {
        if (position == 1)
            blurTransformation()
        else if (position == 2)
            grayscaleTransformation()
        else if (position == 3)
            roundedCornersTransformation()
        else if (position == 4)
            colorFilterTransformation()
        else if (position == 0)
            noTransformation()
    }

    /**
     * A method that returns an image depending on the tag
     */
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

    private fun roundedCornersTransformation() {
        Glide.with(this).load(getTag())
                .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(90, 90)))
                .into(imageViewChangeColor)
    }

    private fun colorFilterTransformation() {
        Glide.with(this).load(getTag())
                .apply(RequestOptions.bitmapTransform(CropCircleTransformation()))
                .into(imageViewChangeColor)
    }

    private fun noTransformation() {
        Glide.with(this).load(getTag()).into(imageViewChangeColor)
    }

    private fun addSpinner() {
        val arrayAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
                this, R.array.transformation, android.R.layout.simple_spinner_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
    }
    
}