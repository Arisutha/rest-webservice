package com.wsrestful.hello.dao;

public interface BaseRepository<T> {
	public void save(T data) throws Exception;
	public void update(T data) throws Exception;
	public void delete(T data) throws Exception;
}
