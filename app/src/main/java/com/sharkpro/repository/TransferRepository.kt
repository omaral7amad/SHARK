package com.sharkpro.repository

import com.sharkpro.data.local.dao.TransferDao
import com.sharkpro.data.local.entities.TransferEntity
import kotlinx.coroutines.flow.Flow

class TransferRepository(private val transferDao: TransferDao) {
    val allTransfers: Flow<List<TransferEntity>> = transferDao.getAllTransfers()

    suspend fun insertTransfer(transfer: TransferEntity) {
        transferDao.insertTransfer(transfer)
    }

    suspend fun getTransferById(id: Long): TransferEntity? {
        return transferDao.getTransferById(id)
    }
}
