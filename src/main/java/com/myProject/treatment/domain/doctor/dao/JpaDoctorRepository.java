package com.myProject.treatment.domain.doctor.dao;

import com.myProject.treatment.domain.doctor.Doctor;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaDoctorRepository implements DoctorRepository{

    private final EntityManager em;

    public JpaDoctorRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        em.persist(doctor);
        return doctor;
    }

    @Override
    public Optional<Doctor> findById(Long doctorId) {
        Doctor doctor = em.find(Doctor.class, doctorId);
        return Optional.ofNullable(doctor);
    }

    @Override
    public Optional<Doctor> findByDoctorId(String doctorId) {
        List<Doctor> resultList = em.createQuery("select d from Doctor d where d.doctorId = :doctorId", Doctor.class)
                .setParameter("doctorId", doctorId)
                .getResultList();
        return resultList.stream().findAny();
    }

    @Override
    public List<Doctor> findAllDoctor() {
        return em.createQuery("select d from Doctor d", Doctor.class)
                .getResultList();
    }

}
