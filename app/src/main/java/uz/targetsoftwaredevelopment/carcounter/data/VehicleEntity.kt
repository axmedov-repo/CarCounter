package uz.targetsoftwaredevelopment.carcounter.data

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class VehicleEntity(
    val id: Int,
    val img: Int,
    val name: String,
    val count: Int = 0,
    val directionTypes: DirectionTypes
) : Serializable
