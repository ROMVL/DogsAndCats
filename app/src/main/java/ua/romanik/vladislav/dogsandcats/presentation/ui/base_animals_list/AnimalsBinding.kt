package ua.romanik.vladislav.dogsandcats.presentation.ui.base_animals_list

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel

@BindingAdapter("app:animals")
fun RecyclerView.setAnimals(contributors: List<AnimalModel>?) {
    this.visibility = View.VISIBLE
    (this.adapter as? AnimalsAdapter)?.submitList(contributors ?: emptyList())
}