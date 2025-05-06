package com.example.roomtipapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TipViewModel(private val tipDao: TipDao) : ViewModel() {

    private val _tipInput = MutableStateFlow("")
    val tipInput: StateFlow<String> = _tipInput

    private val _tips = MutableStateFlow<List<Tip>>(emptyList())
    val tips: StateFlow<List<Tip>> = _tips

    fun onTipInputChange(newValue: String) {
        _tipInput.value = newValue
    }

    fun saveTip() {
        val value = _tipInput.value.toDoubleOrNull() ?: return
        viewModelScope.launch {
            tipDao.insertTip(Tip(amount = value))
            loadTips()
            _tipInput.value = ""
        }
    }

    fun loadTips() {
        viewModelScope.launch {
            _tips.value = tipDao.getAllTips()
        }
    }
}
