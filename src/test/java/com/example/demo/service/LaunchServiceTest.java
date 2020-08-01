package com.example.demo.service;

import com.example.demo.entity.Launch;
import com.example.demo.repository.LaunchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class LaunchServiceTest {

    @MockBean
    private LaunchRepository launchRepository;

    @Autowired
    private LaunchService launchService;

    @BeforeEach
    public void setUp() {
        BDDMockito.given(this.launchRepository.findByEmployeeId(Mockito.anyLong(),Mockito.any(PageRequest.class))).willReturn(new PageImpl<Launch>(new ArrayList<Launch>()));

        BDDMockito.given(this.launchRepository.findById(Mockito.anyLong())).willReturn (java.util.Optional.of(new Launch()));

        BDDMockito.given(this.launchRepository.save(Mockito.any(Launch.class))).willReturn(new Launch());
    }

    @Test
    public void testFindByemployeeId() {
        Page<Launch> launches = this.launchService.findByEmployeeId(Long.valueOf(1), PageRequest.of(0, 10));

        assertNotNull(launches);
    }

    @Test
    public void testFindLaunchById() {
        List<Launch> launches = this.launchService.findById(Long.valueOf(1));

        assertNotNull(launches);
    }

    @Test
    public void testPersistLaunch() {
        Launch launch = this.launchService.persist(new Launch());

        assertNotNull(launch);
    }
}
