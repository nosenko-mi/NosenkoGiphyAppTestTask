package com.example.giphyapp.domain.use_case

import com.example.giphyapp.common.Resource
import com.example.giphyapp.data.remote.dto.gif.toGif
import com.example.giphyapp.domain.model.gif.Gif
import com.example.giphyapp.domain.repository.GiphyRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGifsUseCase @Inject constructor(
    private val repository: GiphyRepository
) {
    operator fun invoke() = flow {
        try {
            emit(Resource.Loading<List<Gif>>())
            val gifs = repository.getGifs().map { it.toGif() }
            emit(Resource.Success<List<Gif>>(gifs))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Gif>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Gif>>("Couldn't reach server. Check your internet connection."))
        }
    }
}