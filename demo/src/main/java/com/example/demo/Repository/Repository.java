package com.example.demo.Repository;
import com.example.demo.entity.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface Repository extends MongoRepository<Task, ObjectId> {
    Task findByTitle(String title);

}
