package com.luismunyoz.rylaisscepter.ui.util

import android.databinding.BindingAdapter
import android.databinding.ViewDataBinding
import android.graphics.drawable.Drawable
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.luismunyoz.rylaisscepter.BR
import com.bumptech.glide.request.animation.GlideAnimation
import android.graphics.Bitmap
import com.bumptech.glide.request.target.SimpleTarget
import android.R.attr.bitmap
import android.support.v7.graphics.Palette
import android.view.View
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.textColor
import android.graphics.drawable.GradientDrawable




/**
 * Created by llco on 12/09/2017.
 */
class DataBindingViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Any, listener: Any){
        binding.setVariable(BR.item, item)
        binding.setVariable(BR.listener, listener)
        binding.executePendingBindings()
    }

    companion object {
        @BindingAdapter("app:srcCompat")
        @JvmStatic
        fun setImage(imageView: ImageView, resourceId: Int){
            val drawable : Drawable? = VectorDrawableCompat.create(imageView.resources, resourceId, imageView.context.theme)
            imageView.setImageDrawable(drawable)
        }

        @BindingAdapter("app:srcCompat")
        @JvmStatic
        fun setImage(imageView: ImageView, drawable: Drawable){
            imageView.setImageDrawable(drawable)
        }

        @BindingAdapter("app:imageUrl")
        @JvmStatic
        fun loadImage(imageView: ImageView, url: String){
            Glide.with(imageView.context).load(url).into(imageView)
        }

        @BindingAdapter("app:backgroundColorBasedUrl")
        @JvmStatic
        fun loadColorPalette(textView: TextView, url: String){
            Glide.with(textView.context).load(url).asBitmap().into(object : SimpleTarget<Bitmap>(){
                override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
                    val palette : Palette = Palette.from(resource).generate()
                    if(palette.vibrantSwatch != null){
                        val vibrantSwatch : Palette.Swatch = palette.vibrantSwatch!!

                        val gd = GradientDrawable(
                                GradientDrawable.Orientation.LEFT_RIGHT,
                                intArrayOf(vibrantSwatch.rgb, 0x00000000.toInt()))
                        textView.background = gd
                        textView.textColor = vibrantSwatch.titleTextColor
                        textView.visibility = View.VISIBLE
                    }
                }
            })
        }
    }



}