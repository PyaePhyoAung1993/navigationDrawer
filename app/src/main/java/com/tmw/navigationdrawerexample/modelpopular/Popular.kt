package com.tmw.navigationdrawerexample.modelpopular

data class Popular(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)