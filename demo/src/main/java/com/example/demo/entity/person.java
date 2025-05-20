package com.example.demo.entity;


import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


@Document(collection = "person")
@Data
public class person {

    @Id
    private ObjectId id;


    @Indexed(unique = true)
    @NonNull
    private String userName;

    @NonNull
    private String password;
    private String name;



    @DBRef
    private List<Task> getTasks = new LinkedList<>();

}
