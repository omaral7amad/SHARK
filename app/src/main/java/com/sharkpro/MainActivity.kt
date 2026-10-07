package com.sharkpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.room.Room
import com.sharkpro.data.local.AppDatabase
import com.sharkpro.repository.TransferRepository
import com.sharkpro.ui.AddTransferScreen
import com.sharkpro.ui.TransferListScreen
import com.sharkpro.ui.TransferViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "sharkpro_db"
        ).build()

        val repository = TransferRepository(db.transferDao())
        val viewModel = TransferViewModel(repository)

        setContent {
            var currentScreen by remember { mutableStateOf("list") }

            when (currentScreen) {
                "list" -> TransferListScreen(
                    viewModel = viewModel,
                    onAddTransferClick = { currentScreen = "add" }
                )
                "add" -> AddTransferScreen(
                    viewModel = viewModel,
                    onTransferSaved = { currentScreen = "list" }
                )
            }
        }
    }
}
