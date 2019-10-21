package ua.romanik.vladislav.dogsandcats.presentation.ui.base_animals_list

import ua.romanik.vladislav.dogsandcats.presentation.base.fragment.BaseFragment


abstract class BaseAnimalsFragment : BaseFragment(), AnimalsAdapter.OnClickAnimalListener {
    protected val adapter by lazy { AnimalsAdapter(this) }

    override fun initUI() {
        super.initUI()
        retainInstance = true
    }
}