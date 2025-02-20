package org.example.aiservice;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // Autorise toutes les requêtes (à sécuriser en prod)
@RestController
@RequestMapping("/ai")
public class Controller {



    VectorStore vectorStore;

    public Controller(ChatClient.Builder  builder, VectorStore vectorStore) {
        this.vectorStore=vectorStore;
        this.chatClient = builder
                .defaultAdvisors(new QuestionAnswerAdvisor((vectorStore)))
                .build();

    }

    ChatClient chatClient;


    @GetMapping(value = "/{question}", produces = MediaType.TEXT_MARKDOWN_VALUE)
    public String chat(@PathVariable String question){
       return chatClient.prompt()
               .user(question)
               .call()
               .content();


    }
}
