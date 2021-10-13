package com.data.jdbc.dao;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//uncomment to enable this CLR
//@Component
public class PupilDaoRunner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	PupilJdbcDao pupilJdbcDao;

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n All pupil Data ->  " + pupilJdbcDao.findAll());
		logger.info("\n pupil Data for 10001 ->  " + pupilJdbcDao.findById(10001));

		logger.info("\n inserting new puil data ->");
		logger.info("rows inserted -> " + pupilJdbcDao.insert(new Pupil(2001, "Amol Dhawale", "Nagpur", new Date())));
		logger.info("rows inserted -> " + pupilJdbcDao.insert(new Pupil(2002, "Priya Pande", "Nagpur", new Date())));
		logger.info("rows inserted -> " + pupilJdbcDao.insert(new Pupil(2003, "Dw Doa", "Us", new Date())));
		logger.info("\n pupil inserted successfully <-");

		logger.info("\n deleting pupil Data for 10001 | rows deleted ->  " + pupilJdbcDao.deleteById(10001));

		logger.info("\n updating pupil data ->");
		logger.info(
				"rows updated -> " + pupilJdbcDao.update(new Pupil(2001, "Dipalini Dhawale", "Mumbai", new Date())));
		logger.info("\n updated pupil data <-");

	}

}
