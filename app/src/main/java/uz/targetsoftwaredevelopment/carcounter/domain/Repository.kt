package uz.targetsoftwaredevelopment.carcounter.domain

import uz.targetsoftwaredevelopment.carcounter.data.DirectionTypes
import uz.targetsoftwaredevelopment.carcounter.data.LocalStorage
import uz.targetsoftwaredevelopment.carcounter.data.VehicleTypes

class Repository {
    private val localStorage = LocalStorage.getInstance()

    fun setData(vehicleTypes: VehicleTypes, directionTypes: DirectionTypes, count: Int) {
        when (vehicleTypes) {
            VehicleTypes.CAR -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.carA = count
                    }

                    DirectionTypes.B -> {
                        localStorage.carB = count
                    }
                }
            }

            VehicleTypes.MINIBUS -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.miniBusA = count
                    }

                    DirectionTypes.B -> {
                        localStorage.miniBusB = count
                    }
                }
            }

            VehicleTypes.BUS -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.busA = count
                    }

                    DirectionTypes.B -> {
                        localStorage.busB = count
                    }
                }
            }

            VehicleTypes.TRUCK_UP_TO3 -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.truckUpTo3A = count
                    }

                    DirectionTypes.B -> {
                        localStorage.truckUpTo3B = count
                    }
                }
            }

            VehicleTypes.TRUCK_UP_TO12 -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.truckUpTo12A = count
                    }

                    DirectionTypes.B -> {
                        localStorage.truckUpTo12B = count
                    }
                }
            }

            VehicleTypes.TRUCK_ABOVE_12 -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.truckAbove12A = count
                    }

                    DirectionTypes.B -> {
                        localStorage.truckAbove12B = count
                    }
                }
            }

            VehicleTypes.ROAD_TRAINS -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.roadTrainsA = count
                    }

                    DirectionTypes.B -> {
                        localStorage.roadTrainsB = count
                    }
                }
            }

            VehicleTypes.OTHER -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.otherA = count
                    }

                    DirectionTypes.B -> {
                        localStorage.otherB = count
                    }
                }
            }
        }
    }

    fun getData(vehicleTypes: VehicleTypes, directionTypes: DirectionTypes): Int {
        return when (vehicleTypes) {
            VehicleTypes.CAR -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.carA
                    }

                    DirectionTypes.B -> {
                        localStorage.carB
                    }
                }
            }

            VehicleTypes.MINIBUS -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.miniBusA
                    }

                    DirectionTypes.B -> {
                        localStorage.miniBusB
                    }
                }
            }

            VehicleTypes.BUS -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.busA
                    }

                    DirectionTypes.B -> {
                        localStorage.busB
                    }
                }
            }

            VehicleTypes.TRUCK_UP_TO3 -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.truckUpTo3A
                    }

                    DirectionTypes.B -> {
                        localStorage.truckUpTo3B
                    }
                }
            }

            VehicleTypes.TRUCK_UP_TO12 -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.truckUpTo12A
                    }

                    DirectionTypes.B -> {
                        localStorage.truckUpTo12B
                    }
                }
            }

            VehicleTypes.TRUCK_ABOVE_12 -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.truckAbove12A
                    }

                    DirectionTypes.B -> {
                        localStorage.truckAbove12B
                    }
                }
            }

            VehicleTypes.ROAD_TRAINS -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.roadTrainsA
                    }

                    DirectionTypes.B -> {
                        localStorage.roadTrainsB
                    }
                }
            }

            VehicleTypes.OTHER -> {
                when (directionTypes) {
                    DirectionTypes.A -> {
                        localStorage.otherA
                    }

                    DirectionTypes.B -> {
                        localStorage.otherB
                    }
                }
            }
        }
    }
}
