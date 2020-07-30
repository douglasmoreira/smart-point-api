package com.example.demo.repository;

import com.example.demo.entity.Launch;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;


@Transactional(readOnly = true)
@NamedQueries({@NamedQuery(name = "LaunchRepository.findByEmployeeId", query = "SELECT launch FROM launch WHERE launch.employee.id = :employeeId")})
public interface LaunchRepository extends JpaRepository<Launch, Long> {

    List<Launch> findByEmployeeId(@Param("employeeId") Long employeeId);

    List<Launch> findByEmployeeId(@Param("employeeId") Long employeeId, Pageable pageable);
}
