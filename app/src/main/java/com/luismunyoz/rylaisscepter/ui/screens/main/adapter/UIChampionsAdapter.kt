package com.luismunyoz.rylaisscepter.ui.screens.main.adapter

import android.widget.ImageView
import android.widget.TextView
import com.luismunyoz.rylaisscepter.R
import com.luismunyoz.rylaisscepter.ui.entity.UIChampion
import com.luismunyoz.rylaisscepter.ui.util.BaseAdapter

/**
 * Created by llco on 12/09/2017.
 */
class UIChampionsAdapter(var items: List<UIChampion>, var callback: Callback) : BaseAdapter() {

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

    fun updateItem(position: Int, uiChampion: UIChampion){
        items.find { it.id == uiChampion.id }?.apply {
            primaryTextColor = uiChampion.primaryTextColor
            primaryColor = uiChampion.primaryColor
            primaryTitleColor = uiChampion.primaryTitleColor
            lightColor = uiChampion.lightColor
            darkColor = uiChampion.darkColor
        }
        notifyItemChanged(position)
    }

    public interface Callback {
        fun onChampionPressed(champion : UIChampion, championImage: ImageView, championName: TextView)
        fun calculateColors(position: Int, champion: UIChampion)
    }
}