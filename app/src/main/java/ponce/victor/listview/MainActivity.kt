package ponce.victor.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var taskList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listViewTasks)
        val editTextTask = findViewById<EditText>(R.id.editTextTask)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)

        taskList = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
        listView.adapter = adapter

        buttonAdd.setOnClickListener {
            val task = editTextTask.text.toString()
            if (task.isNotEmpty()){
                taskList.add(task)
                adapter.notifyDataSetChanged()
                editTextTask.text.clear()
            }

            else
            {
                Toast.makeText(this, "Introduzca una tarea", Toast.LENGTH_SHORT).show()
            }


        }
    }
}