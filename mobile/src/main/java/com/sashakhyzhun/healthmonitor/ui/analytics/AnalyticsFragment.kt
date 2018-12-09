package com.sashakhyzhun.healthmonitor.ui.analytics

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sashakhyzhun.healthmonitor.R
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.components.XAxis
import android.support.v4.content.ContextCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.*


class AnalyticsFragment : Fragment() {

    /**
     * Analyze:
     *
     * Weight
     * Heart rate (bpm)
     * Stress level
     *
     */

    /**
     * Store:
     *
     * Calories
     * Steps
     * Energy
     * Productivity
     * Sleep
     * Weight
     *
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_analytics, container, false)

        val chartWalking: BarChart = view.findViewById(R.id.barChartWalking)
        createWalkingChart(chartWalking)

        val chartCalories: BarChart = view.findViewById(R.id.bubbleChartCalories)
        createCaloriesChart(chartCalories)

        val chartHeartRate: BarChart = view.findViewById(R.id.barChartHeartRate)
        createHeartRateChart(chartHeartRate)

        val chartWeight: BarChart = view.findViewById(R.id.barChartHeartWeight)
        createWeightChart(chartWeight)

        return view
    }


    private fun createWalkingChart(chart: BarChart) {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0F, 6.5F))
        entries.add(BarEntry(1F, 4.8F))
        entries.add(BarEntry(2F, 7.1F))
        entries.add(BarEntry(3F, 4.9F))
        entries.add(BarEntry(4F, 8.5F))
        entries.add(BarEntry(5F, 7.3F))
        entries.add(BarEntry(6F, 7.4F))

        val dataSet = BarDataSet(entries, "Daily distance values")
        dataSet.color = ContextCompat.getColor(context!!, R.color.primary)
        dataSet.valueTextColor = ContextCompat.getColor(context!!, R.color.primary_dark)

        //****
        // Controlling X axis
        val xAxis = chart.xAxis
        // Set the xAxis position to bottom. Default is top
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        //Customizing x axis value
        val days = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

        val formatter = IAxisValueFormatter { value, axis -> days[value.toInt()] }
        xAxis.granularity = 1f // minimum axis-step (interval) is 1
        xAxis.valueFormatter = formatter

        //***
        // Controlling right side of y axis
        val yAxisRight = chart.axisRight
        yAxisRight.isEnabled = false
        // Controlling left side of y axis
        val yAxisLeft = chart.axisLeft
        yAxisLeft.granularity = 1f
        yAxisLeft.isEnabled = false
        yAxisLeft.mAxisMinimum = 0F
        yAxisLeft.maxWidth = 40F


        chart.description.isEnabled = false

        // Setting Data
        val data = BarData(dataSet)
        chart.data = data
        //chart.animateX(2500)
        //refresh
        chart.invalidate()
    }

    private fun createCaloriesChart(chart: BarChart) {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0F, 1600F))
        entries.add(BarEntry(1F, 1750F))
        entries.add(BarEntry(2F, 1900F))
        entries.add(BarEntry(3F, 1800F))
        entries.add(BarEntry(4F, 2100F))
        entries.add(BarEntry(5F, 1900F))
        entries.add(BarEntry(6F, 1925F))

        val dataSet = BarDataSet(entries, "Daily calories values")
        dataSet.color = ContextCompat.getColor(context!!, R.color.primary)
        dataSet.valueTextColor = ContextCompat.getColor(context!!, R.color.primary_dark)

        //****
        // Controlling X axis
        val xAxis = chart.xAxis
        // Set the xAxis position to bottom. Default is top
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        //Customizing x axis value
        val days = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

        val formatter = IAxisValueFormatter { value, axis ->
            days[value.toInt()]
        }

        xAxis.granularity = 1f // minimum axis-step (interval) is 1
        xAxis.valueFormatter = formatter

        //***
        // Controlling right side of y axis
        val yAxisRight = chart.axisRight
        yAxisRight.isEnabled = false
        // Controlling left side of y axis
        val yAxisLeft = chart.axisLeft
        yAxisLeft.granularity = 1f
        yAxisLeft.isEnabled = false

        chart.description.isEnabled = false

        // Setting Data
        val data = BarData(dataSet)
        chart.data = data
        //chart.animateX(2500)
        //refresh
        chart.invalidate()
    }

    private fun createHeartRateChart(chart: BarChart) {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0F, 85F))
        entries.add(BarEntry(1F, 87F))
        entries.add(BarEntry(2F, 84F))
        entries.add(BarEntry(3F, 85F))
        entries.add(BarEntry(4F, 88F))
        entries.add(BarEntry(5F, 89F))
        entries.add(BarEntry(6F, 90F))

        val dataSet = BarDataSet(entries, "Beat per minute values")
        dataSet.color = ContextCompat.getColor(context!!, R.color.primary)
        dataSet.valueTextColor = ContextCompat.getColor(context!!, R.color.primary_dark)

        //****
        // Controlling X axis
        val xAxis = chart.xAxis
        // Set the xAxis position to bottom. Default is top
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        //Customizing x axis value
        val days = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

        val formatter = IAxisValueFormatter { value, axis ->
            days[value.toInt()]
        }
        xAxis.granularity = 1f // minimum axis-step (interval) is 1
        xAxis.valueFormatter = formatter

        //***
        // Controlling right side of y axis
        val yAxisRight = chart.axisRight
        yAxisRight.isEnabled = false
        // Controlling left side of y axis
        val yAxisLeft = chart.axisLeft
        yAxisLeft.granularity = 1f
        yAxisLeft.isEnabled = false

        chart.description.isEnabled = false

        // Setting Data
        val data = BarData(dataSet)
        chart.data = data
        //chart.animateX(2500)
        //refresh
        chart.invalidate()
    }

    private fun createWeightChart(chart: BarChart) {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0F, 77.3F))
        entries.add(BarEntry(1F, 78F))
        entries.add(BarEntry(2F, 76.8F))
        entries.add(BarEntry(3F, 77.1F))
        entries.add(BarEntry(4F, 77.3F))
        entries.add(BarEntry(5F, 76.8f))
        entries.add(BarEntry(6F, 76.1F))

        val dataSet = BarDataSet(entries, "Weight values")
        dataSet.color = ContextCompat.getColor(context!!, R.color.primary)
        dataSet.valueTextColor = ContextCompat.getColor(context!!, R.color.primary_dark)

        //****
        // Controlling X axis
        val xAxis = chart.xAxis
        // Set the xAxis position to bottom. Default is top
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        //Customizing x axis value
        val months = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

        val formatter = IAxisValueFormatter { value, axis -> months[value.toInt()] }
        xAxis.granularity = 1f // minimum axis-step (interval) is 1
        xAxis.valueFormatter = formatter

        //***
        // Controlling right side of y axis
        val yAxisRight = chart.axisRight
        yAxisRight.isEnabled = false
        // Controlling left side of y axis
        val yAxisLeft = chart.axisLeft
        yAxisLeft.granularity = 1f
        yAxisLeft.isEnabled = false

        chart.description.isEnabled = false

        // Setting Data
        val data = BarData(dataSet)
        chart.data = data
        //chart.animateX(2500)
        //refresh
        chart.invalidate()
    }



}
