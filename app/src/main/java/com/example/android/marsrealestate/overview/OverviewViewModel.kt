/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsrealestate.network.MarsApi
import com.example.android.marsrealestate.network.MarsProperty
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

    private val _properties = MutableLiveData<List<MarsProperty>>()
    val properties: LiveData<List<MarsProperty>>
        get() = _properties

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties()
    }

    /**
     * enqueue(Callback) is for Callback method
     * No more needed when using Coroutine
     */
    private fun getMarsRealEstateProperties() {
        _response.value = "Set the Mars API Response here!"
        /*
        MarsApi.retrofitService.getProperties().enqueue(object : Callback<List<MarsProperty>> {
            override fun onResponse(
                call: Call<List<MarsProperty>>,
                response: Response<List<MarsProperty>>
            ) {
                _response.value = "Sucess: Received ${response.body().size} Mars properties retieved"
            }

            override fun onFailure(call: Call<List<MarsProperty>>, t: Throwable) {
                _response.value = "Failed: ${t.message}"
            }

        })
         */
        viewModelScope.launch {
            try {
                _properties.value = MarsApi.retrofitService.getProperties()
                _response.value = "Sucess: ${properties.value?.size} Mars properties retieved"
            } catch (e: Exception) {
                _response.value = "Failed: ${e.message}"
            }
        }
    }
}