package com.sashakhyzhun.healthmonitor.ui.analytics

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.utils.ColorTemplate;

import com.sashakhyzhun.healthmonitor.R
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet


class AnalyticsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.analytics_fragment, container, false)

        val chart: BarChart = view.findViewById(R.id.chart)

        val barCharts = ArrayList<BarEntry>()

        barCharts.add(BarEntry(945f, 0f))
        barCharts.add(BarEntry(1040f, 1f))
        barCharts.add(BarEntry(1133f, 2f))
        barCharts.add(BarEntry(1240f, 3f))
        barCharts.add(BarEntry(1369f, 4f))
        barCharts.add(BarEntry(1487f, 5f))
        barCharts.add(BarEntry(1501f, 6f))
        barCharts.add(BarEntry(1645f, 7f))
        barCharts.add(BarEntry(1578f, 8f))
        barCharts.add(BarEntry(1695f, 9f))

        val year = ArrayList<String>()

        year.add("2008")
        year.add("2009")
        year.add("2010")
        year.add("2011")
        year.add("2012")
        year.add("2013")
        year.add("2014")
        year.add("2015")
        year.add("2016")
        year.add("2017")

        val barDataSet = BarDataSet(barCharts, "No Of Employee")

        chart.animateY(5000)
        val data = BarData(year as IBarDataSet, barDataSet)
        barDataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
        chart.data = data

        return view
    }



}
