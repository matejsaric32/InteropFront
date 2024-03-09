object AppState {
    var selectedHardware: Hardware? by mutableStateOf(null)
    var currentScreen: Screen by mutableStateOf(Screen.HARDWARE)
    var hardwares by remember { mutableStateOf(emptyList<Hardware>()) }
}
