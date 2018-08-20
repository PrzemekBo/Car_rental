package com.capgemini.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "employees")
public class EmployeeEntity extends AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(length = 30, nullable = false)
    private String firstName;

    @Column(length = 35, nullable = false)
    private String lastName;

    @NotNull
    private Date birthDate;


    @Column(nullable = false)
    private String profession;


    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private DepartmentEntity departmentId;



    @ManyToMany
    private List<CarEntity> cars;




/*
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profession", nullable = false)
    private ProfessionEntity profession;
*/





/*
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentEntity;
*/


/*
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "supervisor",
            joinColumns = { @JoinColumn(name = "employee", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "car", nullable = false, updatable = false)})
    private List<CarEntity> cars;
*/



/*
    public void addCar(CarEntity carEntity) {
        this.cars.add(carEntity);
    }


*/



}
