package com.example.demo.entity;
import org.springframework.data.annotation.*;
import org.bson.types.ObjectId;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Indexed;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.Collections;

@NoArgsConstructor
@Document(collection="tasks")
@Data
public class Task {

    @Id
    @NonNull
    private ObjectId id;

    @Indexed(unique = true)
    private String title;

    private String description;
    private boolean completed;
    private LocalDateTime date;

}
