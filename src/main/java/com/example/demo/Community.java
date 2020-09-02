package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Community {
@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column
private long id;

@Column(length = 20, nullable = false)
private String name;

@Column(length = 50, nullable = true)
private String time;

@Column(nullable = false)
private String comment;


public long getId() { return id; }
public void setId(long id) { this.id = id; }

public String getName() { return name; }
public void setName(String name) { this.name = name; }

public String getTime() {return time;}
public void setTime(String time) { this.time = time; }

public String getComment() { return comment; }
public void setComment(String comment) { this.comment = comment; }
}