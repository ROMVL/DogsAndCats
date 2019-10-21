package ua.romanik.vladislav.dogsandcats.data.mapper

import ua.romanik.vladislav.dogsandcats.data.model.ItemResponse
import ua.romanik.vladislav.dogsandcats.domain.mapper.DataMapper
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel

class DataModelToDomainModelMapper : DataMapper<ItemResponse, AnimalModel> {

    override fun convert(item: ItemResponse, index: Int): AnimalModel =
        AnimalModel(index, item.url.replace("http://","https://"), item.title)

}