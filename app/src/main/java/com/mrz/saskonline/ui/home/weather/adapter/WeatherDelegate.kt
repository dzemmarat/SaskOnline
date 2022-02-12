package com.mrz.saskonline.ui.home.weather.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mrz.saskonline.R
import com.mrz.saskonline.app.core.Util
import com.mrz.saskonline.data.models.Weather
import com.mrz.saskonline.databinding.ItemHourlyWeatherBinding
import com.mrz.saskonline.ui.core.BaseAdapterDelegate

class WeatherDelegate(
    private val activity: Activity
) : BaseAdapterDelegate() {
    override fun isForItem(item: Any, items: MutableList<Any>, position: Int): Boolean =
        item is Weather

    override fun getViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder =
        WeatherViewHolder(ItemHourlyWeatherBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(item: Any, holder: ViewHolder, payloads: MutableList<Any>) {
        val viewHolder = holder as WeatherViewHolder
        viewHolder.bind(item as Weather)
    }

    inner class WeatherViewHolder(
        private val binding: ItemHourlyWeatherBinding
    ) : ViewHolder(binding.root) {
        fun bind(item: Weather) {
            binding.containerWeather.isEnabled =
                Util().getCurrentHourWithNull() == item.time && item.date == "${Util().getCurrentDay()} ${Util().getCurrentMonth()}"
            binding.tvItemTime.text = item.time
            binding.tvWeatherHourlyTemperature.text =
                activity.getString(R.string.weather_degrees, item.degrees.toString())
        }
    }
}