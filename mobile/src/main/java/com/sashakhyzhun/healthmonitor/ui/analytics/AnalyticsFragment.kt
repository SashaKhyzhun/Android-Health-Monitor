package com.sashakhyzhun.healthmonitor.ui.analytics

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.utils.ColorTemplate;

import com.sashakhyzhun.healthmonitor.R
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.sashakhyzhun.healthmonitor.R.id.chart
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.components.XAxis
import android.support.v4.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.*


class AnalyticsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.analytics_fragment, container, false)

        val chart: LineChart = view.findViewById(R.id.chart)

        val entries = ArrayList<Entry>()
        entries.add(Entry(0F, 4F))
        entries.add(Entry(1F, 1F))
        entries.add(Entry(2F, 2F))
        entries.add(Entry(3F, 4F))

        val dataSet = LineDataSet(entries, "Customized values")
        dataSet.color = ContextCompat.getColor(context!!, R.color.colorPrimary)
        dataSet.valueTextColor = ContextCompat.getColor(context!!, R.color.colorPrimaryDark)

        //****
        // Controlling X axis
        val xAxis = chart.xAxis
        // Set the xAxis position to bottom. Default is top
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        //Customizing x axis value
        val months = arrayOf("Jan", "Feb", "Mar", "Apr")

        val formatter = IAxisValueFormatter { value, axis -> months[value.toInt()] }
        xAxis.granularity = 1f // minimum axis-step (interval) is 1
        xAxis.valueFormatter = formatter

        //***
        // Controlling right side of y axis
        val yAxisRight = chart.axisRight
        yAxisRight.isEnabled = false

        //***
        // Controlling left side of y axis
        val yAxisLeft = chart.axisLeft
        yAxisLeft.granularity = 1f

        // Setting Data
        val data = LineData(dataSet)
        chart.setData(data)
        chart.animateX(2500)
        //refresh
        chart.invalidate()

        return view
    }



}
