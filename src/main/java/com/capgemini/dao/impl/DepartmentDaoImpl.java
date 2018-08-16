package com.capgemini.dao.impl;

import com.capgemini.dao.DepartmentDao;
import com.capgemini.dto.DepartmentDTO;
import com.capgemini.entity.AbstractEntity;
import com.capgemini.entity.DepartmentEntity;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentDaoImpl extends AbstractDao<DepartmentEntity,Long>implements DepartmentDao {
}
