package com.example.rickandmortyapikotlin.data.repositories.pagingsourse

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapikotlin.data.network.apiservices.EpisodeApiServices
import com.example.rickandmortyapikotlin.model.EpisodeModel
import retrofit2.HttpException
import java.io.IOException

private const val EPISODE__SRARTING_PAGE_INDEX = 1

class EpisodePagingSource(
    private val episodeApiServices: EpisodeApiServices,
) : PagingSource<Int, EpisodeModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeModel> {
        val position = params.key ?: EPISODE__SRARTING_PAGE_INDEX
        return try {
            val response = episodeApiServices?.fetchEpisode(position)
            val nextPage = response?.info?.next
            val nextPageNumber = if (nextPage == null) {
                null
            } else {
                Uri.parse(response.info.next).getQueryParameter("page")?.toInt()
            }
            LoadResult.Page(
                data = response!!.results,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, EpisodeModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }
}