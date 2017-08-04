package com.example.service;

public interface ITeacherService {

	public String queryClassByTeacherId(String teacherid, String state, String url);
	public String login(String username, String password, String url);
}
