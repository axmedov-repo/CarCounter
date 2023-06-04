package uz.targetsoftwaredevelopment.carcounter.screens

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import net.ozaydin.serkan.easy_csv.EasyCsv
import net.ozaydin.serkan.easy_csv.FileCallback
import uz.targetsoftwaredevelopment.carcounter.R
import uz.targetsoftwaredevelopment.carcounter.data.DirectionTypes
import uz.targetsoftwaredevelopment.carcounter.data.VehicleData
import uz.targetsoftwaredevelopment.carcounter.data.VehicleTypes
import uz.targetsoftwaredevelopment.carcounter.databinding.ScreenMainBinding
import uz.targetsoftwaredevelopment.carcounter.domain.Repository
import uz.targetsoftwaredevelopment.carcounter.screens.viewmodel.MainViewModel
import uz.targetsoftwaredevelopment.carcounter.screens.viewmodel.MainViewModelImpl
import uz.targetsoftwaredevelopment.carcounter.utils.scope
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Date: 04/06/2023
 * Developer: Abdulaziz Akhmedov
 */

class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()

    private val columnSeparator = "sdksjdksjdk"
    private val rowSeparator = "ueirueuireu"
    private val separatorForRepo = "jsnvnreneidsn"
    private val repository = Repository.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)
        setModels()
        setViews()
    }

    private fun setModels() = binding.scope {
        viewModel.apply {
            getCounts()

            countCarACountLiveData.observe(viewLifecycleOwner) { count ->
                countCarA.text = "$count"
            }
            countCarBCountLiveData.observe(viewLifecycleOwner) { count ->
                countCarB.text = "$count"
            }
            countMinibusACountLiveData.observe(viewLifecycleOwner) { count ->
                countMinibusA.text = "$count"
            }
            countMinibusBCountLiveData.observe(viewLifecycleOwner) { count ->
                countMinibusB.text = "$count"
            }
            countBusACountLiveData.observe(viewLifecycleOwner) { count ->
                countBusA.text = "$count"
            }
            countBusBCountLiveData.observe(viewLifecycleOwner) { count ->
                countBusB.text = "$count"
            }
            countTruckUpTo3ACountLiveData.observe(viewLifecycleOwner) { count ->
                countTruckUpTo3A.text = "$count"
            }
            countTruckUpTo3BCountLiveData.observe(viewLifecycleOwner) { count ->
                countTruckUpTo3B.text = "$count"
            }
            countTruckUpTo12ACountLiveData.observe(viewLifecycleOwner) { count ->
                countTruckUpTo12A.text = "$count"
            }
            countTruckUpTo12BCountLiveData.observe(viewLifecycleOwner) { count ->
                countTruckUpTo12B.text = "$count"
            }
            countTruckAbove12ACountLiveData.observe(viewLifecycleOwner) { count ->
                countTruckAbove12A.text = "$count"
            }
            countTruckAbove12BCountLiveData.observe(viewLifecycleOwner) { count ->
                countTruckAbove12B.text = "$count"
            }
            countRoadTrainsACountLiveData.observe(viewLifecycleOwner) { count ->
                countRoadTrainsA.text = "$count"
            }
            countRoadTrainsBCountLiveData.observe(viewLifecycleOwner) { count ->
                countRoadTrainsB.text = "$count"
            }
            countOtherACountLiveData.observe(viewLifecycleOwner) { count ->
                countOtherA.text = "$count"
            }
            countOtherBCountLiveData.observe(viewLifecycleOwner) { count ->
                countOtherB.text = "$count"
            }


            increasedCountCarACountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Cars"), "Direction A")
            }
            increasedCountCarBCountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Cars"), "Direction B")
            }
            increasedCountMinibusACountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Minibuses"), "Direction A")
            }
            increasedCountMinibusBCountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Minibuses"), "Direction B")
            }
            increasedCountBusACountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Buses"), "Direction A")
            }
            increasedCountBusBCountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Buses"), "Direction B")
            }
            increasedCountTruckUpTo3ACountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Trucks up to 3.5 t"), "Direction A")
            }
            increasedCountTruckUpTo3BCountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Trucks up to 3.5 t"), "Direction B")
            }
            increasedCountTruckUpTo12ACountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Trucks up to 3.5–12 t"), "Direction A")
            }
            increasedCountTruckUpTo12BCountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Trucks up to 3.5–12 t"), "Direction B")
            }
            increasedCountTruckAbove12ACountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Trucks above 12 t"), "Direction A")
            }
            increasedCountTruckAbove12BCountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Trucks above 12 t"), "Direction B")
            }
            increasedCountRoadTrainsACountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Road trains"), "Direction A")
            }
            increasedCountRoadTrainsBCountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Road trains"), "Direction B")
            }
            increasedCountOtherACountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Other"), "Direction A")
            }
            increasedCountOtherBCountLiveData.observe(viewLifecycleOwner) { count ->
                addData(VehicleData(count, "Other"), "Direction B")
            }
        }
    }

    private fun setViews() = binding.scope {
        cvCarA.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.CAR, DirectionTypes.A)
        }
        cvCarB.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.CAR, DirectionTypes.B)
        }
        cvMinibusA.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.MINIBUS, DirectionTypes.A)
        }
        cvMinibusB.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.MINIBUS, DirectionTypes.B)
        }
        cvBusA.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.BUS, DirectionTypes.A)
        }
        cvBusB.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.BUS, DirectionTypes.B)
        }
        cvTruckUpTo3A.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.TRUCK_UP_TO3, DirectionTypes.A)
        }
        cvTruckUpTo3B.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.TRUCK_UP_TO3, DirectionTypes.B)
        }
        cvTruckUpTo12A.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.TRUCK_UP_TO12, DirectionTypes.A)
        }
        cvTruckUpTo12B.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.TRUCK_UP_TO12, DirectionTypes.B)
        }
        cvTruckAbove12A.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.TRUCK_ABOVE_12, DirectionTypes.A)
        }
        cvTruckAbove12B.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.TRUCK_ABOVE_12, DirectionTypes.B)
        }
        cvRoadTrainsA.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.ROAD_TRAINS, DirectionTypes.A)
        }
        cvRoadTrainsB.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.ROAD_TRAINS, DirectionTypes.B)
        }
        cvOtherA.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.OTHER, DirectionTypes.A)
        }
        cvOtherB.setOnClickListener {
            viewModel.increaseCount(VehicleTypes.OTHER, DirectionTypes.B)
        }
    }

    private fun addData(vehicleData: VehicleData, direction: String) = binding.scope {
        Permissions.check(requireContext(), arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ), null, null,
            object : PermissionHandler() {
                override fun onGranted() {
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
                        "TrafficCountSurvey_CSV_File",
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
