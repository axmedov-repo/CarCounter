package uz.targetsoftwaredevelopment.carcounter.data

import androidx.annotation.Keep
import java.io.Serializable

/**
 * Date: 04/06/2023
 * Developer: Abdulaziz Akhmedov
 */

@Keep
data class VehicleEntity(
    val id: Int,
    val img: Int,
    val name: String,
    val count: Int = 0,
    val directionTypes: DirectionTypes
) : Serializable
