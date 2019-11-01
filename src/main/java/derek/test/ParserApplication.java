package derek.test;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

import derek.test.entity.Report;
import derek.test.repository.ReportRepository;

@SpringBootApplication
@Profile("!test")
public class ParserApplication implements CommandLineRunner {

	@Autowired 
	ReportRepository reportRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ParserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int lineNumber = 0;
		String line = "";
		String identifier = ",";

		String filename = "28-Oct-2019.csv";

		String[] arr = null;
		ArrayList<Report> list = new ArrayList<>();

		Report report = null;

		Function<String, Integer> convert = (val) -> {
			return val.trim().equals("NO DATA") ? null : Integer.parseInt(val);
		};

		int idx = 1;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm");
		
		try (BufferedReader br = new BufferedReader(
				new FileReader(new ClassPathResource(filename).getFile().getAbsolutePath()))) {
			while ((line = br.readLine()) != null) {
				if (lineNumber++ > 6) {
					report = new Report();
					
					arr = line.split(identifier);
					idx = 1;
					
					report.setDate(LocalDateTime.parse(arr[idx++], formatter));
					report.setPm(arr[idx++]);
					report.setType(arr[idx++]);
					report.setCurrent_ma_min(convert.apply(arr[idx++]));
					report.setCurrent_ma_max(convert.apply(arr[idx++]));
					report.setCurrent_ma_avg(convert.apply(arr[idx++]));
					report.setVoltage_v_min(convert.apply(arr[idx++]));
					report.setVoltage_v_max(convert.apply(arr[idx++]));
					report.setVoltage_v_avg(convert.apply(arr[idx++]));
					report.setPfe_return_current_ma_min(convert.apply(arr[idx++]));
					report.setPfe_return_current_ma_max(convert.apply(arr[idx++]));
					report.setPfe_return_current_ma_avg(convert.apply(arr[idx++]));
					report.setPfe_station_ground_current_ma_min(convert.apply(arr[idx++]));
					report.setPfe_station_ground_current_ma_max(convert.apply(arr[idx++]));
					report.setPfe_station_ground_current_ma_avg(convert.apply(arr[idx++]));
					report.setPfe_ocean_ground_voltage_v_min(convert.apply(arr[idx++]));
					report.setPfe_ocean_ground_voltage_v_max(convert.apply(arr[idx++]));
					report.setPfe_ocean_ground_voltage_v_avg(convert.apply(arr[idx++]));
					report.setPfe_ocean_ground_res1_ma_min(convert.apply(arr[idx++]));
					report.setPfe_ocean_ground_res1_ma_max(convert.apply(arr[idx++]));
					report.setPfe_ocean_ground_res1_ma_avg(convert.apply(arr[idx++]));
					report.setPfe_ocean_ground_res2_ma_min(convert.apply(arr[idx++]));
					report.setPfe_ocean_ground_res2_ma_max(convert.apply(arr[idx++]));
					report.setPfe_ocean_ground_res2_ma_avg(convert.apply(arr[idx++]));
					report.setConverter_temperature_c_min(convert.apply(arr[idx++]));
					report.setConverter_temperature_c_max(convert.apply(arr[idx++]));
					report.setConverter_temperature_c_avg(convert.apply(arr[idx++]));

					list.add(report);
				}
			}
			
//			list.forEach(obj -> System.out.println(obj.toString()));
			reportRepository.saveAll(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
