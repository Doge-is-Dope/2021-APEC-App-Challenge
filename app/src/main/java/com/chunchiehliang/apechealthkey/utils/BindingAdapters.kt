package com.chunchiehliang.apechealthkey.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chunchiehliang.apechealthkey.R
import com.chunchiehliang.apechealthkey.map.AttractionListAdapter
import com.chunchiehliang.apechealthkey.models.Attraction
import com.chunchiehliang.apechealthkey.models.Check
import com.chunchiehliang.apechealthkey.profile.CheckListAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("listData")
fun RecyclerView.setCheckData(data: List<Check>?) {
    val adapter = adapter as CheckListAdapter
    adapter.submitList(data)
}

@BindingAdapter("attractionData")
fun RecyclerView.setAttractionData(data: List<Attraction>?) {
    val adapter = adapter as AttractionListAdapter
    adapter.submitList(data)
}

@BindingAdapter("isOpen", "distance")
fun TextView.setMapOpenWithDistance(isOpen: Boolean, distance: Int) {

    val distanceStringInKm =  if (distance < 1000) "$distance m" else "${(distance / 1000)} km"
    text = resources.getString(
        R.string.text_attraction_dot_separator,
        if (isOpen) "Open" else "Closed",
        distanceStringInKm
    )
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

@BindingAdapter("imageUrl")
fun ImageView.bindImage(imgId: Int?) {
    imgId?.let {
//        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()

        val sharedOptions: RequestOptions = RequestOptions()
//            .placeholder(R.drawable.loading_animation)
//            .error(R.drawable.ic_broken_image)

        Glide.with(context)
            .load(imgId)
            .apply(sharedOptions)
            .into(this)
    }
}