package com.lunartechnolabs.todolist.presentation.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lunartechnolabs.todolist.R
import com.lunartechnolabs.todolist.databinding.FragmentDashBoardBinding
import com.lunartechnolabs.todolist.domain.model.Task
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

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
        iniRecyclerview()
        bindObserver()

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardFragment_to_editOrAddFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun iniRecyclerview() {
        taskAdapter = TaskAdapter(this@DashBoardFragment)
        binding.articleRcv.layoutManager = LinearLayoutManager(requireActivity())
        binding.articleRcv.adapter = taskAdapter
    }

    private fun bindObserver() {
            lifecycleScope.launchWhenCreated {
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

    override fun itemClick(view: View, position: Int, task: Task) {

    }

    override fun btnClick(view: View, position: Int, task: Task) {
        viewModel.deleteArticle(task)
    }

    override fun itemClickLong(view: View, position: Int, task: Task) {
    }
}