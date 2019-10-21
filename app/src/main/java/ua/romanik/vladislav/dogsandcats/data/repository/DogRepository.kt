package ua.romanik.vladislav.dogsandcats.data.repository

import ua.romanik.vladislav.dogsandcats.data.cloud.Api
import ua.romanik.vladislav.dogsandcats.data.model.DataResponse
import ua.romanik.vladislav.dogsandcats.domain.repository.IDogRepository

class DogRepository(
    private val api: Api
) : IDogRepository {

    companion object {
        private const val DOG = "dog"
    }

    override suspend fun fetchDogs(): DataResponse = api.fetchData(DOG)

}