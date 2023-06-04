package uz.targetsoftwaredevelopment.carcounter.utils

import androidx.viewbinding.ViewBinding

/**
 * Date: 04/06/2023
 * Developer: Abdulaziz Akhmedov
 */

fun <T : ViewBinding> T.scope(block: T.() -> Unit) {
    block(this)
}
