package com.tinellus.bottommenusample

sealed class Screens(val screenName: String) {
    data object Home: Screens("home")
    data object Profile: Screens("profile")
    data object Search: Screens("search")
    data object Notifications: Screens("notification")
}