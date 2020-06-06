package ua.nure.makieiev.factory

import android.content.Context
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ua.nure.makieiev.factory.adapter.StatisticListViewAdapter
import ua.nure.makieiev.factory.facade.FilterWorkLogFacade
import ua.nure.makieiev.factory.facade.RetrofitInstance
import ua.nure.makieiev.factory.model.entity.FilterWorkLog
import ua.nure.makieiev.factory.service.FilterWorkLogService
import ua.nure.makieiev.factory.service.impl.FilterWorkLogServiceImpl


class FilterStatisticActivity : AppCompatActivity() {

    private lateinit var filterWorkLogService: FilterWorkLogService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_statistic)
        initObjects()
        displayFilterStatisticInformation()
    }

    private fun initObjects() {
        filterWorkLogService = FilterWorkLogServiceImpl()
    }

    private fun displayFilterStatisticInformation() {
        val retrofitInstance =
            RetrofitInstance.getRetrofitInstance().create(FilterWorkLogFacade::class.java)
        val sharedPreference =
            this.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val token = sharedPreference.getString("token", "")
        var filterWorkLogs: List<FilterWorkLog>
        retrofitInstance.getAllFilterWorkLogs(token)
            .enqueue(object : Callback<List<FilterWorkLog>> {
                override fun onFailure(call: Call<List<FilterWorkLog>>, t: Throwable) {
                    Toast.makeText(
                        this@FilterStatisticActivity,
                        t.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onResponse(
                    call: Call<List<FilterWorkLog>>,
                    response: Response<List<FilterWorkLog>>
                ) {
                    if (response.code() == 200) {
                        filterWorkLogs = response.body()!!
                        val filterStatisticListView =
                            findViewById<ListView>(R.id.filterStatisticView)
                        filterStatisticListView.adapter =
                            StatisticListViewAdapter(this@FilterStatisticActivity, filterWorkLogs)
                        val sharedPreference =
                            this@FilterStatisticActivity.getSharedPreferences(
                                "PREFERENCE_NAME",
                                Context.MODE_PRIVATE
                            )
                        val edit = sharedPreference.edit()
                        Toast.makeText(this@FilterStatisticActivity, "Success!", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(this@FilterStatisticActivity, "Failed!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })

    }

}