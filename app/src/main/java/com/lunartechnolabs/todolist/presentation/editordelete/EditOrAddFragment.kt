package com.lunartechnolabs.todolist.presentation.editordelete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lunartechnolabs.todolist.databinding.FragmentDashBoardBinding
import com.lunartechnolabs.todolist.databinding.FragmentEditOrAddBinding
import com.lunartechnolabs.todolist.domain.model.Task
import com.lunartechnolabs.todolist.presentation.dashboard.DashBoardViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class EditOrAddFragment : Fragment() {

    private  var _binding: FragmentEditOrAddBinding ?= null
    private val binding get() = _binding!!
    private val viewModel : DashBoardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditOrAddBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }

    private fun onClickListener() {


        binding.addArticleBtn.setOnClickListener {
            binding.radioButton1.isChecked = true
            val task = Task(binding.edtTitle.text.toString(),binding.radioGroup.checkedRadioButtonId.toString(),binding.edtBody.text.toString(),Date().time,Date().time)
            viewModel.addArticle(task)
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}