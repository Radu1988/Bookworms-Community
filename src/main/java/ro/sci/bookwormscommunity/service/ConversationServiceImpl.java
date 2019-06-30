package ro.sci.bookwormscommunity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.bookwormscommunity.model.Conversation;
import ro.sci.bookwormscommunity.model.User;
import ro.sci.bookwormscommunity.repositories.ConversationRepository;

import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private UserService userService;

    @Override
    public Conversation startConversation(long toUserId, long fromUserId) {
        Conversation conversation = conversationRepository.getConversation(toUserId, fromUserId);

        if (conversation == null) {
            User toUser = userService.findById(toUserId);
            User fromUser = userService.findById(fromUserId);
            conversation = new Conversation(toUser, fromUser);
            conversationRepository.save(conversation);
        }

        return conversation;
    }

    @Override
    public List<Conversation> getUserConversations(long id) {
        return conversationRepository.getConversations(id);
    }

    @Override
    public Conversation findById(long id) {
        return conversationRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id){
        conversationRepository.deleteById(id);
    }
}