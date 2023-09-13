package com.example.giphyapp.domain.use_case

import com.example.giphyapp.common.Resource
import com.example.giphyapp.data.remote.dto.gif.toGif
import com.example.giphyapp.domain.model.gif.Gif
import com.example.giphyapp.domain.repository.GiphyRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGifByIdUseCase @Inject constructor(
    private val repository: GiphyRepository
) {
    operator fun invoke(gifId: String) = flow {
        try {
            emit(Resource.Loading<Gif>())
            val gif = repository.getGifById(gifId).toGif()
            emit(Resource.Success<Gif>(gif))
        } catch(e: HttpException) {
            emit(Resource.Error<Gif>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<Gif>("Couldn't reach server. Check your internet connection."))
        }
    }
}