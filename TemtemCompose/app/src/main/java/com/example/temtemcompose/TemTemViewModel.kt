package com.example.temtemcompose

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.temtemcompose.models.TemTem
import com.example.temtemcompose.models.TemType
import kotlinx.coroutines.launch

class TemTemViewModel: ViewModel() {
    val temList = mutableStateListOf<TemTem>()
    val typeList = mutableStateListOf<TemType>()
    val filteredTemList = mutableStateListOf<TemTem>()

    init {
        getTemList()
        getTemTypeList()
    }

    fun filter(type: String) {
        filteredTemList.clear()
        if (type.isEmpty()) {
            filteredTemList.addAll(temList)
        } else {
            filteredTemList.addAll(
                temList.filter { it.types?.contains(type) == true }
            )
        }
    }

    private fun getTemTypeList() {
        viewModelScope.launch {
            val call = TemTemServiceHelper.getInstance().create(TemTemService::class.java)
                .getTypes()
            val list = call.body()
            if (call.isSuccessful) {
                val types = list ?: emptyList()
                typeList.clear()
                typeList.addAll(types)
            }
        }
    }

    private fun getTemList() {
        viewModelScope.launch {
            val call = TemTemServiceHelper.getInstance().create(TemTemService::class.java)
                .listTemTem()
            val list = call.body()
            if (call.isSuccessful) {
                val tems = list ?: emptyList()
                temList.clear()
                temList.addAll(tems)
                filteredTemList.clear()
                filteredTemList.addAll(tems)
            }
        }
    }
}