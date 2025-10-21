package mx.tecmilenio.taskmasterkotlin.data

object TaskManager {
    private val tasks = mutableListOf<Task>()
    // Función con parámetro variable y lambda
    fun addTasks(vararg newTasks: Task, onSuccess: () -> Unit) {
        tasks.addAll(newTasks.toList())
        onSuccess()
    }
    // Función de orden superior con filter
    fun filterTasks(predicate: (Task) -> Boolean): List<Task> {
        return tasks.filter(predicate)
    }
    // Manejo de posible null con operador ?.
    fun findTaskById(id: Int): Task? = tasks.find { it.id == id }
    // Actualizar estado de tarea
    fun completeTask(id: Int) {
        findTaskById(id)?.apply {
            isCompleted = true
        }
    }
}