package uz.targetsoftwaredevelopment.carcounter.data

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class VehicleData(
    val count: Int,
    val name: String
) : Serializable
