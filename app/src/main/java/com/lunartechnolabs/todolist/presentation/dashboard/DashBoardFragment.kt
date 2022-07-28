package com.lunartechnolabs.todolist.presentation.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lunartechnolabs.todolist.databinding.FragmentDashBoardBinding
import com.lunartechnolabs.todolist.domain.model.Task
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class DashBoardFragment : Fragment() , TaskAdapter.OnItemClickListener{

    private  var _binding: FragmentDashBoardBinding?= null
    private val binding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashBoardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        iniRecyclerview()
        bindObserver()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun iniRecyclerview() {
        taskAdapter = TaskAdapter(this@DashBoardFragment)
        binding.articleRcv.layoutManager = LinearLayoutManager(requireActivity())
        binding.articleRcv.adapter = taskAdapter
    }

    private fun bindObserver() {
        val task : ArrayList<Task> = ArrayList<Task>()
        task.add(Task("Title","1","Push the Code",Date().time,Date().time))
        task.add(Task("Title","0","Push the Code",Date().time,Date().time))
        task.add(Task("Title","2","Push the Code",Date().time,Date().time))
        task.add(Task("Title","0","Push the Code",Date().time,Date().time))
        task.add(Task("Title","2","Push the Code",Date().time,Date().time))
        task.add(Task("Title","2","Push the Code",Date().time,Date().time))
        task.add(Task("Title","1","Push the Code",Date().time,Date().time))
        task.add(Task("Title","0","Push the Code",Date().time,Date().time))
        task.add(Task("Title","2","Push the Code",Date().time,Date().time))
        taskAdapter.setData(task)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun itemClick(view: View, position: Int, task: Task) {

    }

    override fun btnClick(view: View, position: Int, task: Task) {
    }

    override fun itemClickLong(view: View, position: Int, task: Task) {
    }
}