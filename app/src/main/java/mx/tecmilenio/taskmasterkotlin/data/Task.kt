package mx.tecmilenio.taskmasterkotlin.data

data class Task(
    val id: Int,
    val title: String,
    val description: String? = null, // Null safety
    var isCompleted: Boolean = false
)
