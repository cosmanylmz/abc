package com.example.jsoncompose3.arayuzler

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.jsoncompose3.data.Photo
import com.example.jsoncompose3.data.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    var photos by remember { mutableStateOf(emptyList<Photo>()) }

    LaunchedEffect(Unit) {
        RetrofitInstance.api.getPhotos().enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    photos = response.body() ?: emptyList()
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                // Handle failure
            }
        })
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Photo Album") }
            )
        },
        content = { paddingValues ->
            PhotoGrid(photos, Modifier.padding(paddingValues))
        }
    )
}