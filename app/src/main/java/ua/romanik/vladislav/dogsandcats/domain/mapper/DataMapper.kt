package ua.romanik.vladislav.dogsandcats.domain.mapper


interface DataMapper<T, R> {
    fun convert(item: T, index: Int): R
}