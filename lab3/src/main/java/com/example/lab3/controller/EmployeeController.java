package com.example.lab3.controller;

import com.example.lab3.entity.Employee;
import com.example.lab3.entity.Job_history;
import com.example.lab3.repository.EmployeeRepository;
import com.example.lab3.repository.JobRepository;
import com.example.lab3.repository.Job_historyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    final EmployeeRepository employeeRepository;
    final JobRepository jobRepository;
    final Job_historyRepository job_historyRepository;

    public EmployeeController(EmployeeRepository employeeRepository, JobRepository jobRepository, Job_historyRepository job_historyRepository){
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.job_historyRepository = job_historyRepository;
    }

    @GetMapping("/employees")
    public String mostrarEmpleados(Model model){
        List<Employee> lista = employeeRepository.findAll();
        model.addAttribute("lista", lista);
        return "listaEmpleados";
    }

    @GetMapping("/employees/edit/{id}")
    public String editarEmpleado(@PathVariable int id, Model model){
        Optional<Employee> optEmployee = employeeRepository.findById(id);
        if (optEmployee.isPresent()){
            Employee employee = optEmployee.get();
            model.addAttribute("employee", employee);
            return "editarEmpleado";
        }else{
            return "redirect:/employees";
        }
    }

    @PostMapping("/editar")
    public String editarEmp(){

        return "redirect:/employees";
    }

    @GetMapping("/historial")
    public String historialEmpleados(Model model){
        List<Job_history> lista = job_historyRepository.findAll();
        model.addAttribute("lista", lista);
        return "historialEmpleados";
    }

}
