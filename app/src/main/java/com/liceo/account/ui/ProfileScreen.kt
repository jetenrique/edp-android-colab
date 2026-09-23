package com.liceo.account.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.liceo.account.domain.model.User

@Composable
fun ProfileScreen(user: User, onLogout: () -> Unit) {
    Column(Modifier.fillMaxSize().systemBarsPadding().verticalScroll(rememberScrollState()).padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                Text("You successfully logged in!", fontWeight = FontWeight.Bold, color = Color(0xFF1B5E20))
                Text("Welcome back, ${user.fullName}.")
            }
        }
        Text("My Profile", style = MaterialTheme.typography.headlineSmall)
        ProfileRow("Full name", user.fullName)
        ProfileRow("Email", user.email)
        ProfileRow("Birthdate", user.birthdate)
        ProfileRow("User ID", user.id)
        ageFrom(user.birthdate)?.let { ProfileRow("Age", "$it years old") }
        Button(onLogout, modifier = Modifier.fillMaxWidth()) { Text("Log out") }
    }
}

@Composable
fun ProfileRow(label: String, value: String) {
    Column {
        Text(label, style = MaterialTheme.typography.labelMedium)
        Text(value, style = MaterialTheme.typography.bodyLarge)
    }
}

fun ageFrom(birthdate: String): Int? {
    val parts = birthdate.split("-")
    if (parts.size != 3) return null
    val year = parts[0].toIntOrNull() ?: return null
    val month = parts[1].toIntOrNull() ?: return null
    val day = parts[2].toIntOrNull() ?: return null
    val now = java.util.Calendar.getInstance()
    val thisYear = now.get(java.util.Calendar.YEAR)
    val thisMonth = now.get(java.util.Calendar.MONTH) + 1
    val thisDay = now.get(java.util.Calendar.DAY_OF_MONTH)
    var age = thisYear - year
    if (thisMonth < month || (thisMonth == month && thisDay < day)) age -= 1
    return age
}
