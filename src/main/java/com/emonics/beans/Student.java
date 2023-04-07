package com.emonics.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Student {
 private Integer Id;
 
 @NotBlank(message = "Student's name cannot be empty")
 private String name;
 @Min(value = 0, message = "Age cannot be less than 0")
 private Integer age;
public Integer getId() {
	return Id;
}
public void setId(Integer id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
}
