package es.salesianos.repository;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import es.salesianos.model.Kindle;
import es.salesianos.model.User;

@Component
public class KindleRepository {

	private static Logger log = LogManager.getLogger(KindleRepository.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insert(Kindle kindleFormulario) {
		log.debug("el log funciona");
		String sql = "INSERT INTO KINDLES (serial,model,inches)" + "VALUES ( :serial, :model, :inches)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("serial", kindleFormulario.getSerial());
		params.addValue("model", kindleFormulario.getModel());
		params.addValue("inches", kindleFormulario.getInches());
		namedJdbcTemplate.update(sql, params);
	}

	public Optional<User> search(User user) {
		String sql = "SELECT * FROM USER WHERE dni = ?";
		log.debug("ejecutando la consulta: " + sql);
		User person = null;
		try {
			person = (User) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(User.class), user.getDni());
		} catch (EmptyResultDataAccessException e) {
			log.error("error", e);
		}
		return Optional.ofNullable(person);

	}

	public void update(User user) {
		String sql = "UPDATE user SET " + "nombre = ?, apellido = ? WHERE dni = ?";
		jdbcTemplate.update(sql, user.getNombre(), user.getApellido(), user.getDni());
	}

	public List<Kindle> listAllKindles() {
		String sql = "SELECT * FROM KINDLES";
		List<Kindle> kindles = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Kindle.class));
		return kindles;
	}

	public void delete(String tablename, Integer id) {
		// log.debug("id: " + id.toString());
		log.debug("tablename: " + tablename);
		String sql = "DELETE FROM " + tablename + " WHERE dni = '?'";
		log.debug(sql);
		// jdbcTemplate.update(sql, id.toString());
	}


}
