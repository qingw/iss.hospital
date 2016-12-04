package vut.fit.iss;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vut.fit.iss.domain.other.Department;
import vut.fit.iss.domain.other.MedicalHistory;
import vut.fit.iss.domain.user.Patient;
import vut.fit.iss.domain.user.PatientStatus;
import vut.fit.iss.domain.user.UserRole;
import vut.fit.iss.domain.user.account.Account;
import vut.fit.iss.domain.user.staff.Administrator;
import vut.fit.iss.domain.user.staff.Doctor;
import vut.fit.iss.domain.user.staff.Nurse;
import vut.fit.iss.service.other.DepartmentService;
import vut.fit.iss.service.other.MedicalHistoryService;
import vut.fit.iss.service.user.PatientService;
import vut.fit.iss.service.user.UserService;
import vut.fit.iss.service.user.account.AccountService;
import vut.fit.iss.service.user.stuff.AdministratorService;
import vut.fit.iss.service.user.stuff.DoctorService;
import vut.fit.iss.service.user.stuff.NurseService;

import java.util.Date;

@Configuration
@SpringBootApplication
public class HospitalApplication {


    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner init(final UserService userService, final AccountService accountService, final DepartmentService departmentService, final MedicalHistoryService medicalHistoryService, final DoctorService doctorService, final NurseService nurseService, final PatientService patientService, AdministratorService administratorService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... arg0) throws Exception {

                departmentService.persist(new Department("ASD"));
                departmentService.persist(new Department("FDA"));
                administratorService.persist(new Administrator("Vasya", "Ivan", new Date(), "1654846456", "fdsfdsfds5f5ds4f54ds65f4ds654f6sd", UserRole.ADMIN, accountService.persist(new Account("admin", "admin"))));
                Doctor doctor = doctorService.persist(new Doctor("Petya", "Ivan", new Date(), "4324324", "sdfgsdfgsdfgsdfgdf", UserRole.DOCTOR, accountService.persist(new Account("doctor", "doctor")), departmentService.persist(new Department("ABC"))));
                nurseService.persist(new Nurse("Masha", "Ivan", new Date(), "432434324", "gfdgdsfgsdfgsfdg", UserRole.NURSE, accountService.persist(new Account("nurse", "nurse"))));
                Patient patient = patientService.persist(new Patient("Dasha", "Ivan", new Date(), "5465464564", "gfdgfdgsdfgdfgfd", UserRole.PATIENT, accountService.persist(new Account("patient", "patient")), PatientStatus.HEALTHY, "asdasdsd"));

                medicalHistoryService.persist(new MedicalHistory(patient,doctor,"фывывфы","ыфвывфы" ));
                medicalHistoryService.persist(new MedicalHistory(patient,doctor,"231231","ewqewqeq" ));
                medicalHistoryService.persist(new MedicalHistory(patient,doctor,"dsaddas","r34324" ));
            }

        };

    }
}


