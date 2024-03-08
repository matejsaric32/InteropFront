package model

import kotlinx.serialization.Serializable
import lombok.Data
import java.math.BigDecimal

@Data
@Serializable
data class Hardware(
    val name: String,
    val type: Type,
    val code: String,
    val stock: Int,
    val price: BigDecimal
)
