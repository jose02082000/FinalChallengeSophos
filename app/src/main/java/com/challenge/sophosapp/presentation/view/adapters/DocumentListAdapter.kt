package com.challenge.sophosapp.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.challenge.sophosapp.databinding.ItemDocumentListBinding
import com.challenge.sophosapp.domain.managers.DocumentResourceManager
import com.challenge.sophosapp.domain.models.DocumentGeneralInfoDto
import java.text.SimpleDateFormat
import java.util.*

class DocumentListAdapter(
    private var model: List<DocumentGeneralInfoDto>,
    private val onItemClickListener: OnItemClickListener,
    private val resources: DocumentResourceManager
) :
    RecyclerView.Adapter<DocumentListAdapter.ViewHolder>() {

    private fun formatDateTime(dateTime: String): String {
        val patternSource = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        val patternResult = "yyyy/MM/dd"
        val sdf = SimpleDateFormat(patternSource, Locale.ENGLISH)
        val result = sdf.parse(dateTime)
        val outputFormat = SimpleDateFormat(patternResult, Locale.ENGLISH)

        outputFormat.timeZone = TimeZone.getTimeZone("America/Bogota")
        val formatted = result?.let { outputFormat.format(it) }
        return formatted.toString()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder =
        ViewHolder(
            ItemDocumentListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DocumentListAdapter.ViewHolder, position: Int) = holder.bind(model[position])

    override fun getItemCount(): Int = model.size

    inner class ViewHolder(view: ItemDocumentListBinding) : RecyclerView.ViewHolder(view.root) {
        private val dateType: TextView = view.dateAndTypeTextView
        private val name: TextView = view.userNameTextView
        private val container: ConstraintLayout = view.documentsContainerConstraintLayout

        fun bind(model: DocumentGeneralInfoDto) {
            dateType.text = resources.getDateAndDocType(formatDateTime(model.date), model.attachmentType)
            name.text = resources.getUserName(model.name, model.lastName)
            container.setOnClickListener {
                onItemClickListener.onItemClick(model)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(model: DocumentGeneralInfoDto)
    }
}
