package com.example.demo.Repository;

import com.example.demo.entity.person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface personRepo extends MongoRepository<person, ObjectId> {

    person findByUserName(String userName);

}
