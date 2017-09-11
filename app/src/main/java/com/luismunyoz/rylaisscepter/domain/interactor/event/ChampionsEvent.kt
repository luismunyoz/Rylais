package com.luismunyoz.rylaisscepter.domain.interactor.event

import com.luismunyoz.rylaisscepter.data.model.Champion
import com.luismunyoz.rylaisscepter.domain.interactor.base.Event

/**
 * Created by llco on 11/09/2017.
 */
data class ChampionsEvent(val champions: List<Champion>) : Event