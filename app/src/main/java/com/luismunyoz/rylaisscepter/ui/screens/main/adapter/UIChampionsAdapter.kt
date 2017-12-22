package com.luismunyoz.rylaisscepter.ui.screens.main.adapter

import android.widget.ImageView
import android.widget.TextView
import com.luismunyoz.rylaisscepter.R
import com.luismunyoz.rylaisscepter.ui.entity.UIBaseChampion
import com.luismunyoz.rylaisscepter.ui.util.BaseAdapter

/**
 * Created by llco on 12/09/2017.
 */
class UIChampionsAdapter(var items: List<UIBaseChampion>, var callback: Callback) : BaseAdapter() {

    override fun getItemForPosition(position: Int) : Any {
        val item = items.get(position)
        if(item.primaryTextColor == null && item.primaryColor == null && item.primaryTitleColor == null && item.lightColor == null && item.darkColor == null) {
            callback.calculateColors(position, item)
        }
        return item
    }

    override fun getListener() = callback

    override fun getLayoutIdForPosition(position: Int) = R.layout.layout_champion_item

    override fun getItemCount() = items.size

    fun updateItem(position: Int, uiBaseChampion: UIBaseChampion){
        items.find { it.id == uiBaseChampion.id }?.apply {
            primaryTextColor = uiBaseChampion.primaryTextColor
            primaryColor = uiBaseChampion.primaryColor
            primaryTitleColor = uiBaseChampion.primaryTitleColor
            lightColor = uiBaseChampion.lightColor
            darkColor = uiBaseChampion.darkColor
        }
        notifyItemChanged(position)
    }

    public interface Callback {
        fun onChampionPressed(baseChampion: UIBaseChampion, championImage: ImageView, championName: TextView)
        fun calculateColors(position: Int, baseChampion: UIBaseChampion)
    }
}