package com.example.expenses.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.expenses.data.Expense
import com.example.expenses.data.ExpenseDatabase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ExpenseViewModel(app: Application) : AndroidViewModel(app) {
    private val dao = ExpenseDatabase.get(app).expenseDao()

    val expenses: StateFlow<List<Expense>> = dao.observeAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun add(description: String, amount: Double) {
        viewModelScope.launch { dao.insert(Expense(description = description.trim(), amount = amount)) }
    }
}
