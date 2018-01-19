package com.luismunyoz.rylaisscepter.domain.interactor.event

import com.luismunyoz.rylaisscepter.domain.entity.BaseChampion
import com.luismunyoz.rylaisscepter.domain.entity.Champion
import com.luismunyoz.rylaisscepter.domain.interactor.base.Event

/**
 * Created by llco on 11/09/2017.
 */
data class BaseChampionEvent(val baseChampion: BaseChampion?) : Event