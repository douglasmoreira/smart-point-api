package com.example.demo.service;

import com.example.demo.entity.Launch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface LaunchService {

    /**
     * Returns a paged list of entries for a given employee.
     *
     * @param employeeId
     * @param pageRequest
     * @return Page<Lancamento>
     */
    Page<Launch> findByEmployeeId(Long employeeId, PageRequest pageRequest);

    /**
     * Return launch by ID.
     *
     * @param id
     * @return List<Launch>
     */
    List<Launch> findById(Long id);

    /**
     * A launch in the database persists
     *
     * @param launch
     * @return Launch
     */
    Launch persist(Launch launch);

    /**
     * Removes a release from the database
     *
     * @param id
     */
    void remove(Long id);
}
