package com.lunartechnolabs.todolist.util

import android.app.DatePickerDialog
import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.content.Context
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*


fun EditText.transformIntoDatePicker(context: Context, format: String, maxDate: Date? = null) {
    isFocusableInTouchMode = false
    isClickable = true
    isFocusable = false

    val myCalendar = Calendar.getInstance()
    val datePickerOnDataSetListener =
        DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            val sdf = SimpleDateFormat(format, Locale.UK)
            setText(sdf.format(myCalendar.time))
        }

    setOnClickListener {
        DatePickerDialog(
            context, datePickerOnDataSetListener, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)
        ).run {
            maxDate?.time?.also { datePicker.maxDate = it }
            show()
        }
    }
}


fun EditText.transformIntoTimePicker(context: Context, format: String, maxDate: Date? = null) {
    isFocusableInTouchMode = false
    isClickable = true
    isFocusable = false

    val myCalendar = Calendar.getInstance()
    val datePickerOnDataSetListener =
        TimePickerDialog.OnTimeSetListener { _, i, i2 ->
            myCalendar.set(Calendar.HOUR, i)
            myCalendar.set(Calendar.MINUTE, i2)
            val sdf = SimpleDateFormat(format, Locale.UK)
            setText(sdf.format(myCalendar.time))
        }


    setOnClickListener {
        TimePickerDialog(
            context, datePickerOnDataSetListener,
            myCalendar.get(Calendar.HOUR),
            myCalendar.get(Calendar.MINUTE),
            false
        ).run {
            show()
        }
    }
}