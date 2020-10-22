package service;

public class StatsQuery {
	public static final String SELECT_STATS = "SELECT * FROM stats WHERE day=?"; //¿œ∫∞
	public static final String INSERT_STATS = "INSERT INTO stats(day, count) VALUES(?, 1)";
	public static final String UPDATE_STATS = "UPDATE stats SET count=count+1 WHERE day=?";
	public static final String SELECT_SUM_STATS = "SELECT count FROM stats ";
	
}
