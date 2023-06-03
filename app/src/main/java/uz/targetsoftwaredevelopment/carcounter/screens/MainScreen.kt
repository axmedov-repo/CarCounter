package uz.targetsoftwaredevelopment.carcounter.screens

import android.Manifest
import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import net.ozaydin.serkan.easy_csv.EasyCsv
import net.ozaydin.serkan.easy_csv.FileCallback
import uz.targetsoftwaredevelopment.carcounter.R
import uz.targetsoftwaredevelopment.carcounter.data.VehicleData
import uz.targetsoftwaredevelopment.carcounter.data.vehiclesListA
import uz.targetsoftwaredevelopment.carcounter.data.vehiclesListB
import uz.targetsoftwaredevelopment.carcounter.databinding.ScreenMainBinding
import uz.targetsoftwaredevelopment.carcounter.utils.scope
import uz.targetsoftwaredevelopment.carcounter.utils.showToast
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date


class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val adapterA by lazy { VehiclesAdapter() }
    private val adapterB by lazy { VehiclesAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        setModels()
    }

    private fun setViews() = binding.scope {
        /* rvA.layoutManager = LinearLayoutManager(requireContext())
         rvA.adapter = adapterA

         rvB.layoutManager = LinearLayoutManager(requireContext())
         rvB.adapter = adapterB*/

        adapterA.setListener {
//            addData(it, "Direction A")
        }
        adapterB.setListener {
//            addData(it, "Direction A")
        }

        cvCarA.setOnClickListener {
            addData(VehicleData(0, "Cars"), "Direction A")
        }
        cvCarB.setOnClickListener {
            addData(VehicleData(1, "Cars"), "Direction B")
        }
        cvMinibusA.setOnClickListener {
            addData(VehicleData(2, "Minibuses"), "Direction A")
        }
        cvMinibusB.setOnClickListener {
            addData(VehicleData(3, "Minibuses"), "Direction B")
        }
        cvBusA.setOnClickListener {
            addData(VehicleData(4, "Buses"), "Direction A")
        }
        cvBusB.setOnClickListener {
            addData(VehicleData(5, "Buses"), "Direction B")
        }
        cvTruckUpTo3A.setOnClickListener {
            addData(VehicleData(6, "Trucks up to 3.5 t"), "Direction A")
        }
        cvTruckUpTo3B.setOnClickListener {
            addData(VehicleData(7, "Trucks up to 3.5 t"), "Direction B")
        }
        cvTruckUpTo12A.setOnClickListener {
            addData(VehicleData(8, "Trucks up to 3.5–12 t"), "Direction A")
        }
        cvTruckUpTo12B.setOnClickListener {
            addData(VehicleData(9, "Trucks up to 3.5–12 t"), "Direction B")
        }
        cvTruckAbove12A.setOnClickListener {
            addData(VehicleData(10, "Trucks above 12 t"), "Direction A")
        }
        cvTruckAbove12B.setOnClickListener {
            addData(VehicleData(11, "Trucks above 12 t"), "Direction B")
        }
        cvRoadTrainsA.setOnClickListener {
            addData(VehicleData(12, "Road trains"), "Direction A")
        }
        cvRoadTrainsB.setOnClickListener {
            addData(VehicleData(13, "Road trains"), "Direction B")
        }
        cvOtherA.setOnClickListener {
            addData(VehicleData(14, "Other"), "Direction A")
        }
        cvOtherB.setOnClickListener {
            addData(VehicleData(15, "Other"), "Direction B")
        }
    }

    private fun setModels() = binding.scope {
        showToast("Data set")
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

                    val easyCsv = EasyCsv(requireActivity())
                    val headerList: MutableList<String> = ArrayList()
                    headerList.add("Name.Direction.Id.Date.Time-")

                    val dataList: MutableList<String> = ArrayList()
                    dataList.add("${vehicleData.name}.$direction.${vehicleData.id}.${dateStr.substring(0, 10)}.${dateStr.substring(11)}-")

                    easyCsv.setSeparatorColumn(".")
                    easyCsv.setSeperatorLine("-")

                    easyCsv.createCsvFile(
                        "MyCsvFile",
                        headerList,
                        dataList,
                        0,
                        object : FileCallback {
                            override fun onSuccess(file: File) {
                                // Handle success
                                showToast("SUCCEED")
                                var outputStream: FileOutputStream? = null
                                try {
                                    outputStream = FileOutputStream(file, true)
//                                    outputStream.write(textToWrite.getBytes())
                                    outputStream.flush()
                                    outputStream.close()
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
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
