package uz.targetsoftwaredevelopment.carcounter.screens

import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.opencsv.CSVWriter
import uz.targetsoftwaredevelopment.carcounter.R
import uz.targetsoftwaredevelopment.carcounter.data.VehicleEntity
import uz.targetsoftwaredevelopment.carcounter.data.vehiclesListA
import uz.targetsoftwaredevelopment.carcounter.data.vehiclesListB
import uz.targetsoftwaredevelopment.carcounter.databinding.ScreenMainBinding
import uz.targetsoftwaredevelopment.carcounter.utils.scope
import java.io.FileWriter
import java.io.IOException
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
    }

    private fun setModels() = binding.scope {
        adapterA.setData(vehiclesListA)
        adapterB.setData(vehiclesListB)
    }

    private fun addData(vehicleEntity: VehicleEntity, direction: String) = binding.scope {
        val csv = Environment.getExternalStorageDirectory().absolutePath + "/MyCsvFile.csv" // Here csv file name is MyCsvFile.csv
        var writer: CSVWriter? = null

        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val date = Date(System.currentTimeMillis())
        val dateStr = dateFormat.format(date)

        try {
            writer = CSVWriter(FileWriter(csv))
            val data: MutableList<Array<String>> = ArrayList()
            data.add(arrayOf(vehicleEntity.name, direction, "${vehicleEntity.id}", "${dateStr.substring(0, 10)}", "${dateStr.substring(11)}"))
            data.add(arrayOf("India", "New Delhi"))
            data.add(arrayOf("United States", "Washington D.C"))
            data.add(arrayOf("Germany", "Berlin"))
            writer.writeAll(data) // data is adding to csv
            writer.close()
//            callRead()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
