package com.sharkpro.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddTransferScreen(
    viewModel: TransferViewModel,
    onTransferSaved: () -> Unit
) {
    var recipientName by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var currency by remember { mutableStateOf("USD") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "إضافة حوالة جديدة",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = recipientName,
            onValueChange = { recipientName = it },
            label = { Text("اسم المستلم") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("المبلغ") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = currency,
            onValueChange = { currency = it },
            label = { Text("العملة") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (recipientName.isNotBlank() && amount.isNotBlank()) {
                    viewModel.addTransfer(
                        recipientName = recipientName,
                        amount = amount,
                        currency = currency,
                        agentId = null
                    )
                    onTransferSaved()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("حفظ الحوالة")
        }
    }
}
