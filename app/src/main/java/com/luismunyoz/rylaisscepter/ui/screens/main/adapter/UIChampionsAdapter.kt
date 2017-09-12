package com.luismunyoz.rylaisscepter.ui.screens.main.adapter

import com.luismunyoz.rylaisscepter.R
import com.luismunyoz.rylaisscepter.ui.entity.UIChampion
import com.luismunyoz.rylaisscepter.ui.util.BaseAdapter

/**
 * Created by llco on 12/09/2017.
 */
class UIChampionsAdapter(var items: List<UIChampion>, var callback: Callback) : BaseAdapter() {

    override fun getItemForPosition(position: Int): Any {
        return items.get(position)
    }

    override fun getListener(): Any {
        return callback
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.layout_champion_item
    }

    override fun getItemCount(): Int {
        return items.size
    }

    public interface Callback {
        fun onChampionPressed(champion : UIChampion)
    }
}