package com.example.giphyapp.presentation.gif_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphyapp.common.Constants
import com.example.giphyapp.common.Resource
import com.example.giphyapp.domain.use_case.GetGifByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GifDetailViewModel @Inject constructor(
    private val getGifByIdUseCase: GetGifByIdUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(GifDetailState())
    val state: State<GifDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_GIF_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getGifByIdUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = GifDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = GifDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = GifDetailState(gif = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}