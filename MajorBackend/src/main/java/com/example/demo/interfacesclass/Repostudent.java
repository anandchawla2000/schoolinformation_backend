package com.example.demo.interfacesclass;

import java.util.ArrayList;
import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;

@Repository
public interface Repostudent extends JpaRepository<Student, Integer> { // for login Student
	@Query("from Student where email= :email And password= :password")
	ArrayList<Student> find(@Param("email") String email, @Param("password") String pasword);

	// for teacher main page(Sent student to update)
	List<Student> findByclassall(String id);

	@Query(value = "select * from Student where classall=:id And (statusacad=:statusacad Or statuspers= :statuspers)", nativeQuery = true)
	List<Student> findcheck(@Param("id") String id, @Param("statusacad") int i, @Param("statuspers") int j);

	List<Student> findByemail(String email);
	
	@Modifying
	 @Transactional
	@Query(value="Update Student SET statusacad=1 WHERE admissionid=:id", nativeQuery = true)
	void updateacinfo(@Param("id") int id);
	
	@Modifying
	 @Transactional
	@Query(value="Update Student set statuspers=1 WHERE admissionid=:id ", nativeQuery = true)
	void updatepsinfo(@Param("id") int id);
}
