package model

import lombok.Data

@Data
data class Review(
    val UID: String?,
    var title: String,
    val text: String,
    val rating: Int,
    var hardware: Hardware
)
