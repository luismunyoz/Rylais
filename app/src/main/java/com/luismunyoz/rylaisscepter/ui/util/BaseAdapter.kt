package com.luismunyoz.rylaisscepter.ui.util

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by llco on 12/09/2017.
 */
abstract class BaseAdapter : RecyclerView.Adapter<DataBindingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DataBindingViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent?.context)
        val binding : ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return DataBindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder?, position: Int) {
        val item = getItemForPosition(position)
        holder?.bind(item, getListener())
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    protected abstract fun getItemForPosition(position: Int) : Any

    protected abstract fun getListener() : Any

    protected abstract fun getLayoutIdForPosition(position: Int) : Int
}