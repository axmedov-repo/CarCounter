package uz.targetsoftwaredevelopment.carcounter.data

import androidx.annotation.Keep
import java.io.Serializable

/**
 * Date: 04/06/2023
 * Developer: Abdulaziz Akhmedov
 */

@Keep
data class VehicleData(
    val count: Int,
    val name: String
) : Serializable
