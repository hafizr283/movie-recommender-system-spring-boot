package io.datajek.springdatajdbc.tennis_player;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomJdbcTemplate extends JdbcTemplate {
    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper,Object... args){
        List<T> results = new ArrayList<>();
        try(Connection connection=getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        ){
            if(args!=null){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                }
            }
            try(ResultSet rs = ps.executeQuery()){
                int rowNum = 0;
                while(rs.next()){
                    T maapedObject = rowMapper.mapRow(rs,rowNum);
                    results.add(maapedObject);
                    rowNum++;
                }
            }
        }catch (SQLException e){
            throw getExceptionTranslator().translate("Custom Query Execution", sql, e);
        }

        return  results;
    }
}
