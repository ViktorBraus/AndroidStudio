package viktor.braus.kplanner.plans.listOfPlans

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import viktor.braus.kplanner.R
import viktor.braus.kplanner.entity.Plans
import viktor.braus.kplanner.databinding.TextItemViewBinding

class ListPlansAdapter : ListAdapter<Plans, ListPlansAdapter.ViewHolder>(LisDiffCallback()) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(binding: TextItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val mondayText = binding.qualityImage
        @SuppressLint("SetTextI18n")
        fun bind(item: Plans) {
            if (item.EventID.toInt() % 2 == 0)
            {
                mondayText.setTextColor(Color.GREEN)
            }
            else
            {
                mondayText.setTextColor(Color.WHITE)
            }
            if (item.EventDay == "Понеділок")
            {

                mondayText.text = "Назва Події:     " + item.EventName + "\nЧас події:      " + item.Time
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TextItemViewBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }
    }
}
class LisDiffCallback : DiffUtil.ItemCallback<Plans>()
{
    override fun areItemsTheSame(oldItem: Plans, newItem: Plans): Boolean {
        return oldItem.EventID == newItem.EventID
    }

    override fun areContentsTheSame(oldItem: Plans, newItem: Plans): Boolean {
            return oldItem == newItem
    }

}