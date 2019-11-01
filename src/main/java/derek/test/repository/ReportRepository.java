package derek.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import derek.test.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {

}
