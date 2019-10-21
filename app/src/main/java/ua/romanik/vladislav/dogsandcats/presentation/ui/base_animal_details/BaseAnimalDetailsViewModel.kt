package ua.romanik.vladislav.dogsandcats.presentation.ui.base_animal_details

import androidx.lifecycle.MutableLiveData
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel
import ua.romanik.vladislav.dogsandcats.presentation.base.viewmodel.BaseViewModel

abstract class BaseAnimalDetailsViewModel : BaseViewModel() {

    val animal: MutableLiveData<AnimalModel> by lazy { MutableLiveData<AnimalModel>() }

    fun initAnimalParam(animalModel: AnimalModel) {
        animal.value = animalModel
    }

}