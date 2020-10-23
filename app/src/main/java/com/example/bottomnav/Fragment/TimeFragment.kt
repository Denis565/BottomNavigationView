package com.example.bottomnav.Fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bottomnav.R
import kotlinx.android.synthetic.main.fragment_time.*
import java.util.*

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class TimeFragment : Fragment() {

    private var currentDataTime: TextView? = null
    private var dateAndTime = Calendar.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_time, container, false)
        currentDataTime = view.findViewById<View>(R.id.currentDataTimes) as TextView
        setInitialDateTime()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnTime.setOnClickListener {
            setTime(view)
        }

        btnData.setOnClickListener {
            setDate(view)
        }
    }

    private fun setDate(view: View) {
        context?.let {
            DatePickerDialog(
                it,
                date,
                dateAndTime[Calendar.YEAR],
                dateAndTime[Calendar.MONDAY],
                dateAndTime[Calendar.DAY_OF_MONTH]
            ).show()
        }
    }

    //отображаем диалоговое окно для выбора времени
    private fun setTime(view: View) {
        TimePickerDialog(
            context,
            time,
            dateAndTime[Calendar.HOUR_OF_DAY],
            dateAndTime[Calendar.MINUTE], true
        ).show()
    }

    //установка начальных значений даты и времени
    private fun setInitialDateTime() {
        currentDataTime!!.text = DateUtils.formatDateTime(
            context,
            dateAndTime.timeInMillis,
            DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
                    or DateUtils.FORMAT_SHOW_TIME
        )
    }

    //установка обработчика выбора временеи
    private var time = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
        dateAndTime[Calendar.HOUR_OF_DAY] = hourOfDay
        dateAndTime[Calendar.MINUTE] = minute
        setInitialDateTime()
    }

    // установка обработчика выбора даты
    private var date = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
        dateAndTime[Calendar.YEAR] = year
        dateAndTime[Calendar.MONDAY] = monthOfYear
        dateAndTime[Calendar.DAY_OF_MONTH] = dayOfMonth
        setInitialDateTime()
    }

}