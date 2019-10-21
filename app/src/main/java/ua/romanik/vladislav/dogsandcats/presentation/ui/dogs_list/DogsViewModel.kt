package ua.romanik.vladislav.dogsandcats.presentation.ui.dogs_list

import ua.romanik.vladislav.dogsandcats.domain.usecase.FetchDogsUseCase
import ua.romanik.vladislav.dogsandcats.presentation.ui.base_animals_list.BaseAnimalsViewModel

class DogsViewModel(
    fetchDogsUseCase: FetchDogsUseCase
) : BaseAnimalsViewModel(fetchDogsUseCase)
