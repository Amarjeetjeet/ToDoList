package com.lunartechnolabs.todolist.presentation.editordelete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.lunartechnolabs.todolist.databinding.FragmentEditOrAddBinding
import com.lunartechnolabs.todolist.domain.model.Task
import com.lunartechnolabs.todolist.presentation.dashboard.DashBoardViewModel
import com.lunartechnolabs.todolist.util.transformIntoDatePicker
import com.lunartechnolabs.todolist.util.transformIntoTimePicker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditOrAddFragment : Fragment() {

    private  var _binding: FragmentEditOrAddBinding ?= null
    private val binding get() = _binding!!
    private val viewModel : DashBoardViewModel by viewModels()
    private lateinit var radioButton: RadioButton
    private val args : EditOrAddFragmentArgs by navArgs()
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

        binding.edtTime.transformIntoTimePicker(requireContext(), "HH:mm aaa")
        binding.edtDate.transformIntoDatePicker(requireContext(), "MM/dd/yyyy")

        if (args.isForUpdate){
            //update
            updateTask()
        }else{
            //add
            addTask()
        }
    }

    private fun updateTask() {
        binding.addArticleBtn.text = "Update Task"
            binding.apply {
                args.taskData.let {
                    edtTitle.setText(it.title)
                    edtBody.setText(it.detail)
                    edtTime.setText(it.taskTime)
                    edtDate.setText(it.taskDate)

                    when (it.priority) {
                        "Urgent" -> {
                            radioButton3.isChecked = true
                        }
                        "Medium" -> {
                            radioButton2.isChecked = true
                        }
                        else -> {
                            radioButton1.isChecked = true
                        }
                    }
                }

            }
        binding.addArticleBtn.setOnClickListener {
        if (validation()) {
            val selectedOption: Int = binding.radioGroup.checkedRadioButtonId
            radioButton = view?.findViewById(selectedOption)!!
                val task = Task(
                    id = args.taskData.id,
                    title = binding.edtTitle.text.toString(),
                    detail = binding.edtBody.text.toString(),
                    priority = radioButton.text.toString(),
                    taskDate = binding.edtDate.text.toString(),
                    taskTime = binding.edtTime.text.toString()
                )
                viewModel.updateArticle(task)
                findNavController().popBackStack()
            }
        }
    }

    private fun addTask() {
        binding.addArticleBtn.setOnClickListener {

            if (validation()) {
                val selectedOption: Int = binding.radioGroup.checkedRadioButtonId

                radioButton = view?.findViewById(selectedOption)!!
                val task = Task(
                    title = binding.edtTitle.text.toString(),
                    detail = binding.edtBody.text.toString(),
                    priority = radioButton.text.toString(),
                    taskDate = binding.edtDate.text.toString(),
                    taskTime = binding.edtTime.text.toString()
                )
                viewModel.addArticle(task)
                findNavController().popBackStack()
            }
        }
    }

    private fun validation(): Boolean {
        return if (binding.edtTitle.text.isNullOrBlank()) {
            binding.inputTitle.error = "Title can't Be Empty!!"
            false
        } else{
            true
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}