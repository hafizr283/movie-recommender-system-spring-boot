package io.datajek.springdatajdbc.tennis_player;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class TennisPlayerApplication  {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(TennisPlayerApplication.class, args);
		Practice p = new Practice();
		p.printWord("heello","not hello","hamim","not hamim sldfjsf");
		p.printClassInfo(TennisPlayerApplication.class);
		PlayerDao dao = new PlayerDao();
		Player newPlayer = new Player(
				4,
				"Rafael Nadal",
				"Spain",
				new SimpleDateFormat("dd/MM/yyyy").parse("03/06/1986"),
				22
		);
		System.out.println(dao.getAllPlayers());
		System.out.println(dao.getPlayerNameById(2));
		System.out.println("Insert"+dao.insert(newPlayer));
		newPlayer = new Player(
				4,
				"Hamim",
				"Spain",
				new SimpleDateFormat("dd/MM/yyyy").parse("03/06/1986"),
				22
		);
		System.out.println(dao.updatePlayer(newPlayer));
		System.out.println(dao.deletePlayer(1));

	}


}
