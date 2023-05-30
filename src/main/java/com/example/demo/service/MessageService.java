package com.example.demo.service;

import com.example.demo.entity.MessageEntity;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public MessageEntity saveMessage(MessageEntity sms) {

        return repository.save(sms);
    }

    public List<MessageEntity> saveMessages(List<MessageEntity> smss) {

        return repository.saveAll(smss);
    }

    public List<MessageEntity> getMessages() {
        return repository.findAll();
    }

    public MessageEntity getMessageById(int id) {

        return repository.findById(id).orElse(null);
    }

    public MessageEntity getMessageByName(String name) {

        return repository.findByName(name);
    }

    public String deleteMessage(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public MessageEntity updateMessage(MessageEntity sms) {
        MessageEntity existingMessage= repository.findById(sms.getIdMsg()).orElse(null);
        existingMessage.setContenue(sms.getContenue());
        existingMessage.setDateEnvoi(sms.getDateEnvoi());

        return repository.save(existingMessage);
    }
}
