package ua.nure.makieiev.factory.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ua.nure.makieiev.factory.R
import ua.nure.makieiev.factory.model.entity.FilterWorkLog

class StatisticListViewAdapter(context: Context, filterWorkLogs: List<FilterWorkLog>) :
    BaseAdapter() {

    private val mContext: Context = context
    private val mFilterWorkLog: List<FilterWorkLog> = filterWorkLogs

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowListView: View = layoutInflater.inflate(R.layout.row, parent, false)
        val filterTitle: TextView = rowListView.findViewById(R.id.filterInfoText)
        val unitTitle: TextView = rowListView.findViewById(R.id.unitInfoText)
        val dateInformation: TextView = rowListView.findViewById(R.id.dateInfoText)
        val temperatureInformation: TextView = rowListView.findViewById(R.id.temperatureInfoText)
        val filterContaminationInfo: TextView =
            rowListView.findViewById(R.id.filterContaminationInfoText)
        filterTitle.text = mFilterWorkLog[position].filterUnit!!.filter!!.title
        unitTitle.text = mFilterWorkLog[position].filterUnit!!.unit!!.title
        dateInformation.text = mFilterWorkLog[position].scanDateTime.toString()
        temperatureInformation.text = mFilterWorkLog[position].temperature
        filterContaminationInfo.text = mFilterWorkLog[position].filterContamination.toString()

        return rowListView
    }

    override fun getItem(position: Int): Any {
        return mFilterWorkLog[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return mFilterWorkLog.size
    }

}