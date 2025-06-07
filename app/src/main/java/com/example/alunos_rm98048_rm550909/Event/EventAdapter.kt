import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alunos_rm98048_rm550909.R

class EventAdapter(private val events: MutableList<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return EventViewHolder(view)
    }
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event)
    }
    override fun getItemCount(): Int = events.size

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val locationTextView: TextView = itemView.findViewById(R.id.textViewLocation)
        private val eventTypeTextView: TextView = itemView.findViewById(R.id.textViewEventTypeUnique)
        private val impactLevelTextView: TextView = itemView.findViewById(R.id.textViewImpactLevel)
        private val eventDateTextView: TextView = itemView.findViewById(R.id.textViewEventDate)
        private val affectedPeopleTextView: TextView = itemView.findViewById(R.id.textViewAffectedPeople)
        private val deleteButton: Button = itemView.findViewById(R.id.buttonDeleteEvent)

        fun bind(event: Event) {
            locationTextView.text = event.location
            eventTypeTextView.text = event.eventType
            impactLevelTextView.text = event.impactLevel
            eventDateTextView.text = event.eventDate
            affectedPeopleTextView.text = event.affectedPeople.toString()

            deleteButton.setOnClickListener {
                events.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }
}
