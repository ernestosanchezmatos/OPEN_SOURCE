package dao;

import java.util.List;

public interface ICrudRepository<T> {

	public boolean insert(T t);
	
	public boolean update(T t);
	
	public boolean delete(int id);
	
	public List<T> ListAll();
	
	public T FinbyId(int id);
	
	public List<T> findbyname(T t);
}
