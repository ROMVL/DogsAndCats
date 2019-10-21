package ua.romanik.vladislav.dogsandcats.presentation.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.romanik.vladislav.dogsandcats.domain.model.response.ErrorModel

abstract class BaseViewModel : ViewModel() {

    val isLoading by lazy { MutableLiveData<Boolean>() }
    val error by lazy { MutableLiveData<ErrorModel>() }

}