package com.example.demo.service;

import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message sms) {

        return messageRepository.save(sms);
    }

    public List<Message> saveMessages(List<Message> smss) {

        return messageRepository.saveAll(smss);
    }

    public List<Message> getMessages() {

        return messageRepository.findAll();
    }

    public Message getMessageById(int id) {

        return messageRepository.findById(id).orElse(null);
    }


    public String deleteMessage(int id) {
        messageRepository.deleteById(id);
        return " removed !! " + id;
    }

    public Message updateMessage(Message sms) {
        Message existingMessage= messageRepository.findById(sms.getIdMsg()).orElse(null);
        existingMessage.setContenue(sms.getContenue());
        existingMessage.setDateEnvoi(sms.getDateEnvoi());
        existingMessage.setAdministrateurs(sms.getAdministrateurs());
        existingMessage.setEnseignants(sms.getEnseignants());
        existingMessage.setEtudiantes(sms.getEtudiantes());
        return messageRepository.save(existingMessage);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

}
