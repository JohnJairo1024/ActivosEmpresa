package com.activos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.activos.beans.Emp;
import com.activos.beans.Persona;

public class PersonaDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Persona persona) {
		String sql = "insert into persona(nombre,apellidos,direccion,edad) values('" + persona.getNombre() + "',"
				+ persona.getApellidos() + ",'" + persona.getDireccion() + "'," + persona.getEdad() + "')";
		return template.update(sql);
	}

	public int update(Persona persona) {
		String sql = "update persona set nombre='" + persona.getNombre() + "'," + persona.getApellidos() + ",'"
				+ persona.getDireccion() + "'," + persona.getEdad() + "' where id=" + persona.getIdPersona() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from persona where idPersona=" + id + "";
		return template.update(sql);
	}

	public Persona getEmpById(int id) {
		String sql = "select * from persona where idPersona=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Persona>(Persona.class));
	}

	public List<Persona> obtenerPersonas() {
		return template.query("select * from persona", new RowMapper<Persona>() {
			public Persona mapRow(ResultSet rs, int row) throws SQLException {
				Persona persona = new Persona();
				persona.setIdPersona(rs.getInt(1));
				persona.setNombre(rs.getString(2));
				persona.setApellidos(rs.getString(3));
				persona.setDireccion(rs.getString(4));
				persona.setEdad(rs.getString(5));
				return persona;
			}
		});
	}

}
