package uz.targetsoftwaredevelopment.carcounter.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.targetsoftwaredevelopment.carcounter.data.VehicleEntity
import uz.targetsoftwaredevelopment.carcounter.databinding.ItemListBinding
import uz.targetsoftwaredevelopment.carcounter.utils.scope

class VehiclesAdapter : RecyclerView.Adapter<VehiclesAdapter.VH>() {
    private val list = ArrayList<VehicleEntity>()

    fun setData(list: List<VehicleEntity>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    private var listener: ((VehicleEntity) -> Unit)? = null
    fun setListener(f: (VehicleEntity) -> Unit) {
        listener = f
    }

    inner class VH(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                listener?.invoke(list[absoluteAdapterPosition])
                return@setOnClickListener
            }
        }

        fun bind() = binding.scope {
            val data = list[absoluteAdapterPosition]
            imgVehicle.setImageResource(data.img)
            nameVehicle.text = data.name
            countVehicle.text = "${data.count}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = VH(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind()

    override fun getItemCount(): Int = list.size
}
