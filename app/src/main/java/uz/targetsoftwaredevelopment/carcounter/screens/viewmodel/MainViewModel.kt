package uz.targetsoftwaredevelopment.carcounter.screens.viewmodel

import androidx.lifecycle.LiveData
import uz.targetsoftwaredevelopment.carcounter.data.DirectionTypes
import uz.targetsoftwaredevelopment.carcounter.data.VehicleTypes

/**
 * Date: 04/06/2023
 * Developer: Abdulaziz Akhmedov
 */

interface MainViewModel {
    val countCarACountLiveData: LiveData<Int>
    val countCarBCountLiveData: LiveData<Int>
    val countMinibusACountLiveData: LiveData<Int>
    val countMinibusBCountLiveData: LiveData<Int>
    val countBusACountLiveData: LiveData<Int>
    val countBusBCountLiveData: LiveData<Int>
    val countTruckUpTo3ACountLiveData: LiveData<Int>
    val countTruckUpTo3BCountLiveData: LiveData<Int>
    val countTruckUpTo12ACountLiveData: LiveData<Int>
    val countTruckUpTo12BCountLiveData: LiveData<Int>
    val countTruckAbove12ACountLiveData: LiveData<Int>
    val countTruckAbove12BCountLiveData: LiveData<Int>
    val countRoadTrainsACountLiveData: LiveData<Int>
    val countRoadTrainsBCountLiveData: LiveData<Int>
    val countOtherACountLiveData: LiveData<Int>
    val countOtherBCountLiveData: LiveData<Int>

    val increasedCountCarACountLiveData: LiveData<Int>
    val increasedCountCarBCountLiveData: LiveData<Int>
    val increasedCountMinibusACountLiveData: LiveData<Int>
    val increasedCountMinibusBCountLiveData: LiveData<Int>
    val increasedCountBusACountLiveData: LiveData<Int>
    val increasedCountBusBCountLiveData: LiveData<Int>
    val increasedCountTruckUpTo3ACountLiveData: LiveData<Int>
    val increasedCountTruckUpTo3BCountLiveData: LiveData<Int>
    val increasedCountTruckUpTo12ACountLiveData: LiveData<Int>
    val increasedCountTruckUpTo12BCountLiveData: LiveData<Int>
    val increasedCountTruckAbove12ACountLiveData: LiveData<Int>
    val increasedCountTruckAbove12BCountLiveData: LiveData<Int>
    val increasedCountRoadTrainsACountLiveData: LiveData<Int>
    val increasedCountRoadTrainsBCountLiveData: LiveData<Int>
    val increasedCountOtherACountLiveData: LiveData<Int>
    val increasedCountOtherBCountLiveData: LiveData<Int>

    fun getCounts()
    fun increaseCount(vehicleTypes: VehicleTypes, directionTypes: DirectionTypes)
}