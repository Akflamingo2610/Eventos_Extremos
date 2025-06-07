package com.example.alunos_rm98048_rm550909

import Event
import EventAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alunos_rm98048_rm550909.R

class MainActivity : AppCompatActivity() {

    private lateinit var eventList: MutableList<Event>
    private lateinit var eventAdapter: EventAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewEvents)
        eventList = mutableListOf()
        eventAdapter = EventAdapter(eventList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = eventAdapter

        val buttonAddEvent = findViewById<Button>(R.id.buttonAddEvent)
        buttonAddEvent.setOnClickListener {
            addEvent()
        }
    }
    private fun addEvent() {
        val location = findViewById<EditText>(R.id.editTextLocation).text.toString()
        val eventType = findViewById<EditText>(R.id.editTextEventType).text.toString()
        val impactLevel = findViewById<EditText>(R.id.editTextImpactLevel).text.toString()
        val eventDate = findViewById<EditText>(R.id.editTextEventDate).text.toString()
        val affectedPeople = findViewById<EditText>(R.id.editTextAffectedPeople).text.toString()
        if (location.isEmpty() || eventType.isEmpty() || impactLevel.isEmpty() || eventDate.isEmpty() || affectedPeople.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            return
        }
        if (affectedPeople.toIntOrNull() == null || affectedPeople.toInt() <= 0) {
            Toast.makeText(this, "Número de pessoas afetadas deve ser maior que zero.", Toast.LENGTH_SHORT).show()
            return
        }
        val newEvent = Event(location, eventType, impactLevel, eventDate, affectedPeople.toInt())
        eventList.add(newEvent)
        eventAdapter.notifyItemInserted(eventList.size - 1)  // Notifica o adapter sobre o novo item

        clearFields()
    }
    private fun clearFields() {
        findViewById<EditText>(R.id.editTextLocation).text.clear()
        findViewById<EditText>(R.id.editTextEventType).text.clear()
        findViewById<EditText>(R.id.editTextImpactLevel).text.clear()
        findViewById<EditText>(R.id.editTextEventDate).text.clear()
        findViewById<EditText>(R.id.editTextAffectedPeople).text.clear()
    }
}
