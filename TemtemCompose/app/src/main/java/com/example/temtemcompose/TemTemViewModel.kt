package com.example.temtemcompose

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.temtemcompose.models.TemTem
import com.example.temtemcompose.models.TemType
import com.example.temtemcompose.models.techniques.TechniqueInfo
import kotlinx.coroutines.launch

class TemTemViewModel: ViewModel() {
    private val temList = mutableStateListOf<TemTem>()
    val typeList = mutableStateListOf<TemType>()
    val techniqueList = mutableStateListOf<TechniqueInfo>()
    val filteredTemList = mutableStateListOf<TemTem>()
    val currentTem = mutableStateOf<TemTem?>(null)

    init {
        getTemList()
        getTemTypeList()
        getTechniqueList()
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

    /**
     * Finds the matching type icon
     * @param type temtem type
     */
    fun findTypeIcon(type: String): String? =
        typeList.find { it.name == type}?.icon

    /**
     * Finds the matching technique
     * @param technique name of the technique
     */
    fun findTechnique(technique: String?): TechniqueInfo? =
        techniqueList.find { it.name == technique }

    fun selectTemTem(id: Int) {
        viewModelScope.launch {
            val call = TemTemServiceHelper.getInstance().create(TemTemService::class.java)
                .getTemTem(id)
            if (call.isSuccessful) {
                currentTem.value = call.body()
            }
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

    private fun getTechniqueList() {
        viewModelScope.launch {
            val call = TemTemServiceHelper.getInstance().create(TemTemService::class.java)
                .getTechniques()
            val list = call.body()
            if (call.isSuccessful) {
                techniqueList.clear()
                techniqueList.addAll(list ?: emptyList())
            }
        }
    }
}