package ua.nure.makieiev.factory

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ua.nure.makieiev.factory.facade.RetrofitInstance
import ua.nure.makieiev.factory.facade.WorkLogFacade
import ua.nure.makieiev.factory.model.dto.WorkLogDto
import ua.nure.makieiev.factory.model.entity.WorkLog
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MarkWorkDayActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mark_work_day)
        checkWorkDay()
        initMarkButton()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun checkWorkDay() {
        val retrofitInstance =
            RetrofitInstance.getRetrofitInstance().create(WorkLogFacade::class.java)
        val sharedPreference =
            this.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val token = sharedPreference.getString("token", "")
        val userId: Long = sharedPreference.getLong("userId", 0)
        val localDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formattedString = localDate.format(formatter)
        retrofitInstance.getWorkLogByUserIdAndWorkDate(userId, formattedString, token)
            .enqueue(object : Callback<WorkLog> {
                override fun onFailure(call: Call<WorkLog>, t: Throwable) {
                    Toast.makeText(
                        this@MarkWorkDayActivity,
                        t.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onResponse(
                    call: Call<WorkLog>,
                    response: Response<WorkLog>
                ) {
                    if (response.code() == 200) {
                        val workLog = response.body()!!
                        showMarkInformation(workLog)
                        val sharedPreference =
                            this@MarkWorkDayActivity.getSharedPreferences(
                                "PREFERENCE_NAME",
                                Context.MODE_PRIVATE
                            )
                        val edit = sharedPreference.edit()
                        Toast.makeText(this@MarkWorkDayActivity, "Success!", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(this@MarkWorkDayActivity, "Failed!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initMarkButton() {
        val sharedPreference =
            this.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val token = sharedPreference.getString("token", "")
        val userLogin: String = sharedPreference.getString("login", "")
        val localDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formattedString = localDate.format(formatter)
        val workLogDto = WorkLogDto("2020-06-07", userLogin)

        val retrofitInstance =
            RetrofitInstance.getRetrofitInstance().create(WorkLogFacade::class.java)
        retrofitInstance.addWorkLog(workLogDto, token).enqueue(object : Callback<WorkLog> {
            override fun onFailure(call: Call<WorkLog>, t: Throwable) {
                Toast.makeText(
                    this@MarkWorkDayActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<WorkLog>, response: Response<WorkLog>) {
                if (response.code() == 200) {
                    val workLog: WorkLog? = response.body()
                    workLog?.let { showMarkInformation(it) }
                    Toast.makeText(this@MarkWorkDayActivity, "Login success!", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(this@MarkWorkDayActivity, "Login failed!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun showMarkInformation(workLog: WorkLog) {
        if (Objects.nonNull(workLog.amountPoints)) {
            val markButton = findViewById<Button>(R.id.markButton)
            markButton.visibility = View.GONE
            val amountPointsTextView =
                findViewById<TextView>(R.id.amountPointsTextView)
            amountPointsTextView.text = workLog.amountPoints.toString()
            val markInfoTextView = findViewById<TextView>(R.id.infoMarkTextView)
            markInfoTextView.visibility = View.VISIBLE
        }
    }

}