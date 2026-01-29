package com.rasyidin.saltsubmissionapp.domain.model

import com.rasyidin.saltsubmissionapp.utils.Constants

data class SortByProduct(
    val id: Int = 0,
    val name: String = ""
) {
    val default = SortByProduct(
        id = Constants.SORT_BY_DEFAULT,
        name = "Default"
    )
}
