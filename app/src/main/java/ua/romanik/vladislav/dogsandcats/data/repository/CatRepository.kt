package ua.romanik.vladislav.dogsandcats.data.repository

import ua.romanik.vladislav.dogsandcats.data.cloud.Api
import ua.romanik.vladislav.dogsandcats.data.model.DataResponse
import ua.romanik.vladislav.dogsandcats.domain.repository.ICatRepository

class CatRepository(
    private val api: Api
) : ICatRepository {

    companion object {
        private const val CAT = "cat"
    }

    override suspend fun fetchCats(): DataResponse = api.fetchData(CAT)

}