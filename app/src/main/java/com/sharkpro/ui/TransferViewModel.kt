package com.sharkpro.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharkpro.data.local.entities.TransferEntity
import com.sharkpro.repository.TransferRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TransferViewModel(private val repository: TransferRepository) : ViewModel() {

    val transfers: StateFlow<List<TransferEntity>> = repository.allTransfers
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addTransfer(
        recipientName: String,
        amount: String,
        currency: String,
        agentId: Long?,
        status: String = "PENDING"
    ) {
        viewModelScope.launch {
            val transfer = TransferEntity(
                recipientName = recipientName,
                amount = amount,
                currency = currency,
                agentId = agentId,
                status = status
            )
            repository.insertTransfer(transfer)
        }
    }
}
