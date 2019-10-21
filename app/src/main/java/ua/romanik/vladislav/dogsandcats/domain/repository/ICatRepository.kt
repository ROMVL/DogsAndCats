package ua.romanik.vladislav.dogsandcats.domain.repository

import ua.romanik.vladislav.dogsandcats.data.model.DataResponse

interface ICatRepository {

    suspend fun fetchCats(): DataResponse

}