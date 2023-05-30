package com.example.demo.controler;

import com.example.demo.entity.MessageEntity;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MessageController {
    @Autowired
    private MessageService service;

    @PostMapping("/addMessage")
    public MessageEntity addMessage(@RequestBody MessageEntity sms) {

        return service.saveMessage(sms);
    }

    @PostMapping("/addMessages")
    public List<MessageEntity> addMessages(@RequestBody List<MessageEntity> smss) {
        return service.saveMessages(smss);
    }

    @GetMapping("/Messages")
    public List<MessageEntity> findAllMessages() {
        return service.getMessages();
    }

    @GetMapping("/MessageById/{id}")
    public MessageEntity findMessageById(@PathVariable int id) {

        return service.getMessageById(id);
    }

    @GetMapping("/Message/{name}")
    public MessageEntity findMessageByName(@PathVariable String name) {
        return service.getMessageByName(name);
    }

    @PutMapping("/update")
    public MessageEntity updateMessage(@RequestBody MessageEntity sms) {
        return service.updateMessage(sms);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMessage(@PathVariable int id) {

        return service.deleteMessage(id);
    }
}
