package com.example.giphyapp.presentation.gif_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphyapp.common.Resource
import com.example.giphyapp.domain.model.gif.Gif
import com.example.giphyapp.domain.use_case.GetGifsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GifListViewModel @Inject constructor(
    private val getGifsUseCase: GetGifsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(GifListState())
    val state: State<GifListState> = _state

    init {
        getGifs()
    }

    private fun getGifs(){
        getGifsUseCase().onEach { result ->
            when(result){
                is Resource.Error -> {
                    _state.value = GifListState(error = result.message ?: "Oops... Something went wrong!")
                }
                is Resource.Loading -> {
                    _state.value = GifListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = GifListState(gifs = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}