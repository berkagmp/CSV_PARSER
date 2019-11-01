package derek.test.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "report")
@Table(name = "report")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "date", columnDefinition = "TIMESTAMP")
	private LocalDateTime date;

	@Column(name = "pm", nullable = false, length = 30)
	private String pm;

	@Column(name = "type", nullable = false, length = 2)
	private String type;

	@Column(name = "current_ma_min", nullable = true)
	private Integer current_ma_min;

	@Column(name = "current_ma_max", nullable = true)
	private Integer current_ma_max;

	@Column(name = "current_ma_avg", nullable = true)
	private Integer current_ma_avg;

	@Column(name = "voltage_v_min", nullable = true)
	private Integer voltage_v_min;

	@Column(name = "voltage_v_max", nullable = true)
	private Integer voltage_v_max;

	@Column(name = "voltage_v_avg", nullable = true)
	private Integer voltage_v_avg;

	@Column(name = "pfe_return_current_ma_min", nullable = true)
	private Integer pfe_return_current_ma_min;

	@Column(name = "pfe_return_current_ma_max", nullable = true)
	private Integer pfe_return_current_ma_max;

	@Column(name = "pfe_return_current_ma_avg", nullable = true)
	private Integer pfe_return_current_ma_avg;

	@Column(name = "pfe_station_ground_current_ma_min", nullable = true)
	private Integer pfe_station_ground_current_ma_min;

	@Column(name = "pfe_station_ground_current_ma_max", nullable = true)
	private Integer pfe_station_ground_current_ma_max;

	@Column(name = "pfe_station_ground_current_ma_avg", nullable = true)
	private Integer pfe_station_ground_current_ma_avg;

	@Column(name = "pfe_ocean_ground_voltage_v_min", nullable = true)
	private Integer pfe_ocean_ground_voltage_v_min;

	@Column(name = "pfe_ocean_ground_voltage_v_max", nullable = true)
	private Integer pfe_ocean_ground_voltage_v_max;

	@Column(name = "pfe_ocean_ground_voltage_v_avg", nullable = true)
	private Integer pfe_ocean_ground_voltage_v_avg;

	@Column(name = "pfe_ocean_ground_res1_ma_min", nullable = true)
	private Integer pfe_ocean_ground_res1_ma_min;

	@Column(name = "pfe_ocean_ground_res1_ma_max", nullable = true)
	private Integer pfe_ocean_ground_res1_ma_max;

	@Column(name = "pfe_ocean_ground_res1_ma_avg", nullable = true)
	private Integer pfe_ocean_ground_res1_ma_avg;

	@Column(name = "pfe_ocean_ground_res2_ma_min", nullable = true)
	private Integer pfe_ocean_ground_res2_ma_min;

	@Column(name = "pfe_ocean_ground_res2_ma_max", nullable = true)
	private Integer pfe_ocean_ground_res2_ma_max;

	@Column(name = "pfe_ocean_ground_res2_ma_avg", nullable = true)
	private Integer pfe_ocean_ground_res2_ma_avg;

	@Column(name = "converter_temperature_c_min", nullable = true)
	private Integer converter_temperature_c_min;

	@Column(name = "converter_temperature_c_max", nullable = true)
	private Integer converter_temperature_c_max;

	@Column(name = "converter_temperature_c_avg", nullable = true)
	private Integer converter_temperature_c_avg;

	public Report() {

	}

	public Report(LocalDateTime date, String pm, String type) {
		super();
		this.date = date;
		this.pm = pm;
		this.type = type;
	}
}
