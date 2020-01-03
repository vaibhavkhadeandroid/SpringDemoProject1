package com.example.demo.jpademohtwoconect;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.example1.Userpojo;

@Repository
public interface UserRepository extends JpaRepository<Userpojo, Integer> {

}
