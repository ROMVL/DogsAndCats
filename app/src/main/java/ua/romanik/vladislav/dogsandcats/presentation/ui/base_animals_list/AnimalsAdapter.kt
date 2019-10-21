package ua.romanik.vladislav.dogsandcats.presentation.ui.base_animals_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ua.romanik.vladislav.dogsandcats.databinding.ItemAnimalBinding
import ua.romanik.vladislav.dogsandcats.domain.model.AnimalModel
import ua.romanik.vladislav.dogsandcats.presentation.base.recycler.DataBindingViewHolder

class AnimalsAdapter(
    private val listener: OnClickAnimalListener
) : ListAdapter<AnimalModel, AnimalsAdapter.AnimalViewHolder>(AnimalsItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimalBinding.inflate(layoutInflater, parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }

    inner class AnimalViewHolder(
        private val binding: ItemAnimalBinding
    ) : DataBindingViewHolder<AnimalModel>(binding) {
        override fun onBind(t: AnimalModel) {
            binding.animal = t
            binding.root.setOnClickListener { listener.onClick(t) }
        }
    }

    interface OnClickAnimalListener {
        fun onClick(animalModel: AnimalModel)
    }

}