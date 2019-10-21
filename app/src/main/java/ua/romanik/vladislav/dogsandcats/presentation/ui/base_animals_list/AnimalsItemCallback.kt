package ua.romanik.vladislav.dogsandcats.presentation.ui.base_animals_list

import androidx.recyclerview.widget.DiffUtil
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel

class AnimalsItemCallback : DiffUtil.ItemCallback<AnimalModel>() {
    override fun areItemsTheSame(oldItem: AnimalModel, newItem: AnimalModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AnimalModel, newItem: AnimalModel): Boolean {
        return oldItem.title == newItem.title && oldItem.url == newItem.url
    }
}