package ua.nure.makieiev.factory.service.impl

import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ua.nure.makieiev.factory.facade.FilterWorkLogFacade
import ua.nure.makieiev.factory.facade.RetrofitInstance
import ua.nure.makieiev.factory.model.entity.FilterWorkLog
import ua.nure.makieiev.factory.service.FilterWorkLogService

class FilterWorkLogServiceImpl : FilterWorkLogService {

    override fun getAllFilterWorkLog(context: Context): List<FilterWorkLog> {
        val retrofitInstance =
            RetrofitInstance.getRetrofitInstance().create(FilterWorkLogFacade::class.java)
        val sharedPreference =
            context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val token = sharedPreference.getString("token", "")
        var filterWorkLogs: List<FilterWorkLog> = mutableListOf()
        retrofitInstance.getAllFilterWorkLogs(token)
            .enqueue(object : Callback<List<FilterWorkLog>> {
                override fun onFailure(call: Call<List<FilterWorkLog>>, t: Throwable) {
                    Toast.makeText(
                        context,
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
                        val sharedPreference =
                            context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                        val edit = sharedPreference.edit()
                        Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        return filterWorkLogs
    }

}