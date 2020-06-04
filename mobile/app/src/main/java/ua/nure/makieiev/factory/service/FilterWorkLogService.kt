package ua.nure.makieiev.factory.service

import android.content.Context
import ua.nure.makieiev.factory.model.entity.FilterWorkLog

interface FilterWorkLogService {

    fun getAllFilterWorkLog(context: Context): List<FilterWorkLog>

}