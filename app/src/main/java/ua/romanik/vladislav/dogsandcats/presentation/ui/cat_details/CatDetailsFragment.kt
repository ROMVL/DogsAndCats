package ua.romanik.vladislav.dogsandcats.presentation.ui.cat_details

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import org.koin.android.viewmodel.ext.android.viewModel
import ua.romanik.vladislav.dogsandcats.R
import ua.romanik.vladislav.dogsandcats.databinding.FragmentCatDetailsBinding
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel
import ua.romanik.vladislav.dogsandcats.presentation.base.fragment.BaseFragment
import ua.romanik.vladislav.dogsandcats.presentation.ui.main.MainActivity

class CatDetailsFragment : BaseFragment() {

    companion object {

        private const val ANIMAL_ARG = "animal_arg"

        fun newInstance(animalModel: AnimalModel) = CatDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ANIMAL_ARG, animalModel)
            }
        }
    }

    override val viewModel: CatDetailsViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_cat_details

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context as MainActivity).showTabs(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getParcelable<AnimalModel>(ANIMAL_ARG)?.let { animalModel ->
                viewModel.initAnimalParam(animalModel)
            }
        }
    }

    override fun onDetach() {
        (requireActivity() as MainActivity).showTabs()
        super.onDetach()
    }

    override fun initUI() {
        super.initUI()
        with(binding as FragmentCatDetailsBinding) {
            viewModel = this@CatDetailsFragment.viewModel
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        requireActivity().supportFragmentManager.beginTransaction().detach(this).commit()
        super.onConfigurationChanged(newConfig)
        requireActivity().supportFragmentManager.beginTransaction().attach(this).commit()
    }

    override fun hideUIAndShowError() {}

}
