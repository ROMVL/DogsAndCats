package ua.romanik.vladislav.dogsandcats.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ua.romanik.vladislav.dogsandcats.data.mapper.CloudErrorMapper
import ua.romanik.vladislav.dogsandcats.data.mapper.DataModelToDomainModelMapper
import ua.romanik.vladislav.dogsandcats.data.model.ItemResponse
import ua.romanik.vladislav.dogsandcats.data.repository.CatRepository
import ua.romanik.vladislav.dogsandcats.data.repository.DogRepository
import ua.romanik.vladislav.dogsandcats.domain.mapper.DataMapper
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel
import ua.romanik.vladislav.dogsandcats.domain.repository.ICatRepository
import ua.romanik.vladislav.dogsandcats.domain.repository.IDogRepository
import ua.romanik.vladislav.dogsandcats.domain.usecase.FetchCatsUseCase
import ua.romanik.vladislav.dogsandcats.domain.usecase.FetchDogsUseCase
import ua.romanik.vladislav.dogsandcats.presentation.ui.cat_details.CatDetailsViewModel
import ua.romanik.vladislav.dogsandcats.presentation.ui.cats_list.CatsViewModel
import ua.romanik.vladislav.dogsandcats.presentation.ui.dog_details.DogDetailsViewModel
import ua.romanik.vladislav.dogsandcats.presentation.ui.dogs_list.DogsViewModel

val viewModelModule = module {
    viewModel { CatsViewModel(get()) }
    viewModel { DogsViewModel(get()) }
    viewModel { CatDetailsViewModel() }
    viewModel { DogDetailsViewModel() }
}

val mapperModule = module {
    single { CloudErrorMapper() }
    single { DataModelToDomainModelMapper() as DataMapper<ItemResponse, AnimalModel> }
}

val repositoryModule = module {
    single { CatRepository(get()) as ICatRepository }
    single { DogRepository(get()) as IDogRepository }
}

val useCaseModule = module {
    single { FetchCatsUseCase(get(), get(), get()) }
    single { FetchDogsUseCase(get(), get(), get()) }
}

val appModules = listOf(networkModule, mapperModule, repositoryModule, useCaseModule, viewModelModule)