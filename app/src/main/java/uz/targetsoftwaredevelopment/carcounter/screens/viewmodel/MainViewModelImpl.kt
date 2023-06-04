package uz.targetsoftwaredevelopment.carcounter.screens.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.targetsoftwaredevelopment.carcounter.data.DirectionTypes
import uz.targetsoftwaredevelopment.carcounter.data.VehicleTypes
import uz.targetsoftwaredevelopment.carcounter.domain.Repository

/**
 * Date: 04/06/2023
 * Developer: Abdulaziz Akhmedov
 */

class MainViewModelImpl : MainViewModel, ViewModel() {
    private val repository = Repository.getInstance()

    override val countCarACountLiveData = MutableLiveData<Int>()
    override val countCarBCountLiveData = MutableLiveData<Int>()
    override val countMinibusACountLiveData = MutableLiveData<Int>()
    override val countMinibusBCountLiveData = MutableLiveData<Int>()
    override val countBusACountLiveData = MutableLiveData<Int>()
    override val countBusBCountLiveData = MutableLiveData<Int>()
    override val countTruckUpTo3ACountLiveData = MutableLiveData<Int>()
    override val countTruckUpTo3BCountLiveData = MutableLiveData<Int>()
    override val countTruckUpTo12ACountLiveData = MutableLiveData<Int>()
    override val countTruckUpTo12BCountLiveData = MutableLiveData<Int>()
    override val countTruckAbove12ACountLiveData = MutableLiveData<Int>()
    override val countTruckAbove12BCountLiveData = MutableLiveData<Int>()
    override val countRoadTrainsACountLiveData = MutableLiveData<Int>()
    override val countRoadTrainsBCountLiveData = MutableLiveData<Int>()
    override val countOtherACountLiveData = MutableLiveData<Int>()
    override val countOtherBCountLiveData = MutableLiveData<Int>()

    override val increasedCountCarACountLiveData = MutableLiveData<Int>()
    override val increasedCountCarBCountLiveData = MutableLiveData<Int>()
    override val increasedCountMinibusACountLiveData = MutableLiveData<Int>()
    override val increasedCountMinibusBCountLiveData = MutableLiveData<Int>()
    override val increasedCountBusACountLiveData = MutableLiveData<Int>()
    override val increasedCountBusBCountLiveData = MutableLiveData<Int>()
    override val increasedCountTruckUpTo3ACountLiveData = MutableLiveData<Int>()
    override val increasedCountTruckUpTo3BCountLiveData = MutableLiveData<Int>()
    override val increasedCountTruckUpTo12ACountLiveData = MutableLiveData<Int>()
    override val increasedCountTruckUpTo12BCountLiveData = MutableLiveData<Int>()
    override val increasedCountTruckAbove12ACountLiveData = MutableLiveData<Int>()
    override val increasedCountTruckAbove12BCountLiveData = MutableLiveData<Int>()
    override val increasedCountRoadTrainsACountLiveData = MutableLiveData<Int>()
    override val increasedCountRoadTrainsBCountLiveData = MutableLiveData<Int>()
    override val increasedCountOtherACountLiveData = MutableLiveData<Int>()
    override val increasedCountOtherBCountLiveData = MutableLiveData<Int>()

    override fun getCounts() {
        repository.getCounts().onEach {
            it.onSuccess { list ->
                countCarACountLiveData.value = list[0]
                countCarBCountLiveData.value = list[1]
                countMinibusACountLiveData.value = list[2]
                countMinibusBCountLiveData.value = list[3]
                countBusACountLiveData.value = list[4]
                countBusBCountLiveData.value = list[5]
                countTruckUpTo3ACountLiveData.value = list[6]
                countTruckUpTo3BCountLiveData.value = list[7]
                countTruckUpTo12ACountLiveData.value = list[8]
                countTruckUpTo12BCountLiveData.value = list[9]
                countTruckAbove12ACountLiveData.value = list[10]
                countTruckAbove12BCountLiveData.value = list[11]
                countRoadTrainsACountLiveData.value = list[12]
                countRoadTrainsBCountLiveData.value = list[13]
                countOtherACountLiveData.value = list[14]
                countOtherBCountLiveData.value = list[15]
            }
        }.launchIn(viewModelScope)
    }

    override fun increaseCount(vehicleTypes: VehicleTypes, directionTypes: DirectionTypes) {
        repository.increaseCount(vehicleTypes, directionTypes).onEach {
            it.onSuccess { count ->
                when (vehicleTypes) {
                    VehicleTypes.CAR -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                countCarACountLiveData.value = count
                                increasedCountCarACountLiveData.value = count
                            }

                            DirectionTypes.B -> {
                                countCarBCountLiveData.value = count
                                increasedCountCarBCountLiveData.value = count
                            }
                        }
                    }

                    VehicleTypes.MINIBUS -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                countMinibusACountLiveData.value = count
                                increasedCountMinibusACountLiveData.value = count
                            }

                            DirectionTypes.B -> {
                                countMinibusBCountLiveData.value = count
                                increasedCountMinibusBCountLiveData.value = count
                            }
                        }
                    }

                    VehicleTypes.BUS -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                countBusACountLiveData.value = count
                                increasedCountBusACountLiveData.value = count
                            }

                            DirectionTypes.B -> {
                                countBusBCountLiveData.value = count
                                increasedCountBusBCountLiveData.value = count
                            }
                        }
                    }

                    VehicleTypes.TRUCK_UP_TO3 -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                countTruckUpTo3ACountLiveData.value = count
                                increasedCountTruckUpTo3ACountLiveData.value = count
                            }

                            DirectionTypes.B -> {
                                countTruckUpTo3BCountLiveData.value = count
                                increasedCountTruckUpTo3BCountLiveData.value = count
                            }
                        }
                    }

                    VehicleTypes.TRUCK_UP_TO12 -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                countTruckUpTo12ACountLiveData.value = count
                                increasedCountTruckUpTo12ACountLiveData.value = count
                            }

                            DirectionTypes.B -> {
                                countTruckUpTo12BCountLiveData.value = count
                                increasedCountTruckUpTo12BCountLiveData.value = count
                            }
                        }
                    }

                    VehicleTypes.TRUCK_ABOVE_12 -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                countTruckAbove12ACountLiveData.value = count
                                increasedCountTruckAbove12ACountLiveData.value = count
                            }

                            DirectionTypes.B -> {
                                countTruckAbove12BCountLiveData.value = count
                                increasedCountTruckAbove12BCountLiveData.value = count
                            }
                        }
                    }

                    VehicleTypes.ROAD_TRAINS -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                countRoadTrainsACountLiveData.value = count
                                increasedCountRoadTrainsACountLiveData.value = count
                            }

                            DirectionTypes.B -> {
                                countRoadTrainsBCountLiveData.value = count
                                increasedCountRoadTrainsBCountLiveData.value = count
                            }
                        }
                    }

                    VehicleTypes.OTHER -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                countOtherACountLiveData.value = count
                                increasedCountOtherACountLiveData.value = count
                            }

                            DirectionTypes.B -> {
                                countOtherBCountLiveData.value = count
                                increasedCountOtherBCountLiveData.value = count
                            }
                        }
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}
