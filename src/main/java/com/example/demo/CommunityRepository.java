package com.example.demo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends
JpaRepository<Community, Long>{
public List<Community> findByIdIsNotNullOrderByIdDesc();	
}