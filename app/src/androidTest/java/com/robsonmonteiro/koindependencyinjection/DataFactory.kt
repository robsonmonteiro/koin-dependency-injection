package com.robsonmonteiro.koindependencyinjection

import java.util.*
import java.util.concurrent.ThreadLocalRandom

object DataFactory {

    fun randomUuid(): String = UUID.randomUUID().toString()

    fun randomInt(): Int = ThreadLocalRandom.current().nextInt(0, 1000 + 1)

}