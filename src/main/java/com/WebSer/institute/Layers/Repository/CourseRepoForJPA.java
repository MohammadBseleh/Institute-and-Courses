package com.WebSer.institute.Layers.Repository;

import com.WebSer.institute.Layers.domains.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepoForJPA extends JpaRepository<Course,Long> {
}
