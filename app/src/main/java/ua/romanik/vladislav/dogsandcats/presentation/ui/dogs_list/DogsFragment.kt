package ua.romanik.vladislav.dogsandcats.presentation.ui.dogs_list

import android.util.Log
import android.view.View
import org.koin.android.viewmodel.ext.android.viewModel
import ua.romanik.vladislav.dogsandcats.R
import ua.romanik.vladislav.dogsandcats.databinding.FragmentCatsBinding
import ua.romanik.vladislav.dogsandcats.databinding.FragmentDogsBinding
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel
import ua.romanik.vladislav.dogsandcats.presentation.ui.base_animals_list.BaseAnimalsFragment
import ua.romanik.vladislav.dogsandcats.presentation.ui.dog_details.DogDetailsFragment
import ua.romanik.vladislav.dogsandcats.presentation.ui.main.MainActivity

class DogsFragment : BaseAnimalsFragment() {

    private val TAG = DogsFragment::class.java.name

    companion object {
        fun newInstance() = DogsFragment()
    }

    override val layoutId: Int = R.layout.fragment_dogs
    override val viewModel: DogsViewModel by viewModel()

    override fun initUI() {
        super.initUI()
        with((binding as FragmentDogsBinding)) {
            rvDogs.adapter = adapter
            rvDogs.layoutManager =
                androidx.recyclerview.widget.LinearLayoutManager(requireContext())
            viewModel = this@DogsFragment.viewModel
        }
    }

    override fun hideUIAndShowError() {
        with((binding as FragmentDogsBinding)) {
            viewError.root.visibility = View.VISIBLE
            rvDogs.visibility = View.GONE
            progressBar.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }

    override fun onClick(animalModel: AnimalModel) {
        (requireActivity() as MainActivity).changeScreenToDetails(DogDetailsFragment.newInstance(animalModel))
    }


}
