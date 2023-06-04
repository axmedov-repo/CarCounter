package uz.targetsoftwaredevelopment.carcounter.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.targetsoftwaredevelopment.carcounter.data.DirectionTypes
import uz.targetsoftwaredevelopment.carcounter.data.LocalStorage
import uz.targetsoftwaredevelopment.carcounter.data.VehicleTypes

/**
 * Date: 04/06/2023
 * Developer: Abdulaziz Akhmedov
 */

class Repository private constructor() {

    companion object {
        private lateinit var instance: Repository

        fun getInstance(): Repository {
            if (!::instance.isInitialized) {
                instance = Repository()
            }
            return instance
        }
    }

    private val localStorage = LocalStorage.getInstance()

    fun increaseCount(vehicleTypes: VehicleTypes, directionTypes: DirectionTypes): Flow<Result<Int>> = flow {
        emit(
            Result.success(
                when (vehicleTypes) {
                    VehicleTypes.CAR -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                ++localStorage.carA
                            }

                            DirectionTypes.B -> {
                                ++localStorage.carB
                            }
                        }
                    }

                    VehicleTypes.MINIBUS -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                ++localStorage.miniBusA
                            }

                            DirectionTypes.B -> {
                                ++localStorage.miniBusB
                            }
                        }
                    }

                    VehicleTypes.BUS -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                ++localStorage.busA
                            }

                            DirectionTypes.B -> {
                                ++localStorage.busB
                            }
                        }
                    }

                    VehicleTypes.TRUCK_UP_TO3 -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                ++localStorage.truckUpTo3A
                            }

                            DirectionTypes.B -> {
                                ++localStorage.truckUpTo3B
                            }
                        }
                    }

                    VehicleTypes.TRUCK_UP_TO12 -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                ++localStorage.truckUpTo12A
                            }

                            DirectionTypes.B -> {
                                ++localStorage.truckUpTo12B
                            }
                        }
                    }

                    VehicleTypes.TRUCK_ABOVE_12 -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                ++localStorage.truckAbove12A
                            }

                            DirectionTypes.B -> {
                                ++localStorage.truckAbove12B
                            }
                        }
                    }

                    VehicleTypes.ROAD_TRAINS -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                ++localStorage.roadTrainsA
                            }

                            DirectionTypes.B -> {
                                ++localStorage.roadTrainsB
                            }
                        }
                    }

                    VehicleTypes.OTHER -> {
                        when (directionTypes) {
                            DirectionTypes.A -> {
                                ++localStorage.otherA
                            }

                            DirectionTypes.B -> {
                                ++localStorage.otherB
                            }
                        }
                    }
                }
            )
        )
    }.flowOn(Dispatchers.IO)

    fun getCounts(): Flow<Result<List<Int>>> = flow {
        emit(
            Result.success(
                listOf(
                    localStorage.carA,
                    localStorage.carB,
                    localStorage.miniBusA,
                    localStorage.miniBusB,
                    localStorage.busA,
                    localStorage.busB,
                    localStorage.truckUpTo3A,
                    localStorage.truckUpTo3B,
                    localStorage.truckUpTo12A,
                    localStorage.truckUpTo12B,
                    localStorage.truckAbove12A,
                    localStorage.truckAbove12B,
                    localStorage.roadTrainsA,
                    localStorage.roadTrainsB,
                    localStorage.otherA,
                    localStorage.otherB
                )
            )
        )
    }.flowOn(Dispatchers.IO)

    fun setAllData(data: String) {
        localStorage.allData = "${localStorage.allData}$data"
    }

    fun getAllData(): String {
        return localStorage.allData
    }
}
