package ua.romanik.vladislav.dogsandcats.data.cloud

import retrofit2.http.GET
import retrofit2.http.Query
import ua.romanik.vladislav.dogsandcats.data.model.DataResponse

interface Api {

    @GET("/xim/api.php")
    suspend fun fetchData(@Query("query") param: String): DataResponse

}