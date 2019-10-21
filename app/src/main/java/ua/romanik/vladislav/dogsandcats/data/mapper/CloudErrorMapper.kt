package ua.romanik.vladislav.dogsandcats.data.mapper

import ua.romanik.vladislav.dogsandcats.domain.model.response.ErrorModel
import ua.romanik.vladislav.dogsandcats.domain.model.response.ErrorStatus
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class CloudErrorMapper {

    fun mapToDomainErrorException(throwable: Throwable?): ErrorModel {
        return when (throwable) {
            is SocketTimeoutException -> {
                ErrorModel("TIME OUT", 0, ErrorStatus.TIMEOUT)
            }

            is IOException -> {
                ErrorModel("CHECK CONNECTION", 0, ErrorStatus.NO_CONNECTION)
            }

            is UnknownHostException -> {
                ErrorModel("CHECK CONNECTION", 0, ErrorStatus.NO_CONNECTION)
            }
            else -> ErrorModel(throwable?.message ?: "", 0, ErrorStatus.NO_CONNECTION)
        }
    }
}