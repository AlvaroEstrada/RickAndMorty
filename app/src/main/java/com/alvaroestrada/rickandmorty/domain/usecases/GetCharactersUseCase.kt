package com.alvaroestrada.rickandmorty.domain.usecases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.alvaroestrada.rickandmorty.data.network.paging.CharactersPagingSource
import com.alvaroestrada.rickandmorty.data.repository.CharacterRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val pager: CharactersPagingSource
) {
    operator fun invoke(limit: Int) = Pager(
    // aquí el tamaño de página se comporta de forma curiosa, la primera petición (es así) multiplica el pagesize * 3
    config = PagingConfig(
    pageSize = limit,
    prefetchDistance = limit / 2 // aquí recolectamos a la mitad, asi va más "fluido"
    ),
    pagingSourceFactory = {
        pager
    }
    ).flow
}