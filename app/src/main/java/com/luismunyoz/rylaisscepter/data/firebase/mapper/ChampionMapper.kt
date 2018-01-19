package com.luismunyoz.rylaisscepter.data.firebase.mapper

import com.luismunyoz.rylaisscepter.data.firebase.model.*
import com.luismunyoz.rylaisscepter.domain.entity.*
import com.luismunyoz.rylaisscepter.ui.entity.UIChampionColors

/**
 * Created by llco on 11/09/2017.
 */
class ChampionMapper {

    fun transform(fbUIChampionColors: FBChampionUIColors) : ChampionUIColors = ChampionUIColors(fbUIChampionColors.primaryColor, fbUIChampionColors.primaryTitleColor, fbUIChampionColors.primaryTextColor, fbUIChampionColors.lightColor, fbUIChampionColors.darkColor)

    fun transform(championUIColors: ChampionUIColors) : FBChampionUIColors = FBChampionUIColors(championUIColors.primaryColor, championUIColors.primaryTitleColor, championUIColors.primaryTextColor, championUIColors.lightColor, championUIColors.darkColor)

    fun transform(firebaseBaseChampion: FBBaseChampion) : BaseChampion {
        val colors : FBChampionUIColors? = firebaseBaseChampion.colors
        if(colors != null) {
            return BaseChampion(firebaseBaseChampion.id, firebaseBaseChampion.key, firebaseBaseChampion.name, firebaseBaseChampion.title, transform(firebaseBaseChampion.colors))
        } else {
            return BaseChampion(firebaseBaseChampion.id, firebaseBaseChampion.key, firebaseBaseChampion.name, firebaseBaseChampion.title, null)
        }
    }

    fun transform(baseChampion: BaseChampion) : FBBaseChampion {
        val colors : ChampionUIColors? = baseChampion.colors
        if(colors != null) {
            return FBBaseChampion(baseChampion.id, baseChampion.key, baseChampion.name, baseChampion.title, transform(colors))
        } else {
            return FBBaseChampion(baseChampion.id, baseChampion.key, baseChampion.name, baseChampion.title, null)
        }
    }


    fun transform(firebaseImage : FBImage) : Image = Image(firebaseImage.full, firebaseImage.sprite, firebaseImage.group, firebaseImage.x, firebaseImage.y, firebaseImage.w, firebaseImage.h)

    fun transform(image: Image) : FBImage = FBImage(image.full, image.sprite, image.group, image.x, image.y, image.w, image.h)


    fun transform(firebaseAbility: FBAbility) : Ability = Ability(firebaseAbility.name, firebaseAbility.description, firebaseAbility.sanitizedDescription, transform(firebaseAbility.image))

    fun transform(ability: Ability) : FBAbility = FBAbility(ability.name, ability.description, ability.sanitizedDescription, transform(ability.image))


    fun transform(firebaseChampionInfo: FBChampionInfo) : ChampionInfo = ChampionInfo(firebaseChampionInfo.difficulty, firebaseChampionInfo.attack, firebaseChampionInfo.defense, firebaseChampionInfo.magic)

    fun transform(championInfo: ChampionInfo) : FBChampionInfo = FBChampionInfo(championInfo.difficulty, championInfo.attack, championInfo.defense, championInfo.magic)


    fun transform(firebaseChampion: FBChampion) : Champion = Champion(firebaseChampion.id, firebaseChampion.key, firebaseChampion.name, firebaseChampion.title, firebaseChampion.lore, transform(firebaseChampion.info), transform(firebaseChampion.image), transform(firebaseChampion.passive), firebaseChampion.spells.map { transform(it) })

    fun transform(champion: Champion) : FBChampion = FBChampion(champion.id, champion.key, champion.name, champion.title, champion.lore, transform(champion.info), transform(champion.image), transform(champion.passive), champion.spells.map { transform(it) })
}