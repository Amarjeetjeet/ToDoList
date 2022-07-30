package com.lunartechnolabs.todolist

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lunartechnolabs.todolist.databinding.FragmentViewTaskBinding

class ViewTask : BottomSheetDialogFragment() {

    private  var _binding: FragmentViewTaskBinding ?= null
    private val binding get() = _binding!!
    private val args : ViewTaskArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentViewTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            args.taskData.let {
                if (it?.title.isNullOrEmpty()){
                    tvTitle.text = "No Title"
                }else{
                    tvTitle.text = "Title\n" +  it?.title
                }

                if (it?.taskDate.isNullOrEmpty()){
                    tvDate.text = "No Date Selected"
                }else{
                    tvDate.text = "Date \n" + it?.taskDate
                }

                if (it?.taskTime.isNullOrEmpty()){
                    tvTime.text = "No Time Selected"
                }else{
                    tvTime.text = "Time \n" +  it?.taskTime
                }

                if (it?.detail.isNullOrEmpty()){
                    tvDescription.text = "No Description Added"
                }else{
                    tvDescription.text = "Description \n" +  it?.detail
                }

                if (it?.priority.isNullOrEmpty()){
                    tvPriority.text = "No Priority Selected"
                }else{
                    when (it?.priority) {
                        "High" -> {
                            tvPriority.text = "Priority \n" +  it.priority
                            tvPriority.setTextColor(Color.RED)
                        }
                        "Medium" -> {
                            tvPriority.text = "Priority \n" +  it.priority
                            tvPriority.setTextColor(Color.GREEN)
                        }
                        else -> {
                            tvPriority.text = "Priority \n" +  it?.priority
                            tvPriority.setTextColor(Color.BLACK)
                        }
                    }
                    tvPriority.text = "Priority \n" +  it?.priority
                }

            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}