package ua.romanik.vladislav.dogsandcats.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnimalModel(
    val id: Int,
    val url: String,
    val title: String
) : DomainBaseModel(), Parcelable