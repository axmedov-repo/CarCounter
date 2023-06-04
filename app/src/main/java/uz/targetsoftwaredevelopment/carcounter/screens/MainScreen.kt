package uz.targetsoftwaredevelopment.carcounter.screens

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import net.ozaydin.serkan.easy_csv.EasyCsv
import net.ozaydin.serkan.easy_csv.FileCallback
import uz.targetsoftwaredevelopment.carcounter.R
import uz.targetsoftwaredevelopment.carcounter.data.DirectionTypes
import uz.targetsoftwaredevelopment.carcounter.data.VehicleData
import uz.targetsoftwaredevelopment.carcounter.data.VehicleTypes
import uz.targetsoftwaredevelopment.carcounter.data.vehiclesListA
import uz.targetsoftwaredevelopment.carcounter.data.vehiclesListB
import uz.targetsoftwaredevelopment.carcounter.databinding.ScreenMainBinding
import uz.targetsoftwaredevelopment.carcounter.domain.Repository
import uz.targetsoftwaredevelopment.carcounter.utils.scope
import uz.targetsoftwaredevelopment.carcounter.utils.showToast
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val adapterA by lazy { VehiclesAdapter() }
    private val adapterB by lazy { VehiclesAdapter() }
    private val columnSeparator = "sdksjdksjdk"
    private val rowSeparator = "ueirueuireu"
    private val separatorForRepo = "jsnvnreneidsn"
    private val repository = Repository.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        setModels()
    }

    private fun setViews() = binding.scope {
        countCarA.text = "${repository.getCount(VehicleTypes.CAR, DirectionTypes.A)}"
        countCarB.text = "${repository.getCount(VehicleTypes.CAR, DirectionTypes.B)}"
        countMinibusA.text = "${repository.getCount(VehicleTypes.MINIBUS, DirectionTypes.A)}"
        countMinibusB.text = "${repository.getCount(VehicleTypes.MINIBUS, DirectionTypes.B)}"
        countBusA.text = "${repository.getCount(VehicleTypes.BUS, DirectionTypes.A)}"
        countBusB.text = "${repository.getCount(VehicleTypes.BUS, DirectionTypes.B)}"
        countTruckUpTo3A.text = "${repository.getCount(VehicleTypes.TRUCK_UP_TO3, DirectionTypes.A)}"
        countTruckUpTo3B.text = "${repository.getCount(VehicleTypes.TRUCK_UP_TO3, DirectionTypes.B)}"
        countTruckUpTo12A.text = "${repository.getCount(VehicleTypes.TRUCK_UP_TO12, DirectionTypes.A)}"
        countTruckUpTo12B.text = "${repository.getCount(VehicleTypes.TRUCK_UP_TO12, DirectionTypes.B)}"
        countTruckAbove12A.text = "${repository.getCount(VehicleTypes.TRUCK_ABOVE_12, DirectionTypes.A)}"
        countTruckAbove12B.text = "${repository.getCount(VehicleTypes.TRUCK_ABOVE_12, DirectionTypes.B)}"
        countRoadTrainsA.text = "${repository.getCount(VehicleTypes.ROAD_TRAINS, DirectionTypes.A)}"
        countRoadTrainsB.text = "${repository.getCount(VehicleTypes.ROAD_TRAINS, DirectionTypes.B)}"
        countOtherA.text = "${repository.getCount(VehicleTypes.OTHER, DirectionTypes.A)}"
        countOtherB.text = "${repository.getCount(VehicleTypes.OTHER, DirectionTypes.B)}"

        var count = 0
        cvCarA.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.CAR, DirectionTypes.A)
            countCarA.text = "$count"
            addData(VehicleData(count, "Cars"), "Direction A")
        }
        cvCarB.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.CAR, DirectionTypes.B)
            countCarB.text = "$count"
            addData(VehicleData(count, "Cars"), "Direction B")
        }
        cvMinibusA.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.MINIBUS, DirectionTypes.A)
            countMinibusA.text = "$count"
            addData(VehicleData(count, "Minibuses"), "Direction A")
        }
        cvMinibusB.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.MINIBUS, DirectionTypes.B)
            countMinibusB.text = "$count"
            addData(VehicleData(count, "Minibuses"), "Direction B")
        }
        cvBusA.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.BUS, DirectionTypes.A)
            countBusA.text = "$count"
            addData(VehicleData(count, "Buses"), "Direction A")
        }
        cvBusB.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.BUS, DirectionTypes.B)
            countBusB.text = "$count"
            addData(VehicleData(count, "Buses"), "Direction B")
        }
        cvTruckUpTo3A.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.TRUCK_UP_TO3, DirectionTypes.A)
            countTruckUpTo3A.text = "$count"
            addData(VehicleData(count, "Trucks up to 3.5 t"), "Direction A")
        }
        cvTruckUpTo3B.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.TRUCK_UP_TO3, DirectionTypes.B)
            countTruckUpTo3B.text = "$count"
            addData(VehicleData(count, "Trucks up to 3.5 t"), "Direction B")
        }
        cvTruckUpTo12A.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.TRUCK_UP_TO12, DirectionTypes.A)
            countTruckUpTo12A.text = "$count"
            addData(VehicleData(count, "Trucks up to 3.5–12 t"), "Direction A")
        }
        cvTruckUpTo12B.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.TRUCK_UP_TO12, DirectionTypes.B)
            countTruckUpTo12B.text = "$count"
            addData(VehicleData(count, "Trucks up to 3.5–12 t"), "Direction B")
        }
        cvTruckAbove12A.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.TRUCK_ABOVE_12, DirectionTypes.A)
            countTruckAbove12A.text = "$count"
            addData(VehicleData(count, "Trucks above 12 t"), "Direction A")
        }
        cvTruckAbove12B.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.TRUCK_ABOVE_12, DirectionTypes.B)
            countTruckAbove12B.text = "$count"
            addData(VehicleData(count, "Trucks above 12 t"), "Direction B")
        }
        cvRoadTrainsA.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.ROAD_TRAINS, DirectionTypes.A)
            countRoadTrainsA.text = "$count"
            addData(VehicleData(count, "Road trains"), "Direction A")
        }
        cvRoadTrainsB.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.ROAD_TRAINS, DirectionTypes.B)
            countRoadTrainsB.text = "$count"
            addData(VehicleData(count, "Road trains"), "Direction B")
        }
        cvOtherA.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.OTHER, DirectionTypes.A)
            countOtherA.text = "$count"
            addData(VehicleData(count, "Other"), "Direction A")
        }
        cvOtherB.setOnClickListener {
            count = repository.increaseCount(VehicleTypes.OTHER, DirectionTypes.B)
            countOtherB.text = "$count"
            addData(VehicleData(count, "Other"), "Direction B")
        }
    }

    private fun setModels() = binding.scope {
        adapterA.setData(vehiclesListA)
        adapterB.setData(vehiclesListB)
    }

    private fun addData(vehicleData: VehicleData, direction: String) = binding.scope {
        Permissions.check(requireContext(), arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ), null, null,
            object : PermissionHandler() {
                override fun onGranted() {
                    showToast("${vehicleData.name}")
                    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
                    val date = Date(System.currentTimeMillis())
                    val dateStr = dateFormat.format(date)

                    repository.setAllData(
                        "${vehicleData.name}${columnSeparator}$direction${columnSeparator}${vehicleData.count}${columnSeparator}${
                            dateStr.substring(
                                0,
                                10
                            )
                        }${columnSeparator}${dateStr.substring(11)}${rowSeparator}${separatorForRepo}"
                    )

                    val easyCsv = EasyCsv(requireActivity())
                    val headerList: MutableList<String> = ArrayList()
                    headerList.add("Name${columnSeparator}Direction${columnSeparator}Count${columnSeparator}Date${columnSeparator}Time${rowSeparator}")

                    val allDataStr = repository.getAllData()
                    val rowsList = allDataStr.split(separatorForRepo)

                    easyCsv.setSeparatorColumn(columnSeparator)
                    easyCsv.setSeperatorLine(rowSeparator)
                    easyCsv.createCsvFile(
                        "MyCsvFile",
                        headerList,
                        rowsList,
                        0,
                        object : FileCallback {
                            override fun onSuccess(file: File) {
                                // Handle success
                            }

                            override fun onFail(err: String) {
                                // Handle failure
                            }
                        }
                    )
                }
            }
        )
    }
}
