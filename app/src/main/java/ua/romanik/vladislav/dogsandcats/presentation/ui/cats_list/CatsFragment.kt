package ua.romanik.vladislav.dogsandcats.presentation.ui.cats_list

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel
import ua.romanik.vladislav.dogsandcats.R
import ua.romanik.vladislav.dogsandcats.databinding.FragmentCatsBinding
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel
import ua.romanik.vladislav.dogsandcats.presentation.ui.base_animals_list.BaseAnimalsFragment
import ua.romanik.vladislav.dogsandcats.presentation.ui.cat_details.CatDetailsFragment
import ua.romanik.vladislav.dogsandcats.presentation.ui.main.MainActivity

class CatsFragment : BaseAnimalsFragment() {

    private val TAG = CatsFragment::class.java.name

    companion object {
        fun newInstance() = CatsFragment()
    }

    override val viewModel: CatsViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_cats

    override fun initUI() {
        super.initUI()
        with((binding as FragmentCatsBinding)) {
            rvCats.adapter = adapter
            rvCats.layoutManager = LinearLayoutManager(requireContext())
            viewModel = this@CatsFragment.viewModel
        }
    }

    override fun hideUIAndShowError() {
        with((binding as FragmentCatsBinding)) {
            viewError.root.visibility = View.VISIBLE
            rvCats.visibility = View.GONE
            progressBar.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }

    override fun onClick(animalModel: AnimalModel) {
        (requireActivity() as MainActivity).changeScreenToDetails(CatDetailsFragment.newInstance(animalModel))
    }
}
