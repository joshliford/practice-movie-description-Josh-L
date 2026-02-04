package com.example.practice_movie_description_Josh_L.services;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GeminiService {

    private final String geminiApiKey;

    public GeminiService(@Value("${gemini.api.key}") String geminiApiKey) {
        this.geminiApiKey = geminiApiKey;
    }

    public String generateMovieDescription(String title) throws HttpException, IOException {
        Client client = Client.builder().apiKey(geminiApiKey).build();
        GenerateContentResponse response = client.models.generateContent(
                "gemini-2.0-flash-001",
                "Generate a detailed description of the movie with the provided title: " + title + ". Ensure the description is no more than 255 characters.",
                null
        );
        return response.text();
    }

}
