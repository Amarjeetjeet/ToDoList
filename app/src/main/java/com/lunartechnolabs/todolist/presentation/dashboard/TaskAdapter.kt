package com.lunartechnolabs.todolist.presentation.dashboard


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lunartechnolabs.todolist.databinding.SingleTaskBinding
import com.lunartechnolabs.todolist.domain.model.Task


class TaskAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<MainViewHolder>() {

    private  var taskList: ArrayList<Task> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SingleTaskBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val task = taskList[position]

        when (task.priority) {
            "1" -> {
                holder.binding.cardView.setCardBackgroundColor(Color.RED)
            }
            "2" -> {
                holder.binding.cardView.setCardBackgroundColor(Color.GREEN)
            }
            else -> {
                holder.binding.cardView.setCardBackgroundColor(Color.YELLOW)
            }
        }

        holder.binding.shortDesc.text = task.title
        holder.binding.title.text = task.title
        holder.binding.description.text = task.detail

        holder.itemView.setOnClickListener {
            listener.itemClick(it, position, task)
        }

        holder.itemView.setOnLongClickListener {
            listener.itemClickLong(it, position, task)
            false
        }

    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    interface OnItemClickListener {
        fun itemClick(view: View, position: Int, task: Task)
        fun btnClick(view: View, position: Int, task: Task)
        fun itemClickLong(view: View, position: Int, task: Task)
    }


    fun setData(taskModel: ArrayList<Task>) {
        taskList = taskModel
    }

}
class MainViewHolder(var binding: SingleTaskBinding) : RecyclerView.ViewHolder(binding.root)