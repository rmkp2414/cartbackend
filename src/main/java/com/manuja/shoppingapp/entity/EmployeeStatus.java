package com.manuja.shoppingapp.entity;

import javax.persistence.*;

@Entity @Table(name = "employee_status")
public class EmployeeStatus {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   // @OneToOne @JoinColumn(name = "employee_id", referencedColumnName = "id")
   // private Employee employee;
    @Column(name = "active_deact")
    private boolean activeStatus;

    public EmployeeStatus() {
    }

//    @Override
//   public String toString() {
//        return "EmployeeStatus{" +
//                "id=" + id +
//                ", employee=" + employee +
//                ", activeStatus=" + activeStatus +
//                '}';
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
