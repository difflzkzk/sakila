package Dao;

import java.sql.Connection;

import Vo.Stats;

public class StatsDao {
		// rs.next()������ true, ������ false
		public boolean selectDay(Connection conn, Stats stats) throws Exception {
			/*
			if(rs.next()){
				return true; // update
			}
			*/
			return false; // insert
		}
		//
		public void insertStats(Connection conn, Stats stats) throws Exception {
			
		}
		//
		public void updateStats(Connection conn) throws Exception {
			
		}
	}

