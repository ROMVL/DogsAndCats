package ua.romanik.vladislav.dogsandcats.presentation.ui.base_animals_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel
import ua.romanik.vladislav.dogsandcats.domain.usecase.base.UseCase
import ua.romanik.vladislav.dogsandcats.presentation.base.viewmodel.BaseViewModel

abstract class BaseAnimalsViewModel(
    useCase: UseCase<List<AnimalModel>>
) : BaseViewModel() {

    val animals by lazy { MutableLiveData<List<AnimalModel>>() }

    init {
        viewModelScope.launch {
            isLoading.value = true
            useCase.execute {
                onComplete {
                    animals.value = it
                    isLoading.value = false
                }
                onError {
                    error.value = it
                    isLoading.value = false
                }
            }
        }
    }

}