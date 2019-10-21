package ua.romanik.vladislav.dogsandcats.domain.usecase

import ua.romanik.vladislav.dogsandcats.data.mapper.CloudErrorMapper
import ua.romanik.vladislav.dogsandcats.data.model.ItemResponse
import ua.romanik.vladislav.dogsandcats.domain.mapper.DataMapper
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel
import ua.romanik.vladislav.dogsandcats.domain.repository.IDogRepository
import ua.romanik.vladislav.dogsandcats.domain.usecase.base.UseCase

class FetchDogsUseCase(
    private val dogRepository: IDogRepository,
    private val dataMapper: DataMapper<ItemResponse, AnimalModel>,
    errorMapper: CloudErrorMapper
) : UseCase<List<AnimalModel>>(errorMapper) {

    override suspend fun executeOnBackground(): List<AnimalModel>
            = dogRepository.fetchDogs().data.mapIndexed { index, itemResponse -> dataMapper.convert(itemResponse, index) }

}