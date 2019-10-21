package ua.romanik.vladislav.dogsandcats.presentation.ui.cats_list

import ua.romanik.vladislav.dogsandcats.domain.usecase.FetchCatsUseCase
import ua.romanik.vladislav.dogsandcats.presentation.ui.base_animals_list.BaseAnimalsViewModel

class CatsViewModel(
    fetchCatsUseCase: FetchCatsUseCase
) : BaseAnimalsViewModel(fetchCatsUseCase)
