package com.iafedoseye.promptcraft

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform