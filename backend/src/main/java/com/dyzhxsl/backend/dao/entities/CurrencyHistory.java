package com.dyzhxsl.backend.dao.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date date;

	private double usd;

	private double cad;

	private double cny;

	@Override
	public String toString() {
		return "CurrencyHistory [id=" + id + ", date=" + date + ", usd=" + usd + ", cad=" + cad + ", cny=" + cny + "]";
	}

}
