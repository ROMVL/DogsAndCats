package ua.romanik.vladislav.dogsandcats.data.model

data class DataResponse(
    val message: String,
    val data: List<ItemResponse>
) : DataBaseModel()