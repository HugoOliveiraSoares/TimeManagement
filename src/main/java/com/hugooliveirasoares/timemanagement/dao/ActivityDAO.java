package com.hugooliveirasoares.timemanagement.dao;

import com.hugooliveirasoares.timemanagement.domain.Activity;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO {

    public void connection(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("CREATE TABLE activities(\n" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "TASK VARCHAR(40),\n" +
                    "INFORMATION VARCHAR(40),\n" +
                    "STARTTIME VARCHAR(40),\n" +
                    "ENDTIME VARCHAR(40),\n" +
                    "DURATION VARCHAR(40),\n" +
                    "DIA DATE\n" +
                    ");");

            stmt.executeUpdate();
            System.out.println("Tabela criada com sucesso!");

        } catch (SQLException throwables) {
            System.out.println("ERRO ao criar a tabela!");
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean save(Activity activity){

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            stmt = con.prepareStatement("INSERT INTO activities(TASK, INFORMATION, STARTTIME, ENDTIME, DURATION, DIA) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, activity.getTask());
            stmt.setString(2, activity.getInformation());
            stmt.setString(3, activity.getStartTime());
            stmt.setString(4, activity.getEndTime());
            stmt.setString(5, activity.getTimeSpent());
            stmt.setDate(6, new Date( dateFormat.parse(activity.getDate()).getTime() ));

            stmt.executeUpdate();
            return true; // Success

        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
            return false; // Error to save
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Activity> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Activity> activityList = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM activities");
            rs = stmt.executeQuery();

            while (rs.next()){
                Activity activity = new Activity();

                activity.setId(rs.getInt("id"));
                activity.setTask(rs.getString("task"));
                activity.setInformation(rs.getString("information"));
                activity.setStartTime(rs.getString("starttime"));
                activity.setEndTime(rs.getString("endtime"));
                activity.setDuration(rs.getString("duration"));
                activity.setDate(String.valueOf(rs.getDate("dia")));
                activityList.add(activity);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return activityList;
    }

    public void update(Activity activity){

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE activities SET descricao = ?, quantidade = ?, preco = ? WHERE id = ?");
            stmt.setString(1, activity.getTask());
            stmt.setString(2, activity.getInformation());
            stmt.setString(3, activity.getStartTime());
            stmt.setString(4, activity.getEndTime());
            stmt.setString(5, activity.getTimeSpent());
            stmt.setInt(6,activity.getId());

            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Atualização falhou!");
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
