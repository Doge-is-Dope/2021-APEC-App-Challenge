package com.chunchiehliang.apechealthkey.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chunchiehliang.apechealthkey.R
import com.chunchiehliang.apechealthkey.models.Check
import com.chunchiehliang.apechealthkey.profile.CheckListAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("listData")
fun RecyclerView.setCheckData(data: List<Check>?) {
    val adapter = adapter as CheckListAdapter
    adapter.submitList(data)
}

@BindingAdapter("lastUpdated")
fun TextView.setLastUpdated(date: Date?) {
    val calendar = Calendar.getInstance()
    date?.let {
        calendar.time = it
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        text = context.getString(R.string.text_updated, dateFormat.format(calendar.time))
    }
}