package com.example.demo.service.impl;

import com.example.demo.entity.Launch;
import com.example.demo.repository.LaunchRepository;
import com.example.demo.service.LaunchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaunchServiceImp implements LaunchService {

    private static final Logger log = LoggerFactory.getLogger(LaunchServiceImp.class);

    @Autowired
    private LaunchRepository launchRepository;

    @Override
    public Page<Launch> findByEmployeeId(Long employeeId, PageRequest pageRequest) {
        log.info("Find launch by employee ID {}", employeeId);
        return launchRepository.findByEmployeeId(employeeId, pageRequest);
    }

    @Override
    public List<Launch> findById(Long id) {
        log.info("Find launch by ID {}", id);
        return launchRepository.findByEmployeeId(id);
    }

    @Override
    public Launch persist(Launch launch) {
        log.info("Persist launch: {}", launch);
        return launchRepository.save(launch);
    }

    @Override
    public void remove(Long id) {
        log.info("Remove launch ID {}", id);
        launchRepository.deleteById(id);

    }
}
