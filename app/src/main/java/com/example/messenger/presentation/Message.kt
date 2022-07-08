package com.example.messenger.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger.R

class Message : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewout = inflater.inflate(R.layout.settings_items, container, false)
        val inputMessage = viewout.findViewById<EditText>(R.id.editTextTextPersonName2)
        val send = viewout.findViewById<Button>(R.id.buttonSend)
        val recyclerView = viewout.findViewById<RecyclerView>(R.id.listChat)
        val controller = MessageController()

        controller.setIncomingLayout(R.layout.message).setOutgoingLayout(R.layout.message)
            .setMessageTextId(R.id.messageBody).setUserNameId(R.id.nickName)
            .setMessageTimeId(R.id.messagetimer)
            .appendTo(recyclerView, viewout.context)
        controller.addMessage(MessageController.Message("Hello", "Ромка", true))
        controller.addMessage(MessageController.Message("Hello too", "Не Ромка", false))


        return viewout
    }


}