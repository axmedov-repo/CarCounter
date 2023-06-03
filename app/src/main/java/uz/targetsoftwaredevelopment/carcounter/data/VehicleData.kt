package uz.targetsoftwaredevelopment.carcounter.data

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class VehicleData(
    val id: Int,
    val name: String
) : Serializable
