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
import com.github.mikephil.charting.charts.BubbleChart
import com.github.mikephil.charting.charts.LineChart
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

        val lineChart: LineChart = view.findViewById(R.id.lineChart)
        createLineChart(lineChart)

        val bubbleChart: BubbleChart = view.findViewById(R.id.bubbleChart)
        createBubbleChart(bubbleChart)

        val barChart: BarChart = view.findViewById(R.id.barChart)
        createBarChart(barChart)

        return view
    }


    private fun createLineChart(chart: LineChart) {
        val entries = ArrayList<Entry>()
        entries.add(Entry(0F, 4F))
        entries.add(Entry(1F, 1F))
        entries.add(Entry(2F, 2F))
        entries.add(Entry(3F, 4F))

        val dataSet = LineDataSet(entries, "Customized values")
        dataSet.color = ContextCompat.getColor(context!!, R.color.primary)
        dataSet.valueTextColor = ContextCompat.getColor(context!!, R.color.primary)

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
        chart.data = data
        chart.animateX(2500)
        //refresh
        chart.invalidate()
    }

    private fun createBubbleChart(chart: BubbleChart) {
        val entries = ArrayList<BubbleEntry>()
        entries.add(BubbleEntry(1F, 1F, 1F))
        entries.add(BubbleEntry(2F, 2F, 2F))
        entries.add(BubbleEntry(3F, 3F, 3F))
        entries.add(BubbleEntry(4F, 4F, 4F))

        val dataSet = BubbleDataSet(entries, "Customized values")
        dataSet.color = ContextCompat.getColor(context!!, R.color.primary)
        dataSet.valueTextColor = ContextCompat.getColor(context!!, R.color.primary_dark)

        //****
        // Controlling X axis
        val xAxis = chart.xAxis
        // Set the xAxis position to bottom. Default is top
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        //Customizing x axis value
        val months = arrayOf("Jan", "Feb", "Mar", "Apr")

        //val formatter = IAxisValueFormatter { value, axis -> months[value.toInt()] }
        xAxis.granularity = 1f // minimum axis-step (interval) is 1
        //xAxis.valueFormatter = formatter

        //***
        // Controlling right side of y axis
        val yAxisRight = chart.axisRight
        yAxisRight.isEnabled = false

        //***
        // Controlling left side of y axis
        val yAxisLeft = chart.axisLeft
        yAxisLeft.granularity = 1f

        // Setting Data
        val data = BubbleData(dataSet)
        chart.data = data
        chart.animateX(2500)
        //refresh
        chart.invalidate()
    }

    private fun createBarChart(chart: BarChart) {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0F, 4F))
        entries.add(BarEntry(1F, 1F))
        entries.add(BarEntry(2F, 2F))
        entries.add(BarEntry(3F, 4F))

        val dataSet = BarDataSet(entries, "Customized values")
        dataSet.color = ContextCompat.getColor(context!!, R.color.primary)
        dataSet.valueTextColor = ContextCompat.getColor(context!!, R.color.primary_dark)

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
        val data = BarData(dataSet)
        chart.data = data
        chart.animateX(2500)
        //refresh
        chart.invalidate()
    }



}
