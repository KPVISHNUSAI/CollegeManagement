package com.example.collegeDirectory.service;

import com.example.collegeDirectory.entity.Department;
import com.example.collegeDirectory.exception.ResourceNotFoundException;
import com.example.collegeDirectory.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department departmentDetails) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

        department.setName(departmentDetails.getName());
        department.setDescription(departmentDetails.getDescription());
        
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        departmentRepository.delete(department);
    }

    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with name: " + name));
    }
}
