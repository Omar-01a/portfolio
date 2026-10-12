package com.omar.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.omar.portfolio.entity.ContactMessage;
import com.omar.portfolio.repository.ContactMessageRepository;

@Service
public class ContactMessageService {

    private final ContactMessageRepository messageRepository;

    public ContactMessageService(
            ContactMessageRepository messageRepository) {

        this.messageRepository = messageRepository;
    }

    public List<ContactMessage> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<ContactMessage> getMessageById(Long id) {
        return messageRepository.findById(id);
    }

    public ContactMessage createMessage(ContactMessage message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}