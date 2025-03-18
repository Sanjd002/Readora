package org.sanjidafarjana.readora

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform