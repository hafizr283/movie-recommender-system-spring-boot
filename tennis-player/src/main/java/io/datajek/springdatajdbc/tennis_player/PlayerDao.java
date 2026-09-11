package io.datajek.springdatajdbc.tennis_player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlayerDao {

    JdbcTemplate jdbcTemplate;

    private static final class PlayerMapper implements RowMapper<Player>{
        @Override
        public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player p = new Player();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setBirthDate(rs.getDate("birth_date"));
            p.setNationality(rs.getString("nationality"));
            p.setTitles(rs.getInt("titles"));
            return p;
        }
    }

    public PlayerDao() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("org.h2.Driver");
        source.setUrl("jdbc:h2:mem:testdb");
        source.setUsername("sa");
        source.setPassword("");
        this.jdbcTemplate = new JdbcTemplate(source);
    }

    public List<Player> getAllPlayers(){
        String sql = "select * from player";
        CustomJdbcTemplate customJdbcTemplate=new CustomJdbcTemplate();
        return jdbcTemplate.query(sql,new PlayerMapper());

    }
    public String getPlayerNameById(int id){
        String sql = "select name from player where id=?";
        return jdbcTemplate.queryForObject(sql,String.class,id);
    }
    public int insert(Player p){
        String sql = "insert into player values(?,?,?,?,?)";
     return   jdbcTemplate.update(sql,p.getId(),p.getName(),p.getNationality(),p.getBirthDate(),p.getTitles());
    }
    public int updatePlayer(Player p){
        String sql = "update player set name = ? where id=?";
        return jdbcTemplate.update(sql,p.getName(),p.getId());
    }
    public int deletePlayer(int id){
        String sql = "delete from player where id=?";
        return jdbcTemplate.update(sql,id);
    }
}
