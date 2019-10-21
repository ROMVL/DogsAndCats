package ua.romanik.vladislav.dogsandcats.presentation.ui.cat_details

import android.os.Bundle
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ua.romanik.vladislav.dogsandcats.R
import ua.romanik.vladislav.dogsandcats.databinding.FragmentCatDetailsBinding
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel
import ua.romanik.vladislav.dogsandcats.presentation.base.fragment.BaseFragment

class CatDetailsFragment : BaseFragment() {

    companion object {

        private const val ANIMAL_ARG = "animal_arg"

        fun newInstance(animalModel: AnimalModel) = CatDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ANIMAL_ARG, animalModel)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getParcelable<AnimalModel>(ANIMAL_ARG)?.let { animalModel ->
                viewModel.initAnimalParam(animalModel)
            }
        }
    }

    override val viewModel: CatDetailsViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_cat_details

    override fun initUI() {
        super.initUI()
        with(binding as FragmentCatDetailsBinding) {
            viewModel = this@CatDetailsFragment.viewModel
        }
    }

    override fun hideUIAndShowError() {
    }

}
