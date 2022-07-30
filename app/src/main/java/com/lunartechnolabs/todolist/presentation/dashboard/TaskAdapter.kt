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
            "High" -> {
                holder.binding.title.setTextColor(Color.RED)
            }
            "Medium" -> {
                holder.binding.title.setTextColor(Color.GREEN)
            }
            else -> {
                holder.binding.title.setTextColor(Color.BLACK)
            }
        }

        holder.binding.title.text = task.title

        holder.itemView.setOnClickListener {
            listener.itemClick(it, position, task)
        }

        holder.itemView.setOnLongClickListener {
            listener.itemClickLong(it, position, task)
            false
        }

        holder.binding.checkbox.setOnClickListener{
            if(taskList.isNotEmpty() && taskList.size > position) {
                taskList.removeAt(position)
                notifyItemRemoved(position)
                notifyDataSetChanged()
            }
            if(taskList.size == 0){

                taskList.clear()
            }
            listener.btnClick(it,position,task)
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