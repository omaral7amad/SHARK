package com.sharkpro.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sharkpro.data.local.dao.TransferDao
import com.sharkpro.data.local.entities.TransferEntity
import com.sharkpro.utils.Converters

@Database(
    entities = [TransferEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transferDao(): TransferDao
}
