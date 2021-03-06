package com.example.calc.part3_images

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.example.calc.R
import com.example.calc.part8_change_color.ChangeActivityColors
import com.example.calc.part8_change_color.SwitchStatus
import jp.wasabeef.glide.transformations.*
import kotlinx.android.synthetic.main.activity_image_view.*


class ImageViewActivity : AppCompatActivity() {
    //A variable that is equal to the position of the selected item of the spinner
    var getPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)

        //change theme
        val changeActivityColors: ChangeActivityColors = ChangeActivityColors()
        if (SwitchStatus.isSwitchButton())
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        supportActionBar?.hide()
        loadAllURLFiles()
        buttonListeners()
        addSpinner()
        ifItemSelected()

    }


    /**
     * The method in which the logic of
     * switching images is implemented
     */
    private fun buttonListeners() {
        var count = 0;
        setImagesAndTransformation(count)
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
                displayImageFromCache(getString(R.string.mouse_img), imageViewChangeColor)
                imageViewChangeColor.tag = "mouse"
                transformation(getPosition)
            }
            3 -> {
                displayImageFromCache(getString(R.string.goat_img), imageViewChangeColor)
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


    private fun loadImageFromURL(url: String, imageView: ImageView) {
        Glide.with(this)
                .load(url)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, dataSource: com.bumptech.glide.load.DataSource?, isFirstResource: Boolean): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }
                })
                .into(imageView)


        // return Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView)
    }

    private fun displayImageFromCache(url: String, imageView: ImageView) {
        Glide.with(this)
                .load(url)
                .onlyRetrieveFromCache(true)
                .into(imageView);
    }

    /**
     * The method that downloads pictures from the Internet when activating
     */
    private fun loadAllURLFiles() {
        loadImageFromURL(getString(R.string.mouse_img), imageViewChangeColor)
        loadImageFromURL(getString(R.string.goat_img), imageViewChangeColor)
    }


    /**
     * The method that applies transformation
     * when changing the item of the spinner
     */
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