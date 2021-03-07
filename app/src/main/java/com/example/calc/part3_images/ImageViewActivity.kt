package com.example.calc.part3_images

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.nfc.Tag
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.request.RequestOptions
import com.example.calc.R
import jp.wasabeef.glide.transformations.*
import kotlinx.android.synthetic.main.activity_image_view.*
import java.lang.NullPointerException


class ImageViewActivity : AppCompatActivity() {
    //A variable that is equal to the position of the selected item of the spinner
    var getPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)

        supportActionBar?.hide()
        loadAllURLFiles()
        buttonListeners()
        addSpinner()

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
                ViewWithImages.setImageResource(R.drawable.cat)
                ViewWithImages.tag = Tags.CAT.tag
                transformation(getPosition)
            }
            1 -> {
                ViewWithImages.setImageResource(R.drawable.shark)
                ViewWithImages.tag = Tags.SHARK.tag
                transformation(getPosition)
            }
            2 -> {
                displayImageFromCache(getString(R.string.mouse_img), ViewWithImages)
                ViewWithImages.tag = Tags.MOUSE.tag
                transformation(getPosition)
            }
            3 -> {
                displayImageFromCache(getString(R.string.goat_img), ViewWithImages)
                ViewWithImages.tag = Tags.GOAT.tag
                transformation(getPosition)
            }
            4 -> {
                ViewWithImages.setImageResource(R.drawable.horse)
                ViewWithImages.tag = Tags.HORSE.tag
                transformation(getPosition)
            }
        }
    }


    @SuppressLint("CheckResult")
    private fun loadImageFromURL(url: String) {
        Glide.with(this)
                .load(url)
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
        loadImageFromURL(getString(R.string.mouse_img))
        loadImageFromURL(getString(R.string.goat_img))
        progressBar.visibility = ProgressBar.INVISIBLE
    }


    /**
     * Depending on the position of the spinner,
     * a transformation is selected
     */
    private fun transformation(position: Int) {
        when (position) {
            1 -> getTransformation(BlurTransformation(25, 3))
            2 -> getTransformation(GrayscaleTransformation())
            3 -> getTransformation(RoundedCornersTransformation(90, 90))
            4 -> getTransformation(CropCircleTransformation())
            0 -> noTransformation()
        }
    }


    /**
     * A method that returns an image depending on the tag
     */
    private fun getTag(): Any? {

        when (ViewWithImages.tag) {
            Tags.CAT.tag -> return R.drawable.cat
            Tags.MOUSE.tag -> return getString(R.string.mouse_img)
            Tags.GOAT.tag -> return getString(R.string.goat_img)
            Tags.SHARK.tag -> return R.drawable.shark
            Tags.HORSE.tag -> return R.drawable.horse
        }
        throw NullPointerException()
    }

    /**
     * The method that loads the image with the applied
     * transformation, which is passed to the parameter
     */
    private fun getTransformation(any: Any) {
        Glide.with(this).load(getTag())
                .apply(RequestOptions.bitmapTransform(any as Transformation<Bitmap>))
                .into(ViewWithImages)
    }

    private fun noTransformation() {
        Glide.with(this).load(getTag()).into(ViewWithImages)
    }

    /**
    Adding a spinner to an activity and setting a listener for it
     */
    private fun addSpinner() {
        val arrayAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
                this, R.array.transformation, android.R.layout.simple_spinner_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                getPosition = position
                transformation(position)
            }

        }
    }

}