package ua.romanik.vladislav.dogsandcats.domain.repository

import ua.romanik.vladislav.dogsandcats.data.model.DataResponse

interface IDogRepository {

    suspend fun fetchDogs(): DataResponse

}