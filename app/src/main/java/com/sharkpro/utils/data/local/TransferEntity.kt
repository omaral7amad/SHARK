package com.sharkpro.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transfers")
data class TransferEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val recipientName: String, // اسم المستلم
    val amount: String,        // المبلغ المحول
    val currency: String,      // العملة
    val agentId: Long?,        // معرف الوكيل
    val status: String,        // حالة الحوالة
    val timestamp: Long = System.currentTimeMillis() // تاريخ العملية
)
