package com.example.messenger.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger.R

class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewout = inflater.inflate(R.layout.chatfragment, container, false)
        val inputMessage = viewout.findViewById<EditText>(R.id.editTextTextPersonName2)
        val send = viewout.findViewById<Button>(R.id.buttonSend)
        val recyclerView = viewout.findViewById<RecyclerView>(R.id.listChat)
        val controller = MessageController()

        controller.setIncomingLayout(R.layout.message_input).setOutgoingLayout(R.layout.message_output)
            .setMessageTextId(R.id.messageBody).setUserNameId(R.id.nickName)
            .setMessageTimeId(R.id.messagetimer)
            .appendTo(recyclerView, context)
        controller.addMessage(MessageController.Message("Hello, it`s our messenger app", "Ромка", true))
        controller.addMessage(MessageController.Message("I`m glad to see your work, guys\nIt`s so wonderful!!!", "Не Ромка", false))
        inputMessage.setText("")
        send.setOnClickListener {
            if (inputMessage.text.toString() != "" && inputMessage.text!=null){
                Log.d("MESSAGE", inputMessage.text.toString())
                controller.addMessage(MessageController.Message(inputMessage.text.toString(), "Ромка", true))
                inputMessage.setText("")
            }
        }


        return viewout
    }


}