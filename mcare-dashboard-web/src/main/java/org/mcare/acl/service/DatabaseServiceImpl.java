package org.mcare.acl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.mcare.common.interfaces.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseServiceImpl implements DatabaseService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public DatabaseServiceImpl() {
		
	}
	
	@Transactional
	public void test() {
		System.err.println("" + databaseRepositoryImpl);
		databaseRepositoryImpl.test();
	}
	
	@Transactional
	@Override
	public <T> long save(T t) {
		return databaseRepositoryImpl.save(t);
	}
	
	@Transactional
	@Override
	public <T> int delete(T t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Transactional
	@Override
	public <T> T findById(long id, String fieldName, Class<?> className) {
		// TODO Auto-generated method stub
		return databaseRepositoryImpl.findById(id, fieldName, className);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public <T> List<T> findAll(T t, String tableClass) {
		return (List<T>) databaseRepositoryImpl.findAll(t, tableClass);
	}
	
	@Override
	public <T> T findByKey(String value, String fieldName, Class<?> className) {
		return databaseRepositoryImpl.findByKey(value, fieldName, className);
	}
	
}
