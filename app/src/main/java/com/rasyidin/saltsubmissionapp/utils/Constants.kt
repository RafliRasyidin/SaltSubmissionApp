package com.rasyidin.saltsubmissionapp.utils

import com.rasyidin.saltsubmissionapp.domain.model.SortByProduct

object Constants {

    const val SORT_BY_DEFAULT = 0
    const val SORT_BY_HIGHEST_PRICE = 1
    const val SORT_BY_LOWEST_PRICE = 2
    const val SORT_BY_NAME = 3

    val sortOptions = listOf(
        SortByProduct(SORT_BY_HIGHEST_PRICE, "Highest Price"),
        SortByProduct(SORT_BY_LOWEST_PRICE, "Lowest Price"),
        SortByProduct(SORT_BY_NAME, "Name")
    )
}