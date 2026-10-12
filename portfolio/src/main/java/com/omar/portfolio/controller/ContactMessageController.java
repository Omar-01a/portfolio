package com.omar.portfolio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omar.portfolio.entity.ContactMessage;
import com.omar.portfolio.service.ContactMessageService;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactMessageController {

    private final ContactMessageService messageService;

    public ContactMessageController(
            ContactMessageService messageService) {

        this.messageService = messageService;
    }

    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactMessage> getMessageById(
            @PathVariable Long id) {

        return messageService.getMessageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContactMessage createMessage(
            @RequestBody ContactMessage message) {

        return messageService.createMessage(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(
            @PathVariable Long id) {

        messageService.deleteMessage(id);

        return ResponseEntity.noContent().build();
    }
}