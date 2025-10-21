package mx.tecmilenio.taskmasterkotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import mx.tecmilenio.taskmasterkotlin.data.Task
import mx.tecmilenio.taskmasterkotlin.data.TaskManager
class MainActivity : AppCompatActivity() {
    private lateinit var tvTasks: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTasks = findViewById(R.id.tvTasks)
        val btnAdd = findViewById<Button>(R.id.btnAddTasks)
        val btnComplete = findViewById<Button>(R.id.btnCompleteTask)
// 1. Agregar tareas de ejemplo
        btnAdd.setOnClickListener {
            TaskManager.addTasks(
                Task(1, "Estudiar Kotlin", "Completar actividad práctica"),
                Task(2, "Revisar null safety"), ) {
                showTasks()
                Toast.makeText(this, "¡Tareas agregadas!", Toast.LENGTH_SHORT).show()
            }
        }
// 2. Completar tarea con manejo de errores
        btnComplete.setOnClickListener {
            try {
                TaskManager.completeTask(1)
                showTasks()
            } catch (e: Exception) {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun showTasks() {
        val tasks = TaskManager.filterTasks { true } // Obtener todas
        tvTasks.text = tasks.joinToString("\n\n") {
            "${it.id}. ${it.title} - ${it.description} (${if(it.isCompleted) "✅" else "⏳"})"
        }
    }
}