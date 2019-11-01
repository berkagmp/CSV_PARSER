package derek.test.repository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import derek.test.entity.Report;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional()
@Rollback(true)
class ReportRepositoryTest {

	@Autowired
	ReportRepository reportRepository;

	@Test
	public void saveAllTest() {

		int count = reportRepository.findAll().size();

		Report r1 = new Report(LocalDateTime.now(), "T5.HHHH.PFE 1.Converter4", "G1");
		Report r2 = new Report(LocalDateTime.now(), "B1.TTTT.PFE 1.Converter2", "G3");
		Report r3 = new Report(LocalDateTime.now(), "T4.UUUU.PFE 1", "G4");

		List<Report> reports = Arrays.asList(r1, r2, r3);

		reportRepository.saveAll(reports);
		
		assertEquals(count + 3, reportRepository.findAll().size());
	}

}
