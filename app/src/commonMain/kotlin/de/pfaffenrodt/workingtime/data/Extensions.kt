package de.pfaffenrodt.workingtime.data

import com.ionspin.kotlin.bignum.decimal.BigDecimal


fun String?.bd(): BigDecimal {
    if (this == null) {
        return BigDecimal.ZERO
    }

    return BigDecimal.parseString(this.replace(',', '.'))
}

fun String?.toString(): String {
    if (this == null) {
        return ""
    }
    return this
}