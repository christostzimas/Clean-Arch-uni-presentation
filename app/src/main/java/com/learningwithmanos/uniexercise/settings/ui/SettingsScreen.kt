package com.learningwithmanos.uniexercise.settings.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen (
    onIconButtonPressed: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {

    val pubKey = viewModel.publicKeyState.value.value.toString()
    val privateKey = viewModel.privateKeyState.value.value.toString()

    Scaffold (
        modifier = Modifier.nestedScroll(
            TopAppBarDefaults.pinnedScrollBehavior(
                rememberTopAppBarState()
            ).nestedScrollConnection),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Marvel Api Settings")
                },
                actions = {
                    IconButton(onClick = onIconButtonPressed ) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Api Setup"
                        )
                    }
                }
            )
        }
    ) {
            innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Marvel Public API Key",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    TextField(
                        value = pubKey,
                        onValueChange = { newText ->
                            viewModel.viewModelScope.launch {
                                viewModel.updatePublicKey(newText)
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = "Marvel Private API Key",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    TextField(
                        value = privateKey,
                        onValueChange = { newText ->
                            viewModel.viewModelScope.launch {
                                viewModel.updatePrivateKey(newText)
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
    }
}