package ua.nure.makieiev.factory

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class FilterStatisticActivity : AppCompatActivity() {

    lateinit var listView: ListView
    var titles = arrayOf("14-05-2020 20:00", "14-05-2020 21:00", "14-05-2020 22:00")
    var temperatures = arrayOf("70 C", "65 C", " 80 C")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_statistic)
        listView = findViewById(R.id.filterStatisticView)
        val filterStatisticAdapter = FilterStatisticAdapter(this, titles, temperatures)
        listView.adapter = filterStatisticAdapter

        listView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                for (title in titles) {
                    if (position == 0) {
                        Toast.makeText(this, title, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
    }

    class FilterStatisticAdapter(
        context: Context,
        var rTitle: Array<String>,
        var rTemperatures: Array<String>
    ) : ArrayAdapter<String>(context, R.layout.row, R.id.dateInfoText, rTitle) {


        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?
        ): View {

            val layoutInflater =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val row: View = layoutInflater.inflate(R.layout.row, parent, false)
            val myTitle: TextView = row.findViewById(R.id.dateInfoText)
            val myDescription: TextView = row.findViewById(R.id.temperatureInfoText)

            myTitle.text = "Check date : " + rTitle[position]
            myDescription.text = "Temperature : " + rTemperatures[position]
            return row
        }

    }

}