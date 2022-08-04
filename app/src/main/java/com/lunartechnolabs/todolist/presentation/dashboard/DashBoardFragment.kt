package com.lunartechnolabs.todolist.presentation.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lunartechnolabs.todolist.databinding.FragmentDashBoardBinding
import com.lunartechnolabs.todolist.domain.model.Task
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import java.util.*
import kotlin.collections.ArrayList


/**
 * Dashboard Task Fragment
 * Hilt view model will create entry point for Fragment
 */
@AndroidEntryPoint
class DashBoardFragment : Fragment() , TaskAdapter.OnItemClickListener{

    private  var _binding: FragmentDashBoardBinding?= null
    private val binding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter
    private val viewModel : DashBoardViewModel by viewModels()

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
        viewModel.fetchOfflineArticle()
        //initialize RecyclerView
        iniRecyclerview()
        //initialize observers
        bindObserver()


        //Floating button code
        binding.floatingActionButton.setOnClickListener {
            val task = Task(title = "", priority = "", detail = "", taskDate = "", taskTime = "")
            val action = DashBoardFragmentDirections.actionDashBoardFragmentToEditOrAddFragment(task,false)
            findNavController().navigate(action)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    //Recyclerview init function
    private fun iniRecyclerview() {
        taskAdapter = TaskAdapter(this@DashBoardFragment)
        binding.articleRcv.layoutManager = LinearLayoutManager(requireActivity())
        binding.articleRcv.adapter = taskAdapter
    }

    //oberser init function
    private fun bindObserver() {
        lifecycleScope.launchWhenCreated {
            //collect data from ViewModel
            viewModel.offlineArticleUIState.collectLatest {
                when (it) {
                    is Resource.Success -> {
                        it.data?.let {
                        taskAdapter.setData(it as ArrayList<Task>)
                        }
                    }
                        is Resource.Error -> {
                        }
                        is Resource.Loading -> {
                        }
                    }

                }

           }

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    //Click handle
    //1.item click
    override fun itemClick(view: View, position: Int, task: Task) {
        //open update fragment
        openUpdateFragment(task)
    }

    //2. Button click
    override fun btnClick(view: View, position: Int, task: Task) {
        //delete article
        viewModel.deleteArticle(task)
        taskAdapter.notifyItemRemoved(position)
    }

    //3. Long button pressed
    override fun itemClickLong(view: View, position: Int, task: Task) {
        openViewFragment(task)
    }

    //open view fragment
    private fun openViewFragment(task: Task) {
        val action = DashBoardFragmentDirections.actionDashBoardFragmentToViewTask(task)
        findNavController().navigate(action)
    }

    //open update Fragment
    private fun openUpdateFragment(task: Task) {
        val action = DashBoardFragmentDirections.actionDashBoardFragmentToEditOrAddFragment(task,true)
        findNavController().navigate(action)
    }
}